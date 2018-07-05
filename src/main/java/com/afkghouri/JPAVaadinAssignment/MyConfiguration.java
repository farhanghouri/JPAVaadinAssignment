package com.afkghouri.JPAVaadinAssignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration  
public class MyConfiguration {
	    @Bean
	    @Scope(value="prototype")
	    public ProductList myBean(ProductModel productModel,ProductController productController,ProductListLayout productListLayout,EditImageWindow editImageWindow) { 
	    	return new ProductList(productModel,productController,productListLayout,editImageWindow);
	    }
	     
}
