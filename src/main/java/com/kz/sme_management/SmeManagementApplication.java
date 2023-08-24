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


			productRepository.save(new Product("BELL_26PSXHH","PESARO S BAŞLIK",2346,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("150 CM").get()));
			productRepository.save(new Product("51ORD60","ORLANDO KOLTUK TAKIMI (3+2+B+B)",33795.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("OTURMA GRUBU").get()));
			productRepository.save(new Product("BELL_28BLLE5","BELLA BAZA",3498.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAZA").get(), sizeRepository.findByName("120 X 190").get()));
			productRepository.save(new Product("AHMR_PORTO04","PORTO KOMODİN (2 ADET)",2350,brandRepository.findByName("AHMUR").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("22LSS3304Y0Y0","LARISSA ZİGON SEHPA",4132.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("SEHPALAR").get()));
			productRepository.save(new Product("BELL_28FROE6","FIERO BAZA",5005.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAZA").get(), sizeRepository.findByName("120 X 200").get()));
			productRepository.save(new Product("ARNO_TREND07","GENÇ TREND ŞİFONYER",3014,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("EKOL_E-7820","NEW GOLDEN BAZA 160*200",5993.62087956463,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAZA").get()));
			productRepository.save(new Product("EKOL_E-7831","NATURAL BAŞLIK 150 LİK FÜME",2864,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get()));
			productRepository.save(new Product("59VLL9900","VELLA MİNİ TAKIM",14751.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("AÇIK HAVA MOBİLYALARI").get()));
			productRepository.save(new Product("20MRS4S","Marses Sehpa",1924.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("SEHPALAR").get()));
			productRepository.save(new Product("BELL_27VSP02002000H00","VALERIA SLEEP",4837,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("200 X 200").get()));
			productRepository.save(new Product("EKOL_E-1577","EKOL TV SEHPASI",530,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("TV SEHPASI").get()));
			productRepository.save(new Product("ARNO_KARŞIYAKA31","KARŞIYAKA Komodin",1087,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("VESP_MOSTAR18","MOSTAR KÖŞE PLUS",20390,brandRepository.findByName("VESPERO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("OTURMA GRUBU").get()));
			productRepository.save(new Product("EKOL_E-6206","TESLA YATAK 180*200",7078,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get()));
			productRepository.save(new Product("BELL_28VRSI5","VERSO-S BAZA AYAKSIZ",5150.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAZA").get(), sizeRepository.findByName("160 X 190").get()));
			productRepository.save(new Product("22MTG3005LDFW","Montego Dolap Modülü",2286.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("PLAZMA ÜNİTESİ DUVAR ÜNİTESİ").get()));
			productRepository.save(new Product("VESP_ARMANİ53","ARMANİ MİDİ KÖŞE PLUS",23355,brandRepository.findByName("VESPERO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("OTURMA GRUBU").get()));
			productRepository.save(new Product("RAHAT_YALIN04","YALIN 3+3+ 1+1 ",20420,brandRepository.findByName("RAHAT").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("OTURMA GRUBU").get()));
			productRepository.save(new Product("RAHAT_ELAGANCE21","ELAGANCE SET",8530,brandRepository.findByName("RAHAT").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAZA SETİ").get(), sizeRepository.findByName("120 X 200").get()));
			productRepository.save(new Product("29VIO9950","VIOLA TEKLİ (2 ADET)",6131.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("AÇIK HAVA MOBİLYALARI").get()));
			productRepository.save(new Product("22VAA30053X4A","Valencia Dolap Modülü",1763,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("PLAZMA ÜNİTESİ DUVAR ÜNİTESİ").get()));
			productRepository.save(new Product("BELL_28VZTI6","VİENZA BAZA",3961,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAZA").get(), sizeRepository.findByName("160 X 200").get()));
			productRepository.save(new Product("EKOL_E-7586","TESLA BAŞLIK 150 LİK FÜME",1898,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get()));
			productRepository.save(new Product("VESP_MARİN COOL15","MARİN COOL BAZA",3575,brandRepository.findByName("VESPERO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAZA").get(), sizeRepository.findByName("120 X 200").get()));
			productRepository.save(new Product("59MSK9901","MOZAIK OVAL MASA TAKIMI",30935.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("AÇIK HAVA MOBİLYALARI").get()));
			productRepository.save(new Product("22LOR2550NGNG","LOREN KONSOL",6301.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YEMEK ODASI TAKIMI").get()));
			productRepository.save(new Product("EKOL_DRM-257","MELODİ BERJER ",2948,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BERJER").get()));
			productRepository.save(new Product("22LEY2400XZXZ","LENY MAKYAJ AYNASI",671.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("VESP_SAFİR05","SAFİR TEKLİ",3170,brandRepository.findByName("VESPERO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BERJER").get()));
			productRepository.save(new Product("VESP_ROYAL16","ROYAL TEKLİ",3000,brandRepository.findByName("VESPERO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BERJER").get()));
			productRepository.save(new Product("ERTAS_DELON14","DELON ÜÇLÜ",14541,brandRepository.findByName("ERTAŞ").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("KANEPE").get()));
			productRepository.save(new Product("ERTAS_BİBLO30","BİBLO YATAK ODASI TAKIMI",37788,brandRepository.findByName("ERTAŞ").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("22LSS2100Y0Y0","LARISSA MAKYAJ MASASI",7360.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("22ALZ2209A1A1","ALVIS 180 LİK KARYOLA KASASI",3173.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_PEARL05","GENÇ PEARL ŞİFONYER AYNASI",1326,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("VESP_MERLİN10","MERLİN TEKLİ PLUS",3930,brandRepository.findByName("VESPERO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BERJER").get()));
			productRepository.save(new Product("LUX_ARMA22","ARMA 3+3+1 TAKIM",30763,brandRepository.findByName("LUXEV").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("OTURMA GRUBU").get()));
			productRepository.save(new Product("ERTAS_CAVANİ22","CAVANİ ORTA RAF",515,brandRepository.findByName("ERTAŞ").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("SEHPALAR").get()));
			productRepository.save(new Product("29ROV9952","ROVER SEHPA",3141.5,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("AÇIK HAVA MOBİLYALARI").get()));
			productRepository.save(new Product("BELL_27AFC00901900400","AURA FRESH CLEAN",4682.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("90 X 190").get()));
			productRepository.save(new Product("ARNO_RÖNESANS27","GENÇ RÖNESANS KOMODİN",1780,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("22ANR2001OPFI","ANDERA SÜRGÜ KAPAKLI GARDIROP",19550,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("BELL_26HESGG01","HENA-S BAŞLIK",746,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("140 CM").get()));
			productRepository.save(new Product("BELL_26LNSFF","LİNDA-S BAŞLIK",2245.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("130 CM").get()));
			productRepository.save(new Product("EKOL_E-5564","ANGEL AHŞAP RANZA CEVİZ 90*190",5930,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("RANZA").get()));
			productRepository.save(new Product("VESP_ORİX02","ORİX ÜÇLÜ YATAKLI",5076,brandRepository.findByName("VESPERO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("KANEPE").get()));
			productRepository.save(new Product("BELL_27OFF01202000800","OFFSET FORM",4682.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("120 X 200").get()));
			productRepository.save(new Product("İMAJ25","NOWAY GOLD  ARA SEHPA",3640,brandRepository.findByName("İMAJ MOBİLYA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("OTURMA GRUBU").get()));

			productRepository.save(new Product("LUX_İKON32","İKON TEK KAPILI DOLAP CAM KAPAK",5370,brandRepository.findByName("LUXEV").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("BELL_27ORP00701400200","ORIENT PLUS",1735.6,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("70 X 140").get()));
			productRepository.save(new Product("EKOL_E-7041","LİVZA ÇOK AMAÇLI DOLAP",2356,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("DOLAP").get()));
			productRepository.save(new Product("EKOL_E-7136","MELODİ KONSOL AYNASI ( BÜYÜK )",728,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("KONSOL").get()));
			productRepository.save(new Product("BELL_27CAP01802000200","CAPRİCE",3903.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("180 X 200").get()));
			productRepository.save(new Product("VESP_DOUBLE14","DOUBLE COMFORT YATAK",6070,brandRepository.findByName("VESPERO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("140 X 190").get()));
			productRepository.save(new Product("51MRSCK","MARSES V KÖŞE",22800.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("KÖŞE TAKIMI").get()));
			productRepository.save(new Product("EKOL_E-7834","NATURAL BAŞLIK 160 LIK FÜME",3150,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get()));
			productRepository.save(new Product("VESP_DREAM36","DREAM LİFE BAZA SETİ",12950,brandRepository.findByName("VESPERO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAZA SETİ").get(), sizeRepository.findByName("150 X 200").get()));
			productRepository.save(new Product("ARNO_PEARL10","GENÇ PEARL KARYOLA BAŞLIĞI (100)",1520,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("22MNS2203VOD0","MONTES 120 LİK KARYOLA KASASI",3646.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("51LFT53","LOFTY KOLTUK TAKIMI (3+B)",14453.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("OTURMA GRUBU").get()));
			productRepository.save(new Product("EKOL_E-6923","LİNDA BENCH (SIRTSIZ) FÜME",1598,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BENÇ").get()));
			productRepository.save(new Product("BELL_27ORY00802000200","ORIENT PLUS YOUNG",2343.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 200").get()));
			productRepository.save(new Product("RAHAT_DERİN04","DERİN KANEPE",8490,brandRepository.findByName("RAHAT").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("KANEPE").get()));
			productRepository.save(new Product("LUX_PRADA15","PRADA YATAK ODASI BAZALI",40378,brandRepository.findByName("LUXEV").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("EKOL_E-7080","TERRA SÜRGÜLÜ DOLAP",16644,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("DOLAP").get()));
			productRepository.save(new Product("23VZL61590230002","VILZA 6159 SANDALYE (2 ADET) (Alternatif)",4310.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YEMEK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_KARŞIYAKA32","KARŞIYAKA Sürme Kapılı Dolap (200x210)",10505,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("RAHAT_VİSİON22","VİSİON SET",11075,brandRepository.findByName("RAHAT").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAZA SETİ").get(), sizeRepository.findByName("150 X 200").get()));
			productRepository.save(new Product("ARNO_LUNA13","LUNA Tv Sehpası Üst Modül Uzun",1610,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YEMEK ODASI TAKIMI").get()));
			productRepository.save(new Product("52GTA1616ZEXZ","GRAVITA 6 KAPAKLI YATAK ODASI TK. (150/160 BAŞLIKLI)",52222.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("BELL_26HESII01","HENA-S BAŞLIK",798,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("160 CM").get()));
			productRepository.save(new Product("22VZL2228OPO6","VILZA 120 LİK BAŞLIK",2257.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("GENÇ ODASI TAKIMI").get()));
			productRepository.save(new Product("51CNT86","CANTONA KÖŞE TAKIMI (Köşe+Berjer)",15061.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("KÖŞE TAKIMI").get()));
			productRepository.save(new Product("EKOL_E-6583","MELODİ KOMODİN AYTAŞI",1593,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("KOMODİN").get()));
			productRepository.save(new Product("VESP_DREAM24","DREAM LİFE BAZA PEDLİ",3480,brandRepository.findByName("VESPERO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAZA").get(), sizeRepository.findByName("120 X 200").get()));
			productRepository.save(new Product("ERTAS_MAJESTIC06","MAJESTIC MASA",9966,brandRepository.findByName("ERTAŞ").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YEMEK ODASI TAKIMI").get()));
			productRepository.save(new Product("22MIS2400OPOP","MISTRAL MAKYAJ AYNASI",946.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("ERTAS_PORTRE29","PORTRE ORTA SEHPA SETİ",11088,brandRepository.findByName("ERTAŞ").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YEMEK ODASI TAKIMI").get()));
			productRepository.save(new Product("ARNO_NEHİR07","NEHİR Konsol",7950,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YEMEK ODASI TAKIMI").get()));
			productRepository.save(new Product("RAHAT_LEONİ24","LEONİ SET",11802,brandRepository.findByName("RAHAT").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAZA SETİ").get(), sizeRepository.findByName("180 X 200").get()));
			productRepository.save(new Product("22VLO27001R1R","VALESCO VİTRİN",6644.2,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YEMEK ODASI TAKIMI").get()));
			productRepository.save(new Product("EKOL_E-7780","PRO ACTİVE BAŞLIK 150 LİK FÜME",1871.22063020408,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get()));
			productRepository.save(new Product("20SVT3E","Sanvito Üçlü",11459.3,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("KANEPE").get()));
			productRepository.save(new Product("BELL_27RFK00802000600","REFLEKS",2628.8,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("80 X 200").get()));
			productRepository.save(new Product("22LCD2700ZE3I","LUCIDA VİTRİN",6026.1,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YEMEK ODASI TAKIMI").get()));
			productRepository.save(new Product("BELL_27GLC01002000400","GOLDEN COMFORT",5068,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("100 X 200").get()));
			productRepository.save(new Product("20ATT4S","Atlanta Köşe Sehpa",3320.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("SEHPALAR").get()));
			productRepository.save(new Product("EKOL_DRM-400","VİCTORİA KANEPE",13116,brandRepository.findByName("EKOL").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("KANEPE").get()));
			productRepository.save(new Product("İMAJ45","RİVERS PLUS BERJER",4745,brandRepository.findByName("İMAJ MOBİLYA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BERJER").get()));
			productRepository.save(new Product("VESP_SPRİNG18","POWER SPRİNG BAZA",3155,brandRepository.findByName("VESPERO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAZA").get(), sizeRepository.findByName("90 X 190").get()));
			productRepository.save(new Product("51MNO50","MONACO KOLTUK TAKIMI (3+3+B+B)",21896.4,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("OTURMA GRUBU").get()));
			productRepository.save(new Product("BELL_27AAP01802000H00","ANTI AGING PRIME",5722.7,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK").get(), sizeRepository.findByName("180 X 200").get()));
			productRepository.save(new Product("RAHAT_SAFRAN04","SAFRAN 3+3+1+1",24460,brandRepository.findByName("RAHAT").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("OTURMA GRUBU").get()));
			productRepository.save(new Product("ARNO_FOREST29","FOREST Dolapsız Yatak Odası Takımı",19100,brandRepository.findByName("ARNO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("YATAK ODASI TAKIMI").get()));
			productRepository.save(new Product("BELL_26HESMM","PETRA PLUS S BAŞLIK",1450,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("200 CM").get()));
			productRepository.save(new Product("VESP_AYDA04","AYDA 3+3+1+1 PLUS",20520,brandRepository.findByName("VESPERO").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("OTURMA GRUBU").get()));
			productRepository.save(new Product("22MAA3306FSFS","MARIANA YAN SEHPA",2990,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("SEHPALAR").get()));
			productRepository.save(new Product("BELL_26ESYMM","ESTONYA BAŞLIK",4427.9,brandRepository.findByName("BELLONA").get(),categoryRepository.findByName("MOBİLYA").get(),typeRepository.findByName("BAŞLIK").get(), sizeRepository.findByName("200 CM").get()));




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
