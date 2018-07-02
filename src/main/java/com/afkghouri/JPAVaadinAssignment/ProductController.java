package com.afkghouri.JPAVaadinAssignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    
    public List<ProductModel> findAll(){
    	System.out.println("findAll() call: "); 
    	return productRepository.findAll();
    	 
    }
    
    public void save(ProductModel productModel){
    	System.out.println("save() call:");
    	productRepository.save(productModel);
    }
    public void deleteById(long oid){
    	System.out.println("deleteById() call:");
    	productRepository.deleteById(oid);
    }
    
}
