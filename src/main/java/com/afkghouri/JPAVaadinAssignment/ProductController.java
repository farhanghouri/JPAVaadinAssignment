package com.afkghouri.JPAVaadinAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    
    public void findAll(){
    	System.out.println("call================================="+productRepository.findAll());
    	for(ProductModel pm : productRepository.findAll()){
    		System.out.println("product id: "+pm.oid);
    		System.out.println("product name: "+pm.name);
    		System.out.println("product price: "+pm.price);
    		System.out.println("product quantity: "+pm.quantity);
    	}
    	 
    }
    
    public void save(ProductModel productModel){
    	productRepository.save(productModel);
    }
}
