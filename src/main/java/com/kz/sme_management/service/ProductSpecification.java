package com.kz.sme_management.service;



import com.kz.sme_management.model.product.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class ProductSpecification {

    public static Specification<Product> withDynamicFilter(Map<String, List<String>> filters)
    {
        return new Specification<Product>()
        {
            @Override
            public Predicate toPredicate(Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder)
            {
                List<Predicate> predicates = new ArrayList<>();
                filters.forEach((key, values) ->
                {
                    if (values != null && !values.isEmpty())
                    {
                        values = values.stream().map(v->v.toUpperCase(new Locale("tr","TR"))).toList();
                        predicates.add(root.get(key).get("name").in(values));
                    }
                });
                return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}