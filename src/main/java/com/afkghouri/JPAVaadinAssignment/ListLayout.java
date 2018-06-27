package com.afkghouri.JPAVaadinAssignment;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout; 

@Component
public class ListLayout extends VerticalLayout{
   
	private static final long serialVersionUID = 1L;
	@Autowired
	ProductController productController;
	@Autowired
	ProductList pl;
	/**
	 * @PostConstruct is an annotation used on a method that needs to be executed 
	 * after dependency injection is done to perform any initialization.
	 */
	@PostConstruct
	void init(){
		System.out.println("In ListLayout");
		createList();
	}
	

	private void setProductLabel() {
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.addComponents(new Label("name"),new Label("price"),new Label("quantity"));
		horizontalLayout.setWidth("80%");
		addComponent(horizontalLayout);
		
	}


	public void createList() {
		removeAllComponents();
		setProductLabel();
		List<ProductModel> list = productController.findAll();
		/*if(list != null)
			for(ProductModel pm:list)
				addComponent(new ProductList(pm));  
*/
		  addComponent( pl); 
		  // ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/afkghouri/JPAVaadinAssignment/ObjectCreation.xml"); 
	       //ProductList productList = (ProductList) applicationContext.getBean("productlistobj");
	       //productList.addComponent(new ProductList(list.get(0)));

	   //  addComponent(context.getBean(ProductList.class));
	}
}
