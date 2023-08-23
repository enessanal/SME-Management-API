package com.kz.sme_management.model.product;

import com.kz.sme_management.model.util.BaseEntity;
import lombok.*;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="brands")
@ToString
public class Brand
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", updatable = false, nullable = false)
    @Getter
    private String id;

    @Getter @Setter
    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Getter @Setter
    @Column(name="list_discount_rate", nullable = false)
    private BigDecimal listDiscountRate;

    @Getter @Setter
    @Column(name="profit_rate", nullable = false)
    private BigDecimal profitRate;

    @Getter @Setter
    @Column(name="profit_min_rate", nullable = false)
    private BigDecimal profitMinRate;

    @Getter @Setter
    @Column(name="profit_max_rate", nullable = false)
    private BigDecimal profitMaxRate;

    @Getter @Setter
    @Column(name="profit_cc_rate", nullable = false)
    private BigDecimal ccRate;

    @Getter @Setter
    @ToString.Exclude
    @JsonManagedReference
    @OneToMany(mappedBy="brand")
    private List<Product> products;

    @Getter
    @Column(name="created_time", updatable = false)
    @CreationTimestamp
    private Date createdTime;

    @Getter
    @UpdateTimestamp
    @Column(name="updated_time")
    private Date updatedTime;

}
