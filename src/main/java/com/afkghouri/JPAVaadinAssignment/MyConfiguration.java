package com.afkghouri.JPAVaadinAssignment;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration  
public class MyConfiguration {
	    @Bean
	    @Scope(value="prototype")
	    public ProductList myBean(ProductModel productModel,ProductController productController,ListLayout listLayout) { 
	    	return new ProductList(productModel,productController,listLayout);
	    }
	    
	    
	/*@Bean
    @Scope(value="prototype")
	    public Waseem myBean() { 
	    	return new Waseem();
	    }
	*/
	    /*    @Bean
    @Scope(value="prototype")
    public Waseem myBean(ProductModel pm,ProductController pc) { 
    	return new Waseem(pm,pc);
    }*/
	    
}
