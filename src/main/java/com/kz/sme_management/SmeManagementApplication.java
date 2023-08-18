package com.kz.sme_management;

import com.github.javafaker.Faker;
import com.kz.sme_management.model.Customer;
import com.kz.sme_management.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SmeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmeManagementApplication.class, args);
	}


	private final CustomerRepository customerRepository;

	@Bean
	CommandLineRunner initDatabase()
	{
		return args ->
		{
			Faker faker = new Faker();


			List<Customer> customers = new ArrayList<>();
			for(int i=0; i<100; i++)
			{
				try
				{
					String accountCode = Integer.toString(faker.number().numberBetween(10_000_000,90_000_000));
					String tc = Integer.toString(faker.number().numberBetween(10_000_000,90_000_000));

					Customer customer = new Customer(accountCode, faker.name().fullName(),tc,faker.phoneNumber().cellPhone(),faker.internet().emailAddress());
					customer.setAddress(faker.address().fullAddress());
					customer.setDeliveryAddress(faker.address().fullAddress());
					customer.setDetails(faker.lorem().sentence());
					customers.add(customer);
				}
				catch (Exception exception)
				{
					System.out.println(exception.toString());
				}

			}
			customerRepository.saveAll(customers);
		};
	}
}
