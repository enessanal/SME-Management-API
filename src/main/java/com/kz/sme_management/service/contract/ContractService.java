package com.kz.sme_management.service.contract;

import com.kz.sme_management.exception.NotFoundException;
import com.kz.sme_management.model.contract.CartItem;
import com.kz.sme_management.model.contract.Contract;
import com.kz.sme_management.model.product.Product;
import com.kz.sme_management.repository.contract.CartRepository;
import com.kz.sme_management.repository.contract.ContractRepository;
import com.kz.sme_management.repository.employee.EmployeeRepository;
import com.kz.sme_management.service.customer.IAddressService;
import com.kz.sme_management.service.customer.ICustomerService;
import com.kz.sme_management.service.product.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class ContractService {

    private static final CartItemMapper cartItemMapper = CartItemMapper.INSTANCE;
    private final ContractRepository contractRepository;
    private final ICustomerService customerService;
    private final IProductService productService;
    private final CartRepository cartRepository;
    private final IAddressService addressService;
    private final EmployeeRepository employeeRepository;

    public Page<Contract> findAll(Map<String, String> parameters, int page, @Valid int size, String direction, String[] sortBy) {
        Page<Contract> result;
        Sort.Direction sortDirection;
        try {
            sortDirection = Sort.Direction.fromString(direction);
        } catch (IllegalArgumentException e) {
            log.error("Invalid sorting direction! Default value (asc) will be used. Valid values are 'asc' and 'desc'.");
            sortDirection = Sort.Direction.ASC;
        }

        if (size > 100) {
            log.error("Invalid page size! Default value '100' will be used.");
        }

        if (page != 0)
            page--;

        Pageable paging = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));

        Map<String, List<String>> filterMap = new HashMap<>();
        for (Map.Entry<String, String> filter : parameters.entrySet()) {
            filterMap.put(filter.getKey(), Arrays.asList(filter.getValue().split(",")));
        }
        Specification<Contract> spec = ContractSpecification.withDynamicFilter(filterMap);
        result = contractRepository.findAll(spec, paging);

        return Objects.requireNonNull(result);
    }

    @Transactional
    public Contract save(ContractDTO contractDTO) {


        Contract contract = new Contract();
        contract.setCustomer(customerService.findById(contractDTO.getCustomerId()));
        contract.setEmployee(employeeRepository.findById(contractDTO.getEmployeeId()).orElseThrow(() -> new NotFoundException("Invalid Employee id")));
        contract.setPaymentMethod(contractDTO.getPaymentMethod());
        contract.setAddress(addressService.findById(contractDTO.getAddressId()));
        List<CartItem> cartItems = contractDTO.getCart().stream().map(cartItemDTO -> {

            Product product = productService.findById(cartItemDTO.getProductId());
            if (product == null) {
                log.error("Product with id {} not found", cartItemDTO.getProductId());
            } else {
                CartItem cartItem = cartItemMapper.toCartItem(product);
                cartItem.setCount(cartItemDTO.getCount());
                cartItem.setContract(contract);
                cartItem.setReferenceProduct(product);
                cartRepository.save(cartItem);
                return cartItem;
            }
            return null;
        }).toList();

        contract.setCart(cartItems);

        return contractRepository.save(contract);

    }

    public Contract findById(String id) {
        return contractRepository.findById(id).orElseThrow();
    }
}
