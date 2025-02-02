package com.yash.Inventory.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.yash.Inventory.exception.ProductNotFoundException;
import com.yash.Inventory.model.Product;
import com.yash.Inventory.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getOnPremProducts(List<Product> products) {
        return products; 
    }
    
    public List<Product> getAWSProducts(List<Product> products) {
    	if(!CollectionUtils.isEmpty(products)) {
    		int randomNumber = (int)(Math.random() * products.size());
    		updateRandomProduct(products, randomNumber);
    		randomNumber = (int)(Math.random() * products.size());
    		updateRandomProduct(products, randomNumber);
    	}
    	
        return products; 
    }

	private void updateRandomProduct(List<Product> products, int randomNumber) {
		products.get(randomNumber).setName("AWS" + products.get(randomNumber).getName());
		products.get(randomNumber).setPrice(BigDecimal.valueOf(products.get(randomNumber).getPrice().floatValue() + 5));
	}

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        product.setName(productDetails.getName());
        product.setExpiryDate(productDetails.getExpiryDate());
        product.setPrice(productDetails.getPrice());
        product.setQuantity(productDetails.getQuantity());
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}