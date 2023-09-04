package com.kz.sme_management.controller;

import com.kz.sme_management.model.Employee;
import com.kz.sme_management.repository.employee.EmployeeRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${PATH_EMPLOYEES}")
@Tag(name = "Employees", description = "Employee Management APIs")
public class EmployeeController extends BasicController<Employee, Long> {
    public EmployeeController(EmployeeRepository employeeRepository) {
        super(employeeRepository, "Employee");
    }
}
