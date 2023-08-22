package com.kz.sme_management;

import com.github.javafaker.Faker;
import com.kz.sme_management.dto.customer.AddAddressDto;
import com.kz.sme_management.model.customer.Address;
import com.kz.sme_management.model.customer.Customer;
import com.kz.sme_management.model.util.Paging;
import com.kz.sme_management.repository.customer.CustomerRepository;
import com.kz.sme_management.service.customer.impl.CustomerService;
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
	private final CustomerService customerService;

	@Bean
	CommandLineRunner initDatabase()
	{
		return args ->
		{
			Faker faker = new Faker();

			// ********************************************************
			List<Customer> customers = new ArrayList<>();
			for (int i = 0; i < 100; i++) {
				try {
					String code = Integer.toString(faker.number().numberBetween(15_000, 99_000));
					String tc = Integer.toString(faker.number().numberBetween(1_000_000_00, 2_000_000_000));

					Customer customer = new Customer(code, faker.name().fullName(), tc, faker.phoneNumber().cellPhone(), faker.internet().emailAddress());
					customer.setDetails(faker.lorem().sentence());
					customers.add(customer);
				} catch (Exception exception) {
					System.out.println(exception);
				}
			}
			customerRepository.saveAll(customers);
			// ********************************************************

			Customer customer = customerRepository.findAll().get(0);


			for(int i=0; i<4; i++)
			{
				AddAddressDto addAddressDto = new AddAddressDto();
				addAddressDto.setCity(faker.address().city());
				addAddressDto.setDetails(faker.address().fullAddress());
				addAddressDto.setDistrict(faker.address().state());
				addAddressDto.setName(faker.name().name());
				customerService.addAddress(addAddressDto, customer.getId());
			}




		};
	}
}
