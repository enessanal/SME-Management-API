package com.kz.sme_management.dto.customer;

import com.kz.sme_management.model.customer.Customer;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Field;

@Getter @Setter
public class ListCustomerDto
{
    private String id;
    private String accountCode;
    private String fullName;
    private String identityNumber;
    private String mobilePhone;
    private String email;

    public ListCustomerDto(Customer customer)
    {
        Class<Customer> customerClass = Customer.class;
        Class<ListCustomerDto> customerListDtoClass =  ListCustomerDto.class;

        Field[] customerFields = customerClass.getDeclaredFields();
        Field[] customerListFields = customerListDtoClass.getDeclaredFields();

        for (Field customerField : customerFields)
        {
            for(Field customerListField : customerListFields)
            {
                if(customerField.getName().equals(customerListField.getName()))
                {
                    try
                    {
                        customerField.setAccessible(true);
                        customerListField.setAccessible(true);
                        Object value = customerField.get(customer);
                        customerListField.set(this, value);
                    }
                    catch (IllegalAccessException e)
                    {
                        System.out.println(e);
                    }
                    break;
                }
            }

        }
    }
}
