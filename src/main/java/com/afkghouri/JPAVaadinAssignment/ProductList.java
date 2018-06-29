package com.afkghouri.JPAVaadinAssignment;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Button.ClickEvent;
 
public class ProductList extends HorizontalLayout{
 
	private static final long serialVersionUID = 1L;
	TextField name,price,quantity;
	Button button_update,button_delete;
	ProductModel productModel;
	ProductController productController;
	ListLayout listLayout; 

	@PostConstruct
	void init(){
		System.out.println("In ProductList init: ");
		
	    name = new TextField();
		price = new TextField();
		quantity = new TextField();
		
		name.setValue(productModel.getName());
		price.setValue(String.valueOf(productModel.getPrice()));
		quantity.setValue(String.valueOf(productModel.getQuantity())); 
		
		button_update = new Button("Update");
		button_update.setData(productModel.oid);
		button_update.addStyleName(ValoTheme.BUTTON_PRIMARY);
		button_delete = new Button("Delete");
		button_delete.setData(productModel.oid);
		button_delete.addStyleName(ValoTheme.BUTTON_DANGER);
		
		addComponents(name,price,quantity,button_update,button_delete);
		
		button_update.addClickListener(new Button.ClickListener() { 
				private static final long serialVersionUID = 1L;
				public void buttonClick(ClickEvent event) {  
					update((long)event.getButton().getData());  
			    }
		 });
		button_delete.addClickListener(new Button.ClickListener() { 
			private static final long serialVersionUID = 1L;
			public void buttonClick(ClickEvent event) {  
				deleteById((long)event.getButton().getData()); 
		    }
	 });
		
		 
	}
	public ProductList() { 
	} 
	public ProductList(ProductModel productModel,ProductController productController,ListLayout listLayout){
		System.out.println("In ProductList constructor: ");
		this.productModel = productModel;
		this.productController = productController;
		this.listLayout = listLayout;
	}

	
	protected void deleteById(long oid) {
		productController.deleteById(oid);
		
		listLayout.createList(); 
		Notification.show("Deleted",
                "Successfully!",
                Notification.Type.HUMANIZED_MESSAGE);
	} 
	protected void update(long oid) {
		ProductModel productModel = new ProductModel(); 
		productModel.setOid(oid);
    	productModel.setName(name.getValue());
    	productModel.setPrice(Integer.parseInt(price.getValue()));
    	productModel.setQuantity(Integer.parseInt(quantity.getValue())); 
    	productController.save(productModel); 
    	
    	listLayout.createList(); 
		Notification.show("Updated",
                "Successfully!",
                Notification.Type.HUMANIZED_MESSAGE);
    	
	}
	@PreDestroy
	private void shutdown() {
		System.out.println("Shutdown All Resources");
	}

	public void close() {
		System.out.println("Closing All Resources");
	}
	 

}
