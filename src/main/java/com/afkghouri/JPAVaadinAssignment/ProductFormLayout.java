package com.afkghouri.JPAVaadinAssignment;

import java.util.ArrayList; 
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.	ui.ComboBox;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Component
public class ProductFormLayout extends VerticalLayout{
 
	private static final long serialVersionUID = 1L;
	TextField textField_name,textField_price,textField_quantity;
	ComboBox<String> cb_category;
	@Autowired
	ProductController productController;
	@Autowired
	ProductListLayout productListLayout; 
	@Autowired
	CategoryController categoryController; 

	List<String> list_category = new ArrayList<>();
     
	public ProductFormLayout(){ 
		System.out.println("In FormLayout constructor:");
	}
	@PostConstruct
	void init(){
		System.out.println("In FormLayout init:");
		createForm(); 
	}

	private void createForm() { 
		 textField_name = new TextField("enter name");
			 
		 textField_price = new TextField("enter price");
			 
		 textField_quantity = new TextField("enter quantity");
			 
		 cb_category = new ComboBox<String>("Category"); 
		 setCategoriesFromDB();
		 cb_category.setEmptySelectionAllowed(false); 
		 
		 
		 Button button_submit = new Button("ADD"); 
		 button_submit.addClickListener(new Button.ClickListener() { 
				private static final long serialVersionUID = 1L;
				public void buttonClick(ClickEvent event) { 
			    	save();
			    }
		 });  
		
         addComponents(textField_name,textField_price,textField_quantity,cb_category,button_submit);
		
	}
	
	private void save(){
		ProductModel productModel = new ProductModel(); 
    	productModel.setName(textField_name.getValue());
    	productModel.setPrice(Integer.parseInt(textField_price.getValue()));
    	productModel.setQuantity(Integer.parseInt(textField_quantity.getValue())); 
    	 
    	productModel.setCategoryModel(categoryController.findByName(cb_category.getValue()));  
    	 
    	productController.save(productModel); 
    	
    	productListLayout.createList(); 
		Notification.show("New Product Added",
                "Successfully!",
                Notification.Type.HUMANIZED_MESSAGE);
	}
	
	void setCategoriesFromDB(){
		list_category.clear(); 
		
		categoryController.findAll().forEach(categoryModel->{
			list_category.add(categoryModel.getName());
		}); 
			 
		cb_category.setItems(list_category);
		if(!list_category.isEmpty())
			cb_category.setValue(list_category.get(0));
	}
	void cascadingEffect(boolean delete_flag){
		setCategoriesFromDB(); 
		if(delete_flag)
		   productListLayout.createList();
	}
	 
	
}
