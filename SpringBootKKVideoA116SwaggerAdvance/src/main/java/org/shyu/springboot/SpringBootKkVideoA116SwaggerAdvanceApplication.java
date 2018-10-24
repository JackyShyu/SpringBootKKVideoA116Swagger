package org.shyu.springboot;

import java.math.BigDecimal;

import org.shyu.springboot.model.Product;
import org.shyu.springboot.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

@SpringBootApplication
public class SpringBootKkVideoA116SwaggerAdvanceApplication implements ApplicationListener<ContextRefreshedEvent> {
	Logger logger = LoggerFactory.getLogger(SpringBootKkVideoA116SwaggerAdvanceApplication.class);
	
	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootKkVideoA116SwaggerAdvanceApplication.class, args);
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		loadProducts();
	}

	private void loadProducts() {
		logger.info("Create Samsung Galaxy record!");
		Product samsungGalaxy = new Product();
		samsungGalaxy.setId(1);
		samsungGalaxy.setDescription("Samsung Galaxy J7 SM-J700F");
		samsungGalaxy.setPrice(new BigDecimal("13299.00"));
		samsungGalaxy.setImageUrl("https://www.google.com/search?q=samsung+galaxy+s9&ie=utf-8&oe=utf-8&client=firefox-b-1");
		samsungGalaxy.setProductId("23526889931068308");
		productRepository.save(samsungGalaxy);
		
		logger.info("Create iPhone record!");
		Product iPhone = new Product();
		iPhone.setId(2);
		iPhone.setDescription("Apple iPhone 7");
		iPhone.setImageUrl("https://www.apple.com/iphone/?afid=p238%7Cs7AkblcwL-dc_mtid_20925d2q39172_pcrid_294936685676&cid=wwa-us-kwgo-iphone-slid--");
		iPhone.setProductId("198639393495300006");
		iPhone.setPrice(new BigDecimal("47499"));
		productRepository.save(iPhone);
	}
}
