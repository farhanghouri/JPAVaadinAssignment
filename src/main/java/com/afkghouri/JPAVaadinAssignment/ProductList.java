package com.afkghouri.JPAVaadinAssignment;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;

public class ProductList extends HorizontalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	TextField name,price,quantity;
	public ProductList(ProductModel productModel){
		System.out.println("In ProductList");
		name = new TextField();
		price = new TextField();
		quantity = new TextField();
		name.setValue(productModel.getName());
		price.setValue(String.valueOf(productModel.getPrice()));
		quantity.setValue(String.valueOf(productModel.getQuantity())); 
		addComponents(name,price,quantity);
		
	}
	 

}
