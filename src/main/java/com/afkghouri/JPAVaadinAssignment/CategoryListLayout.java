package com.afkghouri.JPAVaadinAssignment;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component;
 
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
@Component
public class CategoryListLayout extends VerticalLayout{
 
	private static final long serialVersionUID = 1L;
	@Autowired
	CategoryController categoryController;
	@Autowired
	CategoryListLayout categoryListLayout; 
	
	@Autowired
	ProductFormLayout productFormLayout;
	

	public CategoryListLayout() {
		System.out.println("In CategoryListLayout constructor:");
	}
	
	@PostConstruct
	public void init(){
		System.out.println("In CategoryListLayout init:"); 
		createList();
	}

	private void setCategoryLabel() { 
		addComponent(new Label("name")); 
	}
	public void createList() {
		removeAllComponents();
		setCategoryLabel();
		List<CategoryModel> list = categoryController.findAll();
	   
		if(list != null)
			for(CategoryModel categoryModel:list){ 
				addComponent(new CategoryList(categoryController,categoryModel,categoryListLayout, productFormLayout));  
			}
		  
		
	}
}
