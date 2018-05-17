package com.emreshome.Shopping.Service;

import java.util.List;

import com.emreshome.Shopping.Entity.Product;

public interface ProductService {

		Product findById(long id);
		List<Product> findAll();
		void save(Product product);
		void delete(Product product);
}
