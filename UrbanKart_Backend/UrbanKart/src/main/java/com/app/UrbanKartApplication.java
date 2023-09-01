package com.app;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.entities.Categories;
import com.app.entities.Products;
import com.app.repository.CategoryRepository;
import com.app.repository.ProductRepository;

@SpringBootApplication
public class UrbanKartApplication implements CommandLineRunner{
	
	@Autowired
	private CategoryRepository categoryRepo;
	@Autowired
	private ProductRepository productRepo;

	public static void main(String[] args) {
		SpringApplication.run(UrbanKartApplication.class, args);
	}
	
	//Bean creation of model mapper
	@Bean
	public ModelMapper mapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);//This line configures the ModelMapper to use a strict matching strategy for mapping properties between objects. The MatchingStrategies.STRICT strategy enforces that source and destination properties have the same name and type for mapping to occur.
		return modelMapper;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application Started!!!!");
		
//		public Categories(String categoryName, String description) {
//			super();
//			this.categoryName = categoryName;
//			this.description = description;
//		}
		/*
		 * Categories category=new Categories("Electronics", "ele");
		 * categoryRepo.save(category); Categories c2= new
		 * Categories("Apperal","clothing"); categoryRepo.save(c2);
		 * 
		 * Long cid=category.getId();
		 */
	       
//	       public Products(String name, Double price, String description, Integer stock, Categories categoryId,LocalDate expDate) {
//	   		super();
//	   		this.name = name;
//	   		this.price = price;
//	   		this.description = description;
//	   		this.stock = stock;
//	   		this.categoryId = categoryId;
//	   		this.expDate = expDate;
//	   	}
	       //public Products(String name, Double price, String description,Integer stock, Categories categoryId,
	       //String imagePath, LocalDate expDate)
	      // Products product=new Products("mobile",999.00,"new one",50,cid,LocalDate.parse("2023-06-06"))
		/*
		 * Products product1=new
		 * Products("mobile",999.00,"iPhone",50,category,"./images/iphone13.jpg",
		 * LocalDate.parse("2023-10-10")); Products product2=new
		 * Products("Loptop",1110.00,"laptop",50,category,"./images/laptop.jfif",
		 * LocalDate.parse("2023-10-11")); Products product3=new
		 * Products("playstation",1200.00,"playStation",100,category,
		 * "./images/playstation.jpg",LocalDate.parse("2023-10-10"));
		 * productRepo.save(product1); productRepo.save(product2);
		 * productRepo.save(product3);
		 */
	
	}

}
