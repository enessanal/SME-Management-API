package com.kz.sme_management.model;

import com.kz.sme_management.controller.BasicEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends BasicEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
}
