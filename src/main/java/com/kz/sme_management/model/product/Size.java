package com.kz.sme_management.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kz.sme_management.model.util.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name="sizes")
@ToString(callSuper = true)
@RequiredArgsConstructor
public class Size extends BaseEntity
{
    @Getter @Setter @NonNull
    @Column(name="name", nullable = false, unique = true)
    private String name;

    @Getter @Setter
    @ToString.Exclude
    @JsonBackReference
    @OneToMany(mappedBy="size")
    private List<Product> products;

}
