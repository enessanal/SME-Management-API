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


	private final CustomerRepository customerRepository;
	private final CustomerService customerService;
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
			categoryRepository.save(new Category("BEYAZ EŞYA"));
			categoryRepository.save(new Category("MOBİLYA"));
			categoryRepository.save(new Category("AKSESUAR"));
			categoryRepository.save(new Category("TEKSTİL"));

			typeRepository.save(new Type("BAZA"));
			typeRepository.save(new Type("YEMEK ODASI TAKIMI"));
			typeRepository.save(new Type("OTURMA GRUBU"));
			typeRepository.save(new Type("DOLAP"));
			typeRepository.save(new Type("MUTFAK MASA SANDALYE TAKIMLARI"));
			typeRepository.save(new Type("GENÇ ODASI"));
			typeRepository.save(new Type("AADENEME"));
			typeRepository.save(new Type("YATAK ODASI TAKIMI"));
			typeRepository.save(new Type("BERJER"));
			typeRepository.save(new Type("BAŞLIK"));
			typeRepository.save(new Type("KANEPE"));
			typeRepository.save(new Type("SANDALYE"));
			typeRepository.save(new Type("MASA"));
			typeRepository.save(new Type("GENÇ ODASI TAKIMI"));
			typeRepository.save(new Type("TV SEHPASI"));
			typeRepository.save(new Type("AÇIK HAVA MOBİLYALARI"));
			typeRepository.save(new Type("SEHPALAR"));
			typeRepository.save(new Type("BAZA SETİ"));
			typeRepository.save(new Type("LAMBADERLER"));
			typeRepository.save(new Type("PLAZMA ÜNİTESİ DUVAR ÜNİTESİ"));
			typeRepository.save(new Type("ŞİFONYER"));
			typeRepository.save(new Type("KÖŞE TAKIMI"));
			typeRepository.save(new Type("ABAJURLAR"));
			typeRepository.save(new Type("KONSOL"));
			typeRepository.save(new Type("BEŞİK"));
			typeRepository.save(new Type("PORTMANTO"));
			typeRepository.save(new Type("ÇALIŞMA MASASI"));
			typeRepository.save(new Type("YAŞAM ODASI TAKIMI"));
			typeRepository.save(new Type("KİTAPLIK"));
			typeRepository.save(new Type("BENÇ"));
			typeRepository.save(new Type("GENÇ ODASI SANDALYELERİ"));
			typeRepository.save(new Type("YASTIK"));
			typeRepository.save(new Type("ASKI"));
			typeRepository.save(new Type("BAHÇE TAKIMI"));
			typeRepository.save(new Type("DRESUAR-AYNA"));
			typeRepository.save(new Type("BEBEK ODASI TAKIMI"));
			typeRepository.save(new Type("EKMEKLİK"));
			typeRepository.save(new Type("KOMODİN"));
			typeRepository.save(new Type("PUF & TV KOLTUKLARI"));
			typeRepository.save(new Type("YATAK"));
			typeRepository.save(new Type("AYAKKABILIK"));
			typeRepository.save(new Type("ADET"));
			typeRepository.save(new Type("AKSESUAR"));
			typeRepository.save(new Type("KUMAŞ"));
			typeRepository.save(new Type("VİTRİN"));
			typeRepository.save(new Type("FİSKOS"));
			typeRepository.save(new Type("YORGAN"));
			typeRepository.save(new Type("KOMİDİN"));
			typeRepository.save(new Type("KIRLENT"));
			typeRepository.save(new Type("EV TEKSTİLİ"));
			typeRepository.save(new Type("RANZA"));
			typeRepository.save(new Type("ALEZ"));
			typeRepository.save(new Type("MASASI"));
			typeRepository.save(new Type("BALKON MOBİLYASI"));
			typeRepository.save(new Type("TAKIMI"));
			typeRepository.save(new Type("PUF"));
			typeRepository.save(new Type("TV SEHPALARI"));

			brandRepository.save(new Brand("AHMUR", 		40, 70, 65, 100,  	7.5));
			brandRepository.save(new Brand("ARNO", 			30, 50, 45, 100,  	7.5));
			brandRepository.save(new Brand("BELLONA", 		2, 40, 30, 100,		7.5));
			brandRepository.save(new Brand("EKOL", 			20, 50, 45, 100,  	7.5));
			brandRepository.save(new Brand("ERTAŞ", 		10, 50, 45, 100,  	7.5));
			brandRepository.save(new Brand("İMAJ MOBİLYA",  30, 60, 55, 100,  	7.5));
			brandRepository.save(new Brand("LUXEV", 		30, 60, 55, 100,  	7.5));
			brandRepository.save(new Brand("ÖNDER", 		0, 60, 55, 100,  	7.5));
			brandRepository.save(new Brand("RAHAT", 		0, 50, 45, 100,  	7.5));
			brandRepository.save(new Brand("VESPERO", 		0, 50, 45, 100,  	7.5));
			brandRepository.save(new Brand("YEŞİLEGE",		0, 25, 25, 100,  	7.5));

			sizeRepository.save(new Size("100 CM"));
			sizeRepository.save(new Size("120 CM"));
			sizeRepository.save(new Size("130 CM"));
			sizeRepository.save(new Size("140 CM"));
			sizeRepository.save(new Size("150 CM"));
			sizeRepository.save(new Size("160 CM"));
			sizeRepository.save(new Size("180 CM"));
			sizeRepository.save(new Size("200 CM"));
			sizeRepository.save(new Size("90 CM"));
			sizeRepository.save(new Size("100 X 190"));
			sizeRepository.save(new Size("100 X 200"));
			sizeRepository.save(new Size("120 X 190"));
			sizeRepository.save(new Size("120 X 200"));
			sizeRepository.save(new Size("130 X 190"));
			sizeRepository.save(new Size("140 X 190"));
			sizeRepository.save(new Size("140 X 200"));
			sizeRepository.save(new Size("150 X 190"));
			sizeRepository.save(new Size("150 X 200"));
			sizeRepository.save(new Size("160 X 190"));
			sizeRepository.save(new Size("160 X 200"));
			sizeRepository.save(new Size("180 X 200"));
			sizeRepository.save(new Size("200 X 200"));
			sizeRepository.save(new Size("50 X 90"));
			sizeRepository.save(new Size("60 X 120"));
			sizeRepository.save(new Size("70 X 110"));
			sizeRepository.save(new Size("70 X 120"));
			sizeRepository.save(new Size("70 X 130"));
			sizeRepository.save(new Size("70 X 140"));
			sizeRepository.save(new Size("75 X 160"));
			sizeRepository.save(new Size("80 X 130"));
			sizeRepository.save(new Size("80 X 180"));
			sizeRepository.save(new Size("80 X 190"));
			sizeRepository.save(new Size("80 X 200"));
			sizeRepository.save(new Size("90 X 190"));
			sizeRepository.save(new Size("90 X 200"));
			sizeRepository.save(new Size("90 X 185"));



			productRepository.save(new Product("ARNO_SOFT16","ARNO_SOFT16",4802,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_SOFT22","ARNO_SOFT22",1450,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_SOFT23","ARNO_SOFT23",7179,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_SOFT28","ARNO_SOFT28",1354,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("70 X 140").get()));
			productRepository.save(new Product("ARNO_SOFT31","ARNO_SOFT31",1521,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("75 X 160").get()));
			productRepository.save(new Product("ARNO_SOFT43","ARNO_SOFT43",4504,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_SOFT44","ARNO_SOFT44",8730,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_SOFT46","ARNO_SOFT46",6848,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_SOFT47","ARNO_SOFT47",2011,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_STAR02","ARNO_STAR02",9725,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_STAR03","ARNO_STAR03",3968,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_STAR04","ARNO_STAR04",1414,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_STAR07","ARNO_STAR07",31090,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_STAR09","ARNO_STAR09",3808,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YEMEK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_STAR13","ARNO_STAR13",1816,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YEMEK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_STAR14","ARNO_STAR14",1091,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YEMEK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_STAR17","ARNO_STAR17",5850,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YEMEK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_TREND06","ARNO_TREND06",2507,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_TREND07","ARNO_TREND07",3014,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_TREND11","ARNO_TREND11",6150,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_TREND14","ARNO_TREND14",2423,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_TREND16","ARNO_TREND16",2642,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_URLA11","ARNO_URLA11",8950,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_URLA12","ARNO_URLA12",5796,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_URLA15","ARNO_URLA15",4104,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_URLA19","ARNO_URLA19",2100,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_URLA22","ARNO_URLA22",2950,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_URLA23","ARNO_URLA23",689,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_URLA26","ARNO_URLA26",2403,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BEŞİK").get(), sizeRepository.findByName("75 X 160").get()));
			productRepository.save(new Product("ARNO_UZAY01","ARNO_UZAY01",20538,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_UZAY04","ARNO_UZAY04",4313,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_UZAY05","ARNO_UZAY05",3758,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_UZAY07","ARNO_UZAY07",3167,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_UZAY09","ARNO_UZAY09",1714,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_WALL07","ARNO_WALL07",4228,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get(), sizeRepository.findByName("120 CM").get()));
			productRepository.save(new Product("BELL_20PLI4M","BELL_20PLI4M",3470.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get()));
			productRepository.save(new Product("BELL_222TWJY7201000053","BELL_222TWJY7201000053",670,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("100 CM").get()));
			productRepository.save(new Product("BELL_228CAPR100202I","BELL_228CAPR100202I",10117.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 200").get()));
			productRepository.save(new Product("BELL_26BLLMM","BELL_26BLLMM",3952.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("200 CM").get()));
			productRepository.save(new Product("BELL_26ESYHH","BELL_26ESYHH",3865.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("150 CM").get()));
			productRepository.save(new Product("BELL_26ESYMM","BELL_26ESYMM",4427.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("200 CM").get()));
			productRepository.save(new Product("BELL_26FROHH","BELL_26FROHH",3587.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("150 CM").get()));
			productRepository.save(new Product("BELL_26FROII","BELL_26FROII",3703.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("160 CM").get()));
			productRepository.save(new Product("BELL_26FROMM","BELL_26FROMM",4125.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("200 CM").get()));
			productRepository.save(new Product("BELL_26HENBB","BELL_26HENBB",918.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("90 CM").get()));
			productRepository.save(new Product("BELL_26HENEE01","BELL_26HENEE01",636,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("120 CM").get()));
			productRepository.save(new Product("BELL_26HENFF","BELL_26HENFF",1058.1,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("130 CM").get()));
			productRepository.save(new Product("BELL_26HENGG","BELL_26HENGG",1187.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("140 CM").get()));
			productRepository.save(new Product("BELL_26HENII","BELL_26HENII",1287.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("160 CM").get()));
			productRepository.save(new Product("BELL_26HENKK","BELL_26HENKK",1379.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("180 CM").get()));
			productRepository.save(new Product("BELL_26HENMM","BELL_26HENMM",1450,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("200 CM").get()));
			productRepository.save(new Product("BELL_26HENMM01","BELL_26HENMM01",904,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("200 CM").get()));
			productRepository.save(new Product("BELL_26HESBB01","BELL_26HESBB01",570,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("90 CM").get()));
			productRepository.save(new Product("BELL_26HESCC","BELL_26HESCC",958.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("100 CM").get()));
			productRepository.save(new Product("BELL_26HESCC01","BELL_26HESCC01",595,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("100 CM").get()));
			productRepository.save(new Product("BELL_26HESEE","BELL_26HESEE",1023.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("120 CM").get()));
			productRepository.save(new Product("BELL_26HESFF","BELL_26HESFF",1058.1,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("130 CM").get()));
			productRepository.save(new Product("BELL_26HESGG01","BELL_26HESGG01",746,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("140 CM").get()));
			productRepository.save(new Product("BELL_26HESHH01","BELL_26HESHH01",762,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("150 CM").get()));
			productRepository.save(new Product("BELL_26HESII","BELL_26HESII",1287.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("160 CM").get()));
			productRepository.save(new Product("BELL_26HESII01","BELL_26HESII01",798,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("160 CM").get()));
			productRepository.save(new Product("BELL_26HESMM","BELL_26HESMM",1450,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("200 CM").get()));
			productRepository.save(new Product("BELL_26HESMM01","BELL_26HESMM01",904,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("200 CM").get()));
			productRepository.save(new Product("BELL_26LNSBB","BELL_26LNSBB",1807.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("90 CM").get()));
			productRepository.save(new Product("BELL_26LNSFF","BELL_26LNSFF",2245.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("130 CM").get()));
			productRepository.save(new Product("BELL_26LNSII","BELL_26LNSII",2478.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("160 CM").get()));
			productRepository.save(new Product("BELL_26NRLEE","BELL_26NRLEE",2162,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("120 CM").get()));
			productRepository.save(new Product("BELL_26NRLGG","BELL_26NRLGG",2387.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("140 CM").get()));
			productRepository.save(new Product("BELL_26NRLHH","BELL_26NRLHH",2392.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("150 CM").get()));
			productRepository.save(new Product("BELL_26NRLII","BELL_26NRLII",2522.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("160 CM").get()));
			productRepository.save(new Product("BELL_26PSXHH","BELL_26PSXHH",2346,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("150 CM").get()));
			productRepository.save(new Product("BELL_26PSXII","BELL_26PSXII",2413,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("160 CM").get()));
			productRepository.save(new Product("BELL_26PSXKK","BELL_26PSXKK",2567,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("180 CM").get()));
			productRepository.save(new Product("BELL_26PTRBB","BELL_26PTRBB",1562.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("90 CM").get()));
			productRepository.save(new Product("BELL_26PTRMM","BELL_26PTRMM",2800.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("200 CM").get()));
			productRepository.save(new Product("BELL_26PTXCC","BELL_26PTXCC",1624.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("100 CM").get()));
			productRepository.save(new Product("BELL_26PTXEE","BELL_26PTXEE",1868.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("120 CM").get()));
			productRepository.save(new Product("BELL_26PTXII","BELL_26PTXII",2277.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("160 CM").get()));
			productRepository.save(new Product("BELL_26TOABB","BELL_26TOABB",1127.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("90 CM").get()));
			productRepository.save(new Product("BELL_26TOAEE","BELL_26TOAEE",1295.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("120 CM").get()));
			productRepository.save(new Product("BELL_26TOAKK","BELL_26TOAKK",1765.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("180 CM").get()));
			productRepository.save(new Product("BELL_26TWJBB00100003","BELL_26TWJBB00100003",550,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("90 CM").get()));
			productRepository.save(new Product("BELL_26VLRGG","BELL_26VLRGG",2068,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("140 CM").get()));
			productRepository.save(new Product("BELL_26VRSHH","BELL_26VRSHH",1482.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("150 CM").get()));
			productRepository.save(new Product("BELL_26VRSII","BELL_26VRSII",1544.1,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("160 CM").get()));
			productRepository.save(new Product("BELL_26VRSKK","BELL_26VRSKK",1704.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("180 CM").get()));
			productRepository.save(new Product("BELL_26VRSMM","BELL_26VRSMM",1741.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("200 CM").get()));
			productRepository.save(new Product("BELL_26VZSEE","BELL_26VZSEE",1424,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("120 CM").get()));
			productRepository.save(new Product("BELL_26VZSFF","BELL_26VZSFF",1543,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("130 CM").get()));
			productRepository.save(new Product("BELL_26VZSHH","BELL_26VZSHH",1670,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("150 CM").get()));
			productRepository.save(new Product("BELL_26VZSKK","BELL_26VZSKK",1926,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("180 CM").get()));
			productRepository.save(new Product("BELL_27AAP00801900H00","BELL_27AAP00801900H00",3069.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 190").get()));
			productRepository.save(new Product("BELL_27AAP01001900H00","BELL_27AAP01001900H00",3503.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 190").get()));

			productRepository.save(new Product("BELL_27AAP01202000H00","BELL_27AAP01202000H00",4139.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("120 X 200").get()));
			productRepository.save(new Product("BELL_27AAP01301900H00","BELL_27AAP01301900H00",4281.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("130 X 190").get()));
			productRepository.save(new Product("BELL_27AAP01602000H00","BELL_27AAP01602000H00",5218.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 200").get()));
			productRepository.save(new Product("BELL_27AAP01802000H00","BELL_27AAP01802000H00",5722.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("180 X 200").get()));
			productRepository.save(new Product("BELL_27AFC00801900400","BELL_27AFC00801900400",4258.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 190").get()));
			productRepository.save(new Product("BELL_27AFC00901900400","BELL_27AFC00901900400",4682.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 190").get()));
			productRepository.save(new Product("BELL_27AFC01001900400","BELL_27AFC01001900400",5059.1,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 190").get()));
			productRepository.save(new Product("BELL_27AFC01201900400","BELL_27AFC01201900400",5997.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("120 X 190").get()));
			productRepository.save(new Product("BELL_27AFC01502000400","BELL_27AFC01502000400",7617.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("150 X 200").get()));
			productRepository.save(new Product("BELL_27AFC01802000400","BELL_27AFC01802000400",8934.1,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("180 X 200").get()));
			productRepository.save(new Product("BELL_27AFC02002000400","BELL_27AFC02002000400",9879.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("200 X 200").get()));
			productRepository.save(new Product("BELL_27BAL00601200500","BELL_27BAL00601200500",1363.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("60 X 120").get()));
			productRepository.save(new Product("BELL_27BEA00802000H00","BELL_27BEA00802000H00",3492.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 200").get()));
			productRepository.save(new Product("BELL_27BEA00901900H00","BELL_27BEA00901900H00",3638.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 190").get()));
			productRepository.save(new Product("BELL_27BEA00902000H00","BELL_27BEA00902000H00",3774.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 200").get()));
			productRepository.save(new Product("BELL_27BEA01001900H00","BELL_27BEA01001900H00",3801.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 190").get()));
			productRepository.save(new Product("BELL_27BEA01002000H00","BELL_27BEA01002000H00",3969.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 200").get()));
			productRepository.save(new Product("BELL_27BEA01201900H00","BELL_27BEA01201900H00",4331.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("120 X 190").get()));
			productRepository.save(new Product("BELL_27BEA01502000H00","BELL_27BEA01502000H00",5387.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("150 X 200").get()));
			productRepository.save(new Product("BELL_27BEA01601900H00","BELL_27BEA01601900H00",5458.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 190").get()));
			productRepository.save(new Product("BELL_27BKD01401900400","BELL_27BKD01401900400",8818.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 190").get()));
			productRepository.save(new Product("BELL_27BKD01602000400","BELL_27BKD01602000400",10104.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 200").get()));
			productRepository.save(new Product("BELL_27BKD01802000400","BELL_27BKD01802000400",11242.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("180 X 200").get()));
			productRepository.save(new Product("BELL_27BMS00801800400","BELL_27BMS00801800400",4629.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 180").get()));
			productRepository.save(new Product("BELL_27BMS00902000400","BELL_27BMS00902000400",5459.1,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 200").get()));
			productRepository.save(new Product("BELL_27BMS01301900400","BELL_27BMS01301900400",6840.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("130 X 190").get()));
			productRepository.save(new Product("BELL_27BMS01402000400","BELL_27BMS01402000400",7588.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 200").get()));
			productRepository.save(new Product("BELL_27BMS01602000400","BELL_27BMS01602000400",8434.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 200").get()));
			productRepository.save(new Product("BELL_27BMS01802000400","BELL_27BMS01802000400",9276.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("180 X 200").get()));
			productRepository.save(new Product("BELL_27CAP00801900200","BELL_27CAP00801900200",1800,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 190").get()));
			productRepository.save(new Product("BELL_27CAP01002000200","BELL_27CAP01002000200",2184.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 200").get()));
			productRepository.save(new Product("BELL_27CAP01202000200","BELL_27CAP01202000200",2606.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("120 X 200").get()));
			productRepository.save(new Product("BELL_27CAP01301900200","BELL_27CAP01301900200",2868.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("130 X 190").get()));
			productRepository.save(new Product("BELL_27CAP01402000200","BELL_27CAP01402000200",3124.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 200").get()));
			productRepository.save(new Product("BELL_27CAP01602000200","BELL_27CAP01602000200",3397,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 200").get()));
			productRepository.save(new Product("BELL_27CAP01802000200","BELL_27CAP01802000200",3903.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("180 X 200").get()));
			productRepository.save(new Product("BELL_27COL00701400000","BELL_27COL00701400000",1915.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("70 X 140").get()));
			productRepository.save(new Product("BELL_27COL00801800000","BELL_27COL00801800000",2234.1,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 180").get()));
			productRepository.save(new Product("BELL_27COL01002000000","BELL_27COL01002000000",2796.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 200").get()));
			productRepository.save(new Product("BELL_27CPC00902000700","BELL_27CPC00902000700",6128,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 200").get()));
			productRepository.save(new Product("BELL_27CPC01201900700","BELL_27CPC01201900700",7198.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("120 X 190").get()));
			productRepository.save(new Product("BELL_27CPC01402000700","BELL_27CPC01402000700",8372,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 200").get()));
			productRepository.save(new Product("BELL_27CPC01601900700","BELL_27CPC01601900700",9026.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 190").get()));
			productRepository.save(new Product("BELL_27CPC01602000700","BELL_27CPC01602000700",9362.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 200").get()));
			productRepository.save(new Product("BELL_27CPC02002000700","BELL_27CPC02002000700",11104.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("200 X 200").get()));
			productRepository.save(new Product("BELL_27CPS00901900400","BELL_27CPS00901900400",5210.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 190").get()));
			productRepository.save(new Product("BELL_27CPS00902000400","BELL_27CPS00902000400",5478.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 200").get()));
			productRepository.save(new Product("BELL_27CPS01201900400","BELL_27CPS01201900400",6607.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("120 X 190").get()));
			productRepository.save(new Product("BELL_27CPS01301900400","BELL_27CPS01301900400",7052.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("130 X 190").get()));
			productRepository.save(new Product("BELL_27CPS01401900400","BELL_27CPS01401900400",7458.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 190").get()));
			productRepository.save(new Product("BELL_27CPS01601900400","BELL_27CPS01601900400",8175.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 190").get()));
			productRepository.save(new Product("BELL_27CPS01802000400","BELL_27CPS01802000400",9144.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("180 X 200").get()));
			productRepository.save(new Product("BELL_27CTP00901900500","BELL_27CTP00901900500",1612.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 190").get()));
			productRepository.save(new Product("BELL_27CTP01301900500","BELL_27CTP01301900500",2124.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("130 X 190").get()));
			productRepository.save(new Product("BELL_27CTP01401900500","BELL_27CTP01401900500",2199.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 190").get()));
			productRepository.save(new Product("BELL_27CTP01502000500","BELL_27CTP01502000500",2331.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("150 X 200").get()));
			productRepository.save(new Product("BELL_27CTP01601900500","BELL_27CTP01601900500",2379.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 190").get()));
			productRepository.save(new Product("BELL_27DRB01001900400","BELL_27DRB01001900400",4731.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 190").get()));
			productRepository.save(new Product("BELL_27DRB01502000400","BELL_27DRB01502000400",6908.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("150 X 200").get()));
			productRepository.save(new Product("BELL_27DRB01601900400","BELL_27DRB01601900400",7029.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 190").get()));
			productRepository.save(new Product("BELL_27DRC00902000400","BELL_27DRC00902000400",5961.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 200").get()));
			productRepository.save(new Product("BELL_27DRC01002000400","BELL_27DRC01002000400",6397.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 200").get()));
			productRepository.save(new Product("BELL_27DRC01201900400","BELL_27DRC01201900400",7206.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("120 X 190").get()));
			productRepository.save(new Product("BELL_27DRC01401900400","BELL_27DRC01401900400",8290.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 190").get()));
			productRepository.save(new Product("BELL_27DRC01601900400","BELL_27DRC01601900400",9237.1,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 190").get()));
			productRepository.save(new Product("BELL_27DRC02002000400","BELL_27DRC02002000400",11347.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("200 X 200").get()));
			productRepository.save(new Product("BELL_27ECP00901900000","BELL_27ECP00901900000",968,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 190").get()));
			productRepository.save(new Product("BELL_27ECP01002000000","BELL_27ECP01002000000",1062,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 200").get()));
			productRepository.save(new Product("BELL_27ECP01602000000","BELL_27ECP01602000000",1678,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 200").get()));
			productRepository.save(new Product("BELL_27EGF00801800700","BELL_27EGF00801800700",2765.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 180").get()));
			productRepository.save(new Product("BELL_27EGF01402000700","BELL_27EGF01402000700",4395.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 200").get()));
			productRepository.save(new Product("BELL_27EGF01502000700","BELL_27EGF01502000700",4801.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("150 X 200").get()));
			productRepository.save(new Product("BELL_27EGF01601900700","BELL_27EGF01601900700",4883.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 190").get()));
			productRepository.save(new Product("BELL_27EGF01802000700","BELL_27EGF01802000700",5372,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("180 X 200").get()));
			productRepository.save(new Product("BELL_27EGF02002000700","BELL_27EGF02002000700",5862.1,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("200 X 200").get()));
			productRepository.save(new Product("BELL_27GLC00801800400","BELL_27GLC00801800400",3865,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 180").get()));
			productRepository.save(new Product("BELL_27GLC00901900400","BELL_27GLC00901900400",4475,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 190").get()));
			productRepository.save(new Product("BELL_27GLC00902000400","BELL_27GLC00902000400",4628,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 200").get()));
			productRepository.save(new Product("BELL_27GLC01001900400","BELL_27GLC01001900400",4828,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 190").get()));
			productRepository.save(new Product("BELL_27GLC01002000400","BELL_27GLC01002000400",5068,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 200").get()));
			productRepository.save(new Product("BELL_27GLC01401900400","BELL_27GLC01401900400",6336,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 190").get()));
			productRepository.save(new Product("BELL_27GLC01501900400","BELL_27GLC01501900400",6800,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("150 X 190").get()));
			productRepository.save(new Product("BELL_27GLS00801800H00","BELL_27GLS00801800H00",2302,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 180").get()));
			productRepository.save(new Product("BELL_27GLS00802000H00","BELL_27GLS00802000H00",2512,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 200").get()));
			productRepository.save(new Product("BELL_27GLS00902000H00","BELL_27GLS00902000H00",2757,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 200").get()));
			productRepository.save(new Product("BELL_27GLS01002000H00","BELL_27GLS01002000H00",2949,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 200").get()));
			productRepository.save(new Product("BELL_27GLS01601900H00","BELL_27GLS01601900H00",4212,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 190").get()));
			productRepository.save(new Product("BELL_27GLS02002000H00","BELL_27GLS02002000H00",5212,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("200 X 200").get()));
			productRepository.save(new Product("BELL_27HND00701300200","BELL_27HND00701300200",1164.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("70 X 130").get()));
			productRepository.save(new Product("BELL_27HND00801900200","BELL_27HND00801900200",1534.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 190").get()));
			productRepository.save(new Product("BELL_27HND00901900200","BELL_27HND00901900200",1663.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 190").get()));
			productRepository.save(new Product("BELL_27HND01002000200","BELL_27HND01002000200",1838.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 200").get()));
			productRepository.save(new Product("BELL_27HND01202000200","BELL_27HND01202000200",2078.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("120 X 200").get()));
			productRepository.save(new Product("BELL_27HND01401900200","BELL_27HND01401900200",2256.1,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 190").get()));
			productRepository.save(new Product("BELL_27HND01402000200","BELL_27HND01402000200",2312.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 200").get()));
			productRepository.save(new Product("BELL_27HND01502000200","BELL_27HND01502000200",2392.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("150 X 200").get()));
			productRepository.save(new Product("BELL_27HND01601900200","BELL_27HND01601900200",2534.1,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 190").get()));
			productRepository.save(new Product("BELL_27HND01602000200","BELL_27HND01602000200",2560.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 200").get()));
			productRepository.save(new Product("BELL_27KJN00801900400","BELL_27KJN00801900400",5609.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 190").get()));
			productRepository.save(new Product("BELL_27KJN00901900400","BELL_27KJN00901900400",6034.1,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 190").get()));
			productRepository.save(new Product("BELL_27KJN01002000400","BELL_27KJN01002000400",6618.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 200").get()));
			productRepository.save(new Product("BELL_27KJN01202000400","BELL_27KJN01202000400",7576.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("120 X 200").get()));
			productRepository.save(new Product("BELL_27KJN01401900400","BELL_27KJN01401900400",8400,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 190").get()));
			productRepository.save(new Product("BELL_27KJN01502000400","BELL_27KJN01502000400",9073.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("150 X 200").get()));
			productRepository.save(new Product("BELL_27KJN01602000400","BELL_27KJN01602000400",9490.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 200").get()));
			productRepository.save(new Product("BELL_27KJN01802000400","BELL_27KJN01802000400",10442.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("180 X 200").get()));
			productRepository.save(new Product("BELL_27LTP01001900500","BELL_27LTP01001900500",2552.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 190").get()));
			productRepository.save(new Product("BELL_27LTP01002000500","BELL_27LTP01002000500",2628.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 200").get()));
			productRepository.save(new Product("BELL_27LTP01202000500","BELL_27LTP01202000500",3000,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("120 X 200").get()));
			productRepository.save(new Product("BELL_27LTP01802000500","BELL_27LTP01802000500",4344.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("180 X 200").get()));
			productRepository.save(new Product("BELL_27LTP02002000500","BELL_27LTP02002000500",4752.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("200 X 200").get()));
			productRepository.save(new Product("BELL_27MEY00901900H00","BELL_27MEY00901900H00",3360.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 190").get()));
			productRepository.save(new Product("BELL_27MEY01501900H00","BELL_27MEY01501900H00",4901.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("150 X 190").get()));
			productRepository.save(new Product("BELL_27NOS01001900200","BELL_27NOS01001900200",3277.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 190").get()));
			productRepository.save(new Product("BELL_27NOS01002000200","BELL_27NOS01002000200",3434.1,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 200").get()));
			productRepository.save(new Product("BELL_27NOS01201900200","BELL_27NOS01201900200",3950,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("120 X 190").get()));
			productRepository.save(new Product("BELL_27NOS01601900200","BELL_27NOS01601900200",5036.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 190").get()));
			productRepository.save(new Product("BELL_27NOS01602000200","BELL_27NOS01602000200",5204.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 200").get()));
			productRepository.save(new Product("BELL_27NRL00801800400","BELL_27NRL00801800400",3921.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 180").get()));
			productRepository.save(new Product("BELL_27NRL00801900400","BELL_27NRL00801900400",4124.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 190").get()));
			productRepository.save(new Product("BELL_27NRL01002000400","BELL_27NRL01002000400",5080.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 200").get()));
			productRepository.save(new Product("BELL_27NRL01202000400","BELL_27NRL01202000400",5857.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("120 X 200").get()));
			productRepository.save(new Product("BELL_27NRL01301900400","BELL_27NRL01301900400",6112.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("130 X 190").get()));
			productRepository.save(new Product("BELL_27NRL01402000400","BELL_27NRL01402000400",6732.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 200").get()));
			productRepository.save(new Product("BELL_27NRL01501900400","BELL_27NRL01501900400",6880.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("150 X 190").get()));
			productRepository.save(new Product("BELL_27NRL01602000400","BELL_27NRL01602000400",7575,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 200").get()));
			productRepository.save(new Product("BELL_27NRL02002000400","BELL_27NRL02002000400",9296.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("200 X 200").get()));
			productRepository.save(new Product("BELL_27NSR00801900200","BELL_27NSR00801900200",2250,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 190").get()));
			productRepository.save(new Product("BELL_27NSR00902000200","BELL_27NSR00902000200",2474.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 200").get()));
			productRepository.save(new Product("BELL_27NSR01201900200","BELL_27NSR01201900200",2922,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("120 X 190").get()));
			productRepository.save(new Product("BELL_27NSR01301900200","BELL_27NSR01301900200",3164.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("130 X 190").get()));
			productRepository.save(new Product("BELL_27NSR01402000200","BELL_27NSR01402000200",3453.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 200").get()));
			productRepository.save(new Product("BELL_27NSR01601900200","BELL_27NSR01601900200",3687.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("160 X 190").get()));





			Faker faker = new Faker();

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

			Customer customer = customerRepository.findAll().get(0);
			for(int i=0; i<4; i++)
			{
				AddAddressDto addAddressDto = new AddAddressDto();
				addAddressDto.setCity(faker.address().city());
				addAddressDto.setDetails(faker.address().fullAddress());
				addAddressDto.setDistrict(faker.address().state());
				addAddressDto.setName("Ev Adresi - "+(i+1));
				customerService.addAddress(addAddressDto, customer.getId());
			}
		};
	}
}
