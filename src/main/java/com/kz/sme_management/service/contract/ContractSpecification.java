package com.kz.sme_management.service.contract;


import com.kz.sme_management.model.contract.Contract;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;


public class ContractSpecification {

    public static Specification<Contract> withDynamicFilter(Map<String, List<String>> filters) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            filters.forEach((key, values) ->
            {
                if (values != null && !values.isEmpty()) {
                    values = values.stream().map(v -> v.toUpperCase(new Locale("tr", "TR"))).toList();
                    if (key.equals("startDate")) {
                        predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("deliveryDate"), values.get(0)));
                    } else if (key.equals("endDate")) {
                        predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("deliveryDate"), values.get(0)));
                    } else {
                        predicates.add(root.get(key).in(values));
                    }
                }
            });
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}