package com.kz.sme_management.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kz.sme_management.model.util.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="categories")
@ToString(callSuper = true)
@RequiredArgsConstructor
public class Category extends BaseEntity
{
    @Getter @Setter @NonNull
    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Getter @Setter
    @ToString.Exclude
    @JsonBackReference
    @OneToMany(mappedBy="category")
    private List<Product> products;
}
