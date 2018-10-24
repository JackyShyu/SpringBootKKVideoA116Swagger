package org.shyu.springboot.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class Product {
	@Id
	@Column(name="id")
	@ApiModelProperty(notes = "The database ID")
	private int id;
	
	@Column(name="version")
	@ApiModelProperty(notes = "The database product version")
	private int version;
	
	@Column(name="product_id")
	@ApiModelProperty(notes = "The database product id")
	private String productId;
	
	@Column(name="description")
	@ApiModelProperty(notes = "The database product description")
	private String description;
	
	@Column(name="image_url")
	@ApiModelProperty(notes = "The database product image url")
	private String imageUrl;
	
	@Column(name="price")
	@ApiModelProperty(notes = "The database product price")
	private BigDecimal price;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
