package com.kz.sme_management.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kz.sme_management.model.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="sizes")
@ToString(callSuper = true)
public class Size extends BaseEntity
{
    @Getter @Setter
    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Getter @Setter
    @ToString.Exclude
    @JsonBackReference
    @OneToMany(mappedBy="size")
    private List<Product> products;

}
