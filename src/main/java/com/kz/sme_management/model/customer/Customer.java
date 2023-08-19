package com.kz.sme_management.model.customer;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@Table(name="customers")
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id", updatable = false, nullable = false)
    @Getter
    private String id;

    @Getter @Setter @NonNull
    @Column(name="account_code", nullable = false, unique = true)
    private String accountCode;

    @Getter @Setter @NonNull
    @Column(name="full_name")
    private String fullName;

    @Getter @Setter @NonNull
    @Column(name="identity_number", nullable = false, unique = true)
    private String identityNumber;

    @Getter @Setter @NonNull
    @Column(name="mobile_phone")
    private String mobilePhone;

    @Getter @Setter @NonNull
    @Column(name="email")
    private String email;

    @Getter @Setter
    @Column(name="home_phone")
    private String homePhone;

    @Getter @Setter
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
    @JsonManagedReference
    @OneToMany(mappedBy="customer")
    private List<Address> addresses;
}