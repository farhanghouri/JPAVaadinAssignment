package com.afkghouri.JPAVaadinAssignment;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CheckBox;
 
public class ProductList extends HorizontalLayout{
 
	private static final long serialVersionUID = 1L;
	CheckBox checkBox;
	TextField name,price,quantity;
	Button button_update,button_delete,button_image; 
	ProductModel productModel;
	ProductController productController;
	ProductListLayout productListLayout; 
	EditImageWindow editImageWindow;

	public ProductList() { 
	} 
	@PostConstruct
	void init(){
		System.out.println("In ProductList init: ");
		
	    name     = new TextField();
		price    = new TextField();
		quantity = new TextField(); 
		checkBox = new CheckBox("",true);  
		  
		checkBox.addValueChangeListener(new ValueChangeListener<Boolean>() {  
			private static final long serialVersionUID = 1L; 
			@Override
			public void valueChange(ValueChangeEvent<Boolean> event) { 
				name.setReadOnly(checkBox.getValue());
				price.setReadOnly(checkBox.getValue());
				quantity.setReadOnly(checkBox.getValue());
			}
		});
		
		name.setValue(productModel.getName());
		name.setReadOnly(true); 
		price.setValue(String.valueOf(productModel.getPrice()));
		price.setReadOnly(true);
		quantity.setValue(String.valueOf(productModel.getQuantity())); 
		quantity.setReadOnly(true);
		
		button_image = new Button("image");
		button_update = new Button("Update");
		button_update.setData(productModel.getOid());
		button_update.addStyleName(ValoTheme.BUTTON_PRIMARY);
		button_delete = new Button("Delete");
		button_delete.setData(productModel.oid);
		button_delete.addStyleName(ValoTheme.BUTTON_DANGER);
		
		addComponents(checkBox,name,price,quantity,button_image,button_update,button_delete);
		
		button_image.addClickListener(event->{
			editImageWindow.receiver.image.setVisible(true);
			editImageWindow.receiver.image.setSource(new FileResource(new File(productModel.path))); 
			editImageWindow.setModal(true);
			UI.getCurrent().addWindow(editImageWindow);
		});
		button_update.addClickListener(new Button.ClickListener() { 
				private static final long serialVersionUID = 1L;
				public void buttonClick(ClickEvent event) {  
				   if(checkBox.getValue())
					   Notification.show("Uncheck:",
				                "To edit Text Fields.",
				                Notification.Type.HUMANIZED_MESSAGE);
				   else{
					   update(); 
					   checkBox.setValue(true);
					   name.setReadOnly(true);
					   price.setReadOnly(true);
					   quantity.setReadOnly(true);
				   }
			    }
		 });
		button_delete.addClickListener(new Button.ClickListener() { 
			private static final long serialVersionUID = 1L;
			public void buttonClick(ClickEvent event) {  
				//(long)event.getButton().getData()
				deleteById((long)button_delete.getData()); 
		    }
	 });
		
		 
	}
	
	public ProductList(ProductModel productModel,ProductController productController,ProductListLayout productListLayout,EditImageWindow editImageWindow){
		System.out.println("In ProductList constructor: ");
		this.productModel = productModel;
		this.productController = productController;
		this.productListLayout = productListLayout;
		this.editImageWindow =  editImageWindow;
	}

	
	protected void deleteById(long oid) {
		productController.deleteById(oid);
		
		productListLayout.createList(); 
		Notification.show("Deleted",
                "Successfully!",
                Notification.Type.HUMANIZED_MESSAGE);
	} 
	protected void update() { 
    	productModel.setName(name.getValue());
    	productModel.setPrice(Integer.parseInt(price.getValue()));
    	productModel.setQuantity(Integer.parseInt(quantity.getValue()));  
    	
    	productController.save(productModel); 
    	 
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
