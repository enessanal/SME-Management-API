package com.kz.sme_management.model.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kz.sme_management.model.util.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(callSuper = true)
@Table(name="addresses")
public class Address extends BaseEntity
{

    @Getter @Setter @NonNull
    @Column(name="name", nullable = false)
    private String name;

    @Getter @Setter @NonNull
    @Column(name="city")
    private String city;

    @Getter @Setter @NonNull
    @Column(name="district")
    private String district;

    @Getter @Setter @NonNull
    @Column(name="details")
    private String details;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="customer_id")
    @JsonBackReference
    private Customer customer;

}
