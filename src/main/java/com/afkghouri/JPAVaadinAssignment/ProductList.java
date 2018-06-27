package com.afkghouri.JPAVaadinAssignment;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component; 
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;

@Component
public class ProductList extends HorizontalLayout{
 
	private static final long serialVersionUID = 1L;
	TextField name,price,quantity;
	Button button_update,button_delete;
	@Autowired
	ProductController productController;
	@Autowired
	ListLayout listLayout;
	ProductController pc;
	ListLayout ll;
	@PostConstruct
	void init(){
    	System.out.println("pc: "+productController+" ll: "+listLayout);
    	pc = productController; 	ll = listLayout;
    	System.out.println("PC: "+pc+" LL: "+ll);
    	button_update = new Button("Update");
    	button_update.setData((long)3);
    	button_update.addClickListener(new Button.ClickListener() { 
			private static final long serialVersionUID = 1L;
			public void buttonClick(ClickEvent event) {  
				update((long)event.getButton().getData()); 
		    }
	 });
    	addComponent(button_update);
		 
	}
	public ProductList() {
		// TODO Auto-generated constructor stub
		System.out.println("oo");
	}
	public ProductList(ProductModel productModel){
		System.out.println("In ProductList");
		name = new TextField();
		price = new TextField();
		quantity = new TextField();
		
		name.setValue(productModel.getName());
		price.setValue(String.valueOf(productModel.getPrice()));
		quantity.setValue(String.valueOf(productModel.getQuantity())); 
		
		button_update = new Button("Update");
		button_update.setData(productModel.oid);
		button_delete = new Button("Delete");
		
		addComponents(name,price,quantity,button_update,button_delete);
		
		button_update.addClickListener(new Button.ClickListener() { 
				private static final long serialVersionUID = 1L;
				public void buttonClick(ClickEvent event) {  
					update((long)event.getButton().getData()); 
			    }
		 }); 
    	System.out.println("pc: "+pc+" ll: "+ll); 
		
		
	}

	protected void update(long oid) {
	/*	ProductModel productModel = new ProductModel(); 
		productModel.setOid(oid);
    	productModel.setName(name.getValue());
    	productModel.setPrice(Integer.parseInt(price.getValue()));
    	productModel.setQuantity(Integer.parseInt(quantity.getValue())); */
    	//productController.save(productModel); 
    	
    	//listLayout.createList();
    	System.out.println("pc: "+pc+" ll: "+ll); 
    	
	}
	
	 

}
