package org.shyu.springboot.repository;

import org.shyu.springboot.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
