package com.afkghouri.JPAVaadinAssignment;

import javax.annotation.PostConstruct;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Component
public class CategoryFormLayout extends VerticalLayout{
 
	private static final long serialVersionUID = 1L;
	TextField name;
	@Autowired
	CategoryController categoryController;
	@Autowired
	CategoryListLayout categoryListLayout;
	
	@Autowired
	ProductFormLayout productFormLayout;
	
	public CategoryFormLayout() {
    	System.out.println("In CategoryView constructor:"); 
	}
	
	@PostConstruct
	void init(){
    	System.out.println("In CategoryView init:");
    	createForm();
    }

	private void createForm() {
		name = new TextField("enter name");
		
		Button button_submit = new Button("Add");
		button_submit.addClickListener(new Button.ClickListener() { 
				private static final long serialVersionUID = 1L;
				public void buttonClick(ClickEvent event) { 
			    	save();
			    } 
		 });
		
		addComponents(name,button_submit); 
	}

	protected void save() {
		CategoryModel categoryModel = new CategoryModel(); 
		categoryModel.setName(name.getValue());  
    	   
		categoryController.save(categoryModel); 
    	 
		categoryListLayout.createList();
		
		Notification.show("New Category Added",
                "Successfully!",
                Notification.Type.HUMANIZED_MESSAGE);
		
		launchCascadingEffect(false);
		
	}

	private void launchCascadingEffect(boolean flag) {
		productFormLayout.cascadingEffect(flag);
	}
}
