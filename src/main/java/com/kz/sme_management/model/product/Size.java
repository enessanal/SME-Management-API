package com.kz.sme_management.model.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kz.sme_management.model.util.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
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
    @JsonManagedReference
    @OneToMany(mappedBy="size")
    private List<Product> products;

}
