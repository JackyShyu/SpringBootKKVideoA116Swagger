package org.shyu.springboot.controller;


import org.apache.catalina.connector.Response;
import org.shyu.springboot.model.Product;
import org.shyu.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping(name="/products", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@RequestMapping(name="/products/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Product getProduct(@PathVariable("id") int id) {
		return productService.getProduct(id);
	}
	
	@RequestMapping(name="/products/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
	}
	
	@RequestMapping(name="/products/add", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@RequestMapping(name="/products/delete/{id}", method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		productService.deleteProduct(id);
	}
}
