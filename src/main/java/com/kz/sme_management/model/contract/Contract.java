package com.kz.sme_management.model.contract;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kz.sme_management.model.Employee;
import com.kz.sme_management.model.sale.PaymentMethod;
import com.kz.sme_management.model.customer.Address;
import com.kz.sme_management.model.customer.Customer;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    @Getter
    private String id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "contract")
    @JsonManagedReference
    private List<CartItem> cart;

    private PaymentMethod paymentMethod;

}