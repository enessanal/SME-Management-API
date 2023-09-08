package com.kz.sme_management.model.contract;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.kz.sme_management.model.employee.Employee;
import com.kz.sme_management.model.customer.Customer;
import com.kz.sme_management.model.sale.PaymentMethod;
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
    private String id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    private String address;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "contract")
    @JsonManagedReference
    private List<CartItem> cart;

    private PaymentMethod paymentMethod;

}