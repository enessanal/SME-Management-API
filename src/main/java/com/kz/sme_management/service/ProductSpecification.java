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
import java.util.stream.Collectors;


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


/*
@RequiredArgsConstructor
public class ProductSpecification implements Specification<Product> {

    private final SearchCriteria criteria;




    @Override
    public Predicate toPredicate
            (Root<Product> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return builder.greaterThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return builder.lessThanOrEqualTo(
                    root.<String> get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if (root.get(criteria.getKey()).getJavaType() == String.class) {
                return builder.in(
                        root.<String>get(criteria.getKey())).value(criteria.getValue().toString());
            } else {
                return builder.equal(root.get(criteria.getKey()), criteria.getValue());
            }
        }
        return null;
    }
}*/