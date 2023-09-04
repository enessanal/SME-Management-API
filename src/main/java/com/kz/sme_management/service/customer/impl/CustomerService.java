package com.kz.sme_management.service.customer.impl;


import com.kz.sme_management.dto.customer.AddAddressDto;
import com.kz.sme_management.dto.customer.ListCustomerDto;
import com.kz.sme_management.exception.ConflictException;
import com.kz.sme_management.exception.NotFoundException;
import com.kz.sme_management.exception.UnprocessableException;
import com.kz.sme_management.model.customer.Address;
import com.kz.sme_management.model.customer.Customer;
import com.kz.sme_management.repository.customer.CustomerRepository;
import com.kz.sme_management.service.customer.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService
{
    private final CustomerRepository customerRepository;
    private final AddressService addressService;

    @Override
    public Page<ListCustomerDto> findAll(Map<String, String> allParameters)
    {
        // START - Setting Paging & Sorting parameters
        // -------------------------------------------------------------------------------------- //
        Map<String, String> sortPageParameters = parseRequestParams(allParameters, List.of("pageNumber", "pageSize", "sortBy", "direction"));

        int size = getIntegerValueOrDefault(sortPageParameters.get("pageSize"), List.of(10, 25, 50, 100, 250));

        int page;
        try
        {
            page = Integer.parseInt(sortPageParameters.get("pageNumber"));
            page = Math.max(page, 0);
        }
        catch (NumberFormatException e)
        {
            page = 0;
        }

        Sort.Direction sortDirection = sortPageParameters.containsKey("direction") ?  (sortPageParameters.get("direction").equalsIgnoreCase("desc") ? Sort.Direction.DESC: Sort.Direction.ASC) : Sort.Direction.ASC;

        List<String> sortableFieldsList = new ArrayList<>();

        Field[] fields = Customer.class.getDeclaredFields();
        for(Field field : fields)
        {
            if(field.getType().getName().startsWith("java"))
            {
                sortableFieldsList.add(field.getName());
            }
            else
            {
                sortableFieldsList.add(field.getName()+".name");
            }
        }

        fields = Customer.class.getSuperclass().getDeclaredFields();
        for(Field field : fields)
        {
            if(field.getType().getName().startsWith("java"))
            {
                sortableFieldsList.add(field.getName());
            }
            else
            {
                sortableFieldsList.add(field.getName()+".name");
            }
        }

        String sortBy = sortPageParameters.getOrDefault("sortBy", "updatedTime");
        if (!sortableFieldsList.contains(sortBy))
        {
            sortBy = "updatedTime";
        }

        // Eğer sortBy parametresi boş gelmişse, updatedTime alanına göre DESC olarak sıralıyouz.
        if(!sortPageParameters.containsKey("sortBy"))
        {
            sortDirection = Sort.Direction.DESC;
            sortBy = "updatedTime";
        }

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));

        // -------------------------------------------------------------------------------------- //
        // END - Setting Paging & Sorting parameters

        return customerRepository.findAll(pageable).map(ListCustomerDto::new);
//        return customerRepository.findAll(PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "updatedTime"))).map(ListCustomerDto::new);

    }

    @Override
    public Long count()
    {
        return customerRepository.count();
    }

    @Override
    public Customer findById(String id)
    {
        return customerRepository.findById(id).orElseThrow( () -> new NotFoundException("Invalid customer id"));
    }

    @Override
    public Customer findByCode(String code)
    {
        return customerRepository.findCustomerByCode(code).orElseThrow( () -> new NotFoundException("Invalid customer code"));
    }

    @Override
    public Customer findByIdIdentityNumber(String identityNumber)
    {
        return customerRepository.findCustomerByIdentityNumber(identityNumber).orElseThrow( () -> new NotFoundException("Invalid identity number"));
    }

    @Transactional
    @Override
    public void deleteById(String id)
    {
        if(customerRepository.findById(id).isEmpty()) throw new NotFoundException("Invalid customer id");
        customerRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByCode(String code)
    {
        if(customerRepository.findCustomerByCode(code).isEmpty()) throw new NotFoundException("Invalid customer code");
        customerRepository.deleteCustomerByCode(code);
    }

    @Transactional
    @Override
    public void deleteByIdentityNumber(String identityNumber)
    {
        if(customerRepository.findCustomerByIdentityNumber(identityNumber).isEmpty()) throw new NotFoundException("Invalid customer identity number");
        customerRepository.deleteCustomerByIdentityNumber(identityNumber);
    }

    @Override
    public Address getAddress(String id, String addressId)
    {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Invalid customer id"));

        return customer.getAddresses().stream().filter(address -> address.getId().equals(addressId)).findFirst().orElseThrow(() -> new NotFoundException("Invalid address id"));
    }

    @Override
    public List<Address> getAddresses(String id)
    {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Invalid customer id"));

        return customer.getAddresses();
    }

    @Transactional
    @Override
    public void deleteAddresses(String id)
    {
        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Invalid customer id"));
        addressService.deleteByCustomer(customer);

    }

    @Transactional
    public void addAddress(AddAddressDto addAddressDto, String id)
    {
//        Customer customer = this.findById(id);

        Customer customer = customerRepository.findById(id).orElseThrow(() -> new NotFoundException("Invalid customer id"));

        if(customer.getAddresses().size()>=5)
            throw new UnprocessableException("A customer can have a maximum of 5 addresses.");

        if(customer.getAddresses().stream().anyMatch(address -> address.getName().equals(addAddressDto.getName())))
            throw new ConflictException("Address' name must be unique for a customer.");

        addressService.create(new Address(addAddressDto.getName(), addAddressDto.getCity(), addAddressDto.getDistrict(), addAddressDto.getDetails()), customer);
    }




    // ----------
    private Map<String, String> parseRequestParams(Map<String, String> allParameters, List<String> desiredParamNames)
    {
        return allParameters.entrySet()
                .stream()
                .filter(entry -> desiredParamNames.contains(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }


    private int getIntegerValueOrDefault(String inputString ,List<Integer> values)
    {
        if(inputString == null || inputString.isEmpty()) return values.get(0);
        try
        {
            int value = Integer.parseInt(inputString);
            return values.contains(value) ? value : values.get(0);
        }
        catch(NumberFormatException exception)
        {
            return values.get(0);
        }
    }
}
