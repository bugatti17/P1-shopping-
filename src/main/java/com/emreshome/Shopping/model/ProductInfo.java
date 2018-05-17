package com.emreshome.Shopping.model;

import com.emreshome.Shopping.Entity.Product;

public class ProductInfo {
	private double price;
	private String description;
	private Long id;
	
	public ProductInfo(Product p){
		this.price=p.getPrice();
		this.description=p.getDescription();		
		this.id=p.getId();
	}
}
