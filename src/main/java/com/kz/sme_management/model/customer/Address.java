package com.kz.sme_management.model.customer;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="addresses")
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", updatable = false, nullable = false)
    @Getter
    private String id;

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

    @Getter
    @Column(name="created_time", updatable = false)
    @CreationTimestamp
    private Date createdTime;

    @Getter
    @UpdateTimestamp
    @Column(name="updated_time")
    private Date updatedTime;

    @Getter @Setter
    @ManyToOne
    @JoinColumn(name="customer_id")
    @JsonBackReference
    private Customer customer;

}
