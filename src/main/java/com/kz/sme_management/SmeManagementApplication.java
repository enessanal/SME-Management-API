package com.kz.sme_management;

import com.github.javafaker.Faker;
import com.kz.sme_management.dto.customer.AddAddressDto;
import com.kz.sme_management.model.customer.Address;
import com.kz.sme_management.model.customer.Customer;
import com.kz.sme_management.model.product.*;
import com.kz.sme_management.model.util.Paging;
import com.kz.sme_management.repository.customer.CustomerRepository;
import com.kz.sme_management.repository.product.*;
import com.kz.sme_management.service.customer.impl.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class SmeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmeManagementApplication.class, args);
	}


//	private final CustomerRepository customerRepository;
//	private final CustomerService customerService;
	private final BrandRepository brandRepository;
	private final ProductRepository productRepository;

	private final CategoryRepository categoryRepository;
	private final SizeRepository sizeRepository;
	private final TypeRepository typeRepository;



	@Bean
	CommandLineRunner initDatabase()
	{
		return args ->
		{
			Brand brand = new Brand();
			brand.setName("BEKO");

			brand.setListDiscountRate(BigDecimal.valueOf(40));
			brand.setProfitRate(BigDecimal.valueOf(70));
			brand.setProfitMinRate(BigDecimal.valueOf(65));
			brand.setProfitMaxRate(BigDecimal.valueOf(100));
			brand.setCcRate(BigDecimal.valueOf(7.5));
			Brand tmpBrand = brandRepository.save(brand);


			Type type = new Type();
			type.setName("YATAK");

			Category category = new Category();
			category.setName("BEYAZ ESYA");

			Size size = new Size();
			size.setName("150x200");

			categoryRepository.save(category);
			typeRepository.save(type);
			sizeRepository.save(size);


			Product product = new Product();
			product.setCode("SMN-2231");
			product.setListPrice(BigDecimal.valueOf(24_500));
			product.setName("BEKO Kahve Makinesi Beyaz");
			product.setStock(0);


			product.setColor("BLACK");


			product.setBrand(brand);
			product.setType(type);
			product.setCategory(category);
			product.setSize(size);



			Product p =  productRepository.save(product);

			System.out.println(productRepository.findById(p.getId()));

			tmpBrand.setListDiscountRate(BigDecimal.valueOf(40));

			Brand updatedBrand = brandRepository.save(tmpBrand);


			List<Product> products = productRepository.findByBrand(updatedBrand);
			for (Product pr : products)
			{
				pr.calculatePrices();
				productRepository.save(pr);
			}


//			Product lastProduct  = productRepository.findById(p.getId()).get();
//			lastProduct.setListPrice(BigDecimal.valueOf(1));
//
//			productRepository.save(lastProduct);


			System.out.println(brand.getId());


			System.out.println(productRepository.findById(p.getId()));




//			Faker faker = new Faker();
//
//			List<Customer> customers = new ArrayList<>();
//			for (int i = 0; i < 100; i++) {
//				try {
//					String code = Integer.toString(faker.number().numberBetween(15_000, 99_000));
//					String tc = Integer.toString(faker.number().numberBetween(1_000_000_00, 2_000_000_000));
//
//					Customer customer = new Customer(code, faker.name().fullName(), tc, faker.phoneNumber().cellPhone(), faker.internet().emailAddress());
//					customer.setDetails(faker.lorem().sentence());
//					customers.add(customer);
//				} catch (Exception exception) {
//					System.out.println(exception);
//				}
//			}
//			customerRepository.saveAll(customers);
//
//			Customer customer = customerRepository.findAll().get(0);
//			for(int i=0; i<4; i++)
//			{
//				AddAddressDto addAddressDto = new AddAddressDto();
//				addAddressDto.setCity(faker.address().city());
//				addAddressDto.setDetails(faker.address().fullAddress());
//				addAddressDto.setDistrict(faker.address().state());
//				addAddressDto.setName(faker.name().name());
//				customerService.addAddress(addAddressDto, customer.getId());
//			}




		};
	}
}
