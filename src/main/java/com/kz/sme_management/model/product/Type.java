package com.kz.sme_management.model.product;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name="product_types")
public class Type
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
    @ToString.Exclude
    @JsonManagedReference
    @OneToMany(mappedBy="type")
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
