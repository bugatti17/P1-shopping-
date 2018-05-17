package com.emreshome.Shopping.model;

public class ProductInCart {
	 private ProductInfo productInfo;
	
	 private String name;
		
	private long id;
	 private int quantity;
	 private double price;
	 private double subtotal;
	 
	 public ProductInCart(){
		 
	 }
	 public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductInfo getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(ProductInfo productInfo) {
		this.productInfo = productInfo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSubtotal() {
		return price*quantity;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	 
}
