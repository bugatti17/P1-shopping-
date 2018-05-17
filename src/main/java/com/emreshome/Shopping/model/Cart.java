package com.emreshome.Shopping.model;

import java.util.ArrayList;
import java.util.List;

import com.emreshome.Shopping.Entity.Product;

public class Cart {

	private final List<ProductInCart> products=new ArrayList<ProductInCart>();
	public Cart(){
		System.out.println("New Card created");
	}
	public List<ProductInCart> getProducts(){
		return products;
	}
	public void addProduct(Product p,int quantity){
		ProductInCart pl=getPl(p.getId());
		if(pl==null){
			System.out.println("pl is null");
			ProductInCart ppl=new ProductInCart();
			ppl.setId(p.getId());
			ppl.setName(p.getName());
			ppl.setPrice(p.getPrice());
			ppl.setQuantity(quantity);
			products.add(ppl);
			
		}
		else{
			pl.setQuantity(pl.getQuantity()+1);
		}
		
		
	}
	public void deleteProduct(Product p){
		ProductInCart pl=getPl(p.getId());
		if(pl!=null){
			System.out.println("remove item");
			products.remove(pl);
		}
	}
	ProductInCart getPl(long id){
		for(ProductInCart pl:products){
			if(id==pl.getId())
				return pl;
		}
		return null;
	}
}
