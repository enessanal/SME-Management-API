package com.kz.sme_management.model;

import jakarta.persistence.*;
import lombok.*;

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
    @Column(name="accountCode", nullable = false, unique = true)
    private String accountCode;

    @Getter @Setter @NonNull
    @Column(name="fullName")
    private String fullName;

    @Getter @Setter @NonNull
    @Column(name="identityNumber", nullable = false, unique = true)
    private String identityNumber;

    @Getter @Setter @NonNull
    @Column(name="mobilePhone")
    private String mobilePhone;

    @Getter @Setter @NonNull
    @Column(name="email")
    private String email;

    @Getter @Setter
    @Column(name="homePhone")
    private String homePhone;

    @Getter @Setter
    @Column(name="address")
    private String address;

    @Getter @Setter
    @Column(name="deliveryAddress")
    private String deliveryAddress;

    @Getter @Setter
    @Column(name="details")
    private String details;


}
