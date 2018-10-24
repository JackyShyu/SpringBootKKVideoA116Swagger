package org.shyu.springboot.controller;


import org.shyu.springboot.model.Product;
import org.shyu.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value="/products")
@Api(value="onlinestore - product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@ApiOperation(value="View a list of Products", response=Iterable.class)
	@ApiResponses(value= {
			@ApiResponse(code=200, message="Successfully retrieved list - products"),
			@ApiResponse(code=401, message="You are not authorized to view the list - products"),
			@ApiResponse(code=403, message="Accessing the resource you were trying to reach is forbidden - products"),
			@ApiResponse(code=404, message="The resource you were trying to reach is not found - products")
	})
	@RequestMapping(value="/all", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Product> getAllProducts() {
		return productService.getAllProducts();
	}
	
	@ApiOperation(value="View a specific Product with Id", response=Product.class)
	@RequestMapping(value="/product/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Product retrieveProductById(@PathVariable("id") int id) {
		return productService.getProduct(id);
	}
	
	@ApiOperation(value="Update a product")
	@RequestMapping(value="/update", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
	}
	
	@ApiOperation(value="Add a product")
	@RequestMapping(value="/add", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@ApiOperation(value="Delete a product")
	@RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id") int id) {
		productService.deleteProduct(id);
	}
}
