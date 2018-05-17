package com.emreshome.Shopping.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emreshome.Shopping.Entity.Product;
import com.emreshome.Shopping.repositories.ProductRepository;


//TODO
@Service
public class ProductServiceImpl implements ProductService{
	//TODO
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product findById(long id) {
		return productRepository.findById(id);
	}
	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public void save(Product product) {
		productRepository.save(product);
		
	}
	@Override
	public void delete(Product product) {
		productRepository.delete(product);
		
	}

	
}
