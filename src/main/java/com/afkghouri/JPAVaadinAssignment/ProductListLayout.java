package com.afkghouri.JPAVaadinAssignment;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.context.annotation.AnnotationConfigApplicationContext; 
import org.springframework.stereotype.Component;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout; 

@Component
public class ProductListLayout extends VerticalLayout{
   
	private static final long serialVersionUID = 1L;
	@Autowired
	ProductController productController; 
	@Autowired
	ProductListLayout productListLayout; 
	 
	
	public ProductListLayout() { 
		System.out.println("In ProductListLayout constructor:");
	}
	/**
	 * @PostConstruct is an annotation used on a method that needs to be executed 
	 * after dependency injection is done to perform any initialization.
	 */
	@PostConstruct
	void init(){
		System.out.println("In ProductListLayout init:");
		createList();
	}
	 
	private void setProductLabel() {
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.addComponents(new Label("name"),new Label("price"),new Label("quantity"));
		horizontalLayout.setWidth("100%");
		horizontalLayout.setMargin(true);
		addComponent(horizontalLayout);
		
	} 

	public void createList() {
		removeAllComponents();
		
		setProductLabel();
		
		List<ProductModel> list = productController.findAll();
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(MyConfiguration.class);
		ctx.refresh(); 
	
		if(list != null)
			for(ProductModel productModel:list)
				addComponent(ctx.getBean(ProductList.class,productModel,productController,productListLayout));
			
        ctx.close(); 
	}
}
