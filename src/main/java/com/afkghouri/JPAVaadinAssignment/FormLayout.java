package com.afkghouri.JPAVaadinAssignment;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@Component
public class FormLayout extends VerticalLayout{

	@Autowired
	ProductController productController;
    private String[] strings = new String[] { "electronic", "food", "clothes" };
    
	public FormLayout(){
		 
		TextField textField_name = new TextField("enter name");
			 
		TextField textField_price = new TextField("enter price");
			 
		TextField textField_quantity = new TextField("enter quantity");
			 
		ComboBox<String> cb_category = new ComboBox<String>("Category",Arrays.asList(strings)); 
			   
		Button button_submit = new Button("ADD"); 
		button_submit.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		    	button_submit.setCaption("You made me click!");
		    	/*ProductModel productModel = new ProductModel();
		    	productModel.setName(textField_name.getValue());
		    	productModel.setPrice(Integer.parseInt(textField_price.getValue()));
		    	productModel.setQuantity(Integer.parseInt(textField_quantity.getValue()));
		    	productController.save(productModel);
		    	*/
		    	productController.findAll();
		    }
		});  
		
        addComponents(textField_name,textField_price,textField_quantity,cb_category,button_submit);
		
	}
	
}
