package com.afkghouri.JPAVaadinAssignment;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.navigator.View; 
import com.vaadin.ui.VerticalLayout;

@Component
public class CategoryView extends VerticalLayout implements View {
 
	private static final long serialVersionUID = 1L;
	@Autowired
	CategoryFormLayout categoryFormLayout;
	@Autowired
	CategoryListLayout categoryListLayout;


	public CategoryView() {
    	System.out.println("In CategoryView constructor:"); 
    } 
    @PostConstruct
	void init(){
    	System.out.println("In CategoryView init:"); 
    	addComponent(categoryFormLayout);
    	addComponent(categoryListLayout);
    }
}
