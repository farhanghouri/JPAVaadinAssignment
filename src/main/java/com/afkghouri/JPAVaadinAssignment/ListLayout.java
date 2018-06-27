package com.afkghouri.JPAVaadinAssignment;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
  
import com.vaadin.ui.VerticalLayout; 

@Component
public class ListLayout extends VerticalLayout{
   
	private static final long serialVersionUID = 1L;
	@Autowired
	ProductController productController;
	 
	/**
	 * @PostConstruct is an annotation used on a method that needs to be executed 
	 * after dependency injection is done to perform any initialization.
	 */
	@PostConstruct
	void init(){
		System.out.println("In ListLayout");
		createList();
	}
	

	public void createList() {
		removeAllComponents();
		List<ProductModel> list = productController.findAll();
		if(list != null)
			for(ProductModel pm:list)
				addComponent(new ProductList(pm));  

	}
}
