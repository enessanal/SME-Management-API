package com.kz.sme_management.service.product.impl;

import com.kz.sme_management.dto.product.ListProductDto;
import com.kz.sme_management.exception.NotFoundException;
import com.kz.sme_management.model.customer.Customer;
import com.kz.sme_management.model.product.Brand;
import com.kz.sme_management.model.product.Product;
import com.kz.sme_management.model.util.Paging;
import com.kz.sme_management.repository.product.ProductRepository;
import com.kz.sme_management.service.ProductSpecification;
import com.kz.sme_management.service.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService
{
    private final ProductRepository productRepository;

    @Override
    public Page<ListProductDto> findAll(Map<String,String> parameters)
    {

        String[] filteringWhiteList = new String[]{
                "brand",
                "category",
                "type",
                "size"
        };

        String[] sortingWhiteList = new String[]{
                "page",
                "size",
                "sortBy",
                "direction"
        };

        // START: CLEAR ALL UNACCEPTABLE PARAMETERS
        // ********************************************************************************

        Map<String, String> filterParameters = new HashMap<>();
        for (String key : filteringWhiteList)
        {
            if (parameters.containsKey(key))
            {
                filterParameters.put(key, parameters.get(key));
            }
        }

        Map<String, String> sortingParameters = new HashMap<>();
        for (String key : sortingWhiteList)
        {
            if (parameters.containsKey(key))
            {
                sortingParameters.put(key, parameters.get(key));
            }
        }

        // ********************************************************************************
        // END: CLEAR ALL UNACCEPTABLE PARAMETERS




        // START - Buradaki işlemler ayrı bir sınıfa alınacak ve düzenlenecek.
        // --------------------------------------------------------------------------------
        // --------------------------------------------------------------------------------
        // --------------------------------------------------------------------------------
        // --------------------------------------------------------------------------------
        // --------------------------------------------------------------------------------
        // --------------------------------------------------------------------------------
        // --------------------------------------------------------------------------------
//
//        int[] sizes = new int[]{10, 25, 50, 100, 250};
//        int defaultSize = sizes[0];
//
//        int inputSize = defaultSize;
//        try
//        {
//            inputSize = Integer.parseInt(sortingParameters.get("size"));
//        }
//        catch (NumberFormatException e)
//        {
//            inputSize = defaultSize;
//        }
//        final int inputSizeFinal = inputSize;
//        int size = IntStream.of(sizes).anyMatch(number -> number == inputSizeFinal) ? inputSize : defaultSize;
//
//
//
//
//        int page = 0;
//        try
//        {
//            page = Integer.parseInt(sortingParameters.get("page"));
//            page = Math.max(page, 0);
//        }
//        catch (NumberFormatException e)
//        {
//            page = 0;
//        }
//
//
//        List<String> fieldsList = new ArrayList<>();
//        Field[] fields = Product.class.getDeclaredFields();
//        for(Field field : fields)
//        {
//            fieldsList.add(field.getName());
//        }
//
//
//        String sortBy = sortingParameters.get("sortBy");
//
//        if (!fieldsList.contains(sortBy))
//        {
//            sortBy = "updatedTime";
//        }
//
//        Sort.Direction sortDirection = sortingParameters.get("direction") == null ?  Sort.Direction.ASC :
//                (sortingParameters.get("direction").equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC);
//
//        // Eğer sortBy field verilmediyse updatedTime'a göre sıralayacak. En son değişen ürünlerin gelmesini istiyoruz.
//        if( ! sortingParameters.containsKey("sortBy"))
//            sortDirection = Sort.Direction.DESC;

        // --------------------------------------------------------------------------------
        // --------------------------------------------------------------------------------
        // --------------------------------------------------------------------------------
        // --------------------------------------------------------------------------------
        // --------------------------------------------------------------------------------
        // --------------------------------------------------------------------------------
        // END - Buradaki işlemler ayrı bir sınıfa alınacak ve düzenlenecek.


        int page = Integer.parseInt(parameters.get("page"));
        int size = Integer.parseInt(parameters.get("size"));
        Sort.Direction sortDirection = parameters.get("direction").equalsIgnoreCase("desc") ? Sort.Direction.DESC: Sort.Direction.ASC;
        String sortBy = parameters.get("sortBy");




        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));
        pageable = PageRequest.of(1, 10, Sort.by(Sort.Direction.ASC, "ccPrice"));
        Map<String, List<String>> filterMap = new HashMap<>();

        for(Map.Entry<String,String> filter: filterParameters.entrySet())
        {
            filterMap.put(filter.getKey(), Arrays.asList(filter.getValue().split(",")));
        }

        Specification<Product> spec = ProductSpecification.withDynamicFilter(filterMap);

        return productRepository.findAll(spec, pageable).map(ListProductDto::new);
    }

    @Override
    public Product findById(String id)
    {
        return productRepository.findById(id).orElseThrow( () -> new NotFoundException("Invalid product id"));
    }

    @Override
    public List<Product> findProductsByBrand(Brand brand)
    {
        return productRepository.findProductsByBrand(brand);
    }
}
