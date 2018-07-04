package com.afkghouri.JPAVaadinAssignment;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.navigator.View;
import com.vaadin.ui.VerticalLayout;

@Component
public class ProductView extends VerticalLayout implements View {
	 
	private static final long serialVersionUID = 1L;
	@Autowired
	ProductFormLayout productFormLayout;
	@Autowired
	ProductListLayout productListLayout;
	

    public ProductView() { 
    	System.out.println("In ProductView constructor:"); 
    }
    @PostConstruct
	void init(){
    	System.out.println("In ProductView init:");
    	addComponent(productFormLayout);
    	addComponent(productListLayout);
    }

}
