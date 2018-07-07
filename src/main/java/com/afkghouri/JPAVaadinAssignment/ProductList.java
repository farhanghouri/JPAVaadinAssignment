package com.afkghouri.JPAVaadinAssignment;

import java.io.File;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import com.vaadin.data.Binder;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.server.FileResource;
import com.vaadin.server.ThemeResource;
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
	
	Binder<ProductModel> binder;

	public ProductList() { 
	} 
	@PostConstruct
	void init(){
		System.out.println("In ProductList init: ");
		
	    name     = new TextField();
	    name.setReadOnly(true);  
		price    = new TextField();
		price.setReadOnly(true); 
		quantity = new TextField();
		quantity.setReadOnly(true); 
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
		
		setBinder();
		
		button_image = new Button("image");
		//button_image.setIcon(new ThemeResource("icons/tick.png"));
		button_update = new Button("Update");
		button_update.setData(productModel.getOid());
		button_update.addStyleName(ValoTheme.BUTTON_PRIMARY);
		button_delete = new Button("Delete");
		button_delete.setData(productModel.oid);
		button_delete.addStyleName(ValoTheme.BUTTON_DANGER);
		
		addComponents(checkBox,name,price,quantity,button_image,button_update,button_delete);
		

		editImageWindow = new EditImageWindow(); // reason: each record must have its own image window
		button_image.addClickListener(event->{
			editImageWindow.receiver.absolutePath = null; // reason: deduct image is updated
			editImageWindow.receiver.image.setVisible(true);
			editImageWindow.receiver.image.setSource(new FileResource(new File(productModel.path)));  
			editImageWindow.receiver.button_img_update.setVisible(true);
			editImageWindow.setModal(true); // advantage: edit mode finish in background UI
			UI.getCurrent().addWindow(editImageWindow);
		});
		editImageWindow.receiver.button_img_update.addClickListener(event->{
			if(editImageWindow.receiver.absolutePath != null){
				new File(productModel.path).delete();
				productModel.path = editImageWindow.receiver.absolutePath;
				productController.save(productModel); 
			}
			editImageWindow.close();
			Notification.show("Image Updated",
	                "Successfully!",
	                Notification.Type.HUMANIZED_MESSAGE);
		});
		
		button_update.addClickListener(new Button.ClickListener() { 
				private static final long serialVersionUID = 1L;
				public void buttonClick(ClickEvent event) {  
				   if(checkBox.getValue())
					   Notification.show("Uncheck:",
				                "To edit Text Fields.",
				                Notification.Type.HUMANIZED_MESSAGE);
				   else{
					   if(binder.isValid()){
						   update(); 
						   checkBox.setValue(true);
						   name.setReadOnly(true);
						   price.setReadOnly(true);
						   quantity.setReadOnly(true);
					   }else
						   Notification.show("Invalid Field",
					                "insertion failed!",
					                Notification.Type.ERROR_MESSAGE);
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
	
	public ProductList(ProductModel productModel,ProductController productController,ProductListLayout productListLayout){
		System.out.println("In ProductList constructor: ");
		this.productModel = productModel;
		this.productController = productController;
		this.productListLayout = productListLayout; 
	}
	
	private void setBinder() {  
		binder = new Binder<>();
		
		binder.forField(name)
		      .asRequired("name should be required")
			  .bind(ProductModel::getName,ProductModel::setName);
		
		binder.forField(price)
		       .asRequired("price should be required")
		       .withConverter(
			    Integer::valueOf,
			    String::valueOf, 
			    "price should be an integer")
               .withValidator(quantity -> quantity > 0,
                "price should be > 0 ")
		       .bind(ProductModel::getPrice,ProductModel::setPrice);
		
		binder.forField(quantity) 
	            .asRequired("quantity should be required")
	            .withConverter(
			    Integer::valueOf,
			    String::valueOf, 
			    "quantity should be an integer")
               .withValidator(quantity -> quantity > 0,
                 "quantity should be > 0 ")
	           .bind(ProductModel::getQuantity,ProductModel::setQuantity); 
		 
		binder.setBean(productModel);
	}

	
	protected void deleteById(long oid) {
		productController.deleteById(oid);
		
		productListLayout.createList(); 
		
		new File(productModel.path).delete();
		Notification.show("Deleted",
                "Successfully!",
                Notification.Type.HUMANIZED_MESSAGE);
	} 
	protected void update() {   
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
