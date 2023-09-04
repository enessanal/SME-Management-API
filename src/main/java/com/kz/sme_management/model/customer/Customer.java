package com.kz.sme_management.model.customer;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kz.sme_management.model.util.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString(callSuper = true)
@Table(name = "customers")
public class Customer extends BaseEntity
{
    @Getter
    @Setter
    @NonNull
    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Getter
    @Setter
    @NonNull
    @Column(name = "full_name")
    private String fullName;

    @Getter
    @Setter
    @NonNull
    @Column(name = "identity_number", nullable = false, unique = true)
    private String identityNumber;

    @Getter
    @Setter
    @NonNull
    @Column(name = "mobile_phone")
    private String mobilePhone;

    @Getter
    @Setter
    @NonNull
    @Column(name = "email")
    private String email;

    @Getter
    @Setter
    @Column(name = "home_phone")
    private String homePhone;

    @Getter
    @Setter
    @Column(name = "details")
    private String details;

    @Getter
    @Setter
    @JsonManagedReference
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;
}