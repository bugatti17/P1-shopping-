package com.emreshome.Shopping.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="products")
public class Product {

	/**
	 * 
	 */
	
	
	 private Long id;
	 
	 private String name;
	 private String description;
	
	private double price;
	 private byte[] image;
	 private Date createdate;
	 
	    public Product() {
	    }
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    public Long getId() {
	        return id;
	    }
	 
	    public void setId(long id) {
	        this.id = id;
	    }
	 
	     public String getName() {
	        return name;
	    }
	 
	    public void setName(String name) {
	        this.name = name;
	    }
	    public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

	 
	    public double getPrice() {
	        return price;
	    }
	 
	    public void setPrice(double price) {
	        this.price = price;
	    }
	 
	    @Temporal(TemporalType.TIMESTAMP)
	    public Date getCreateDate() {
	        return createdate;
	    }
	 
	    public void setCreateDate(Date createDate) {
	        this.createdate = createDate;
	    }
	 
	    @Lob
	    public byte[] getImage() {
	        return image;
	    }
	 
	    public void setImage(byte[] image) {
	        this.image = image;
	    }
	    
	    public String toString(){
			return "Product: " + name + " with price " + price + " --[ "+description+" ]-- ("+createdate+")";
	    	
	    }
	 

}
