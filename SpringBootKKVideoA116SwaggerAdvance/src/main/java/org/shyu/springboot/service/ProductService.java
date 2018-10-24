package org.shyu.springboot.service;

import org.shyu.springboot.model.Product;

public interface ProductService {
	public abstract Iterable<Product> getAllProducts();
	public abstract Product getProduct(int id);
	public abstract void updateProduct(Product product);
	public abstract void addProduct(Product product);
	public abstract void deleteProduct(int id);
}
