package com.kz.sme_management.service.product.impl;

import com.kz.sme_management.dto.product.ListProductDto;
import com.kz.sme_management.exception.NotFoundException;
import com.kz.sme_management.model.product.Brand;
import com.kz.sme_management.model.product.Product;
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

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService
{
    private final ProductRepository productRepository;

    @Override
    public Page<ListProductDto> findAll(Map<String, String> allParameters)
    {

        // START - Setting filter parameters
        // -------------------------------------------------------------------------------------- //

        Map<String, String> inFilterParameters = parseRequestParams(allParameters, List.of( "brand","category","type","size"));
        Specification<Product> productSpecification = getProductSpec(inFilterParameters);

        // -------------------------------------------------------------------------------------- //
        // END - Setting filter parameters


        // START - Setting Paging & Sorting parameters
        // -------------------------------------------------------------------------------------- //

        Map<String, String> sortPageParameters = parseRequestParams(allParameters, List.of("pageNumber", "pageSize", "sortBy", "direction"));

        int size = getIntegerValueOrDefault(sortPageParameters.get("pageSize"), List.of(10, 25, 50, 100, 250, 500));

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

        Field[] fields = Product.class.getDeclaredFields();
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

        fields = Product.class.getSuperclass().getDeclaredFields();
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

        System.out.println("======>>>> "+page + " - " + size + " - " + sortBy + " - "+ sortDirection);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sortBy));

        // -------------------------------------------------------------------------------------- //
        // END - Setting Paging & Sorting parameters

        return productRepository.findAll(productSpecification, pageable).map(ListProductDto::new);
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



    // ----------
    private Map<String, String> parseRequestParams(Map<String, String> allParameters, List<String> desiredParamNames)
    {
        return allParameters.entrySet()
                .stream()
                .filter(entry -> desiredParamNames.contains(entry.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Specification<Product> getProductSpec(Map<String, String> inFilterParameters )
    {
        Map<String, List<String>> filterMap = new HashMap<>();
        for(Map.Entry<String,String> filter: inFilterParameters.entrySet())
        {
            filterMap.put(filter.getKey(), Arrays.asList(filter.getValue().split(",")));
        }
        return ProductSpecification.withDynamicFilter(filterMap);
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
