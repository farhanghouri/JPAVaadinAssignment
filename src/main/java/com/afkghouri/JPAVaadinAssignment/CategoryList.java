package com.afkghouri.JPAVaadinAssignment;
 

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.vaadin.data.Binder;
import com.vaadin.data.HasValue.ValueChangeEvent;
import com.vaadin.data.HasValue.ValueChangeListener;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.themes.ValoTheme;


public class CategoryList extends HorizontalLayout{
  
	private static final long serialVersionUID = 1L;
	CheckBox checkBox;
	TextField name;
	Button button_update,button_delete; 
	CategoryController categoryController;
    CategoryModel categoryModel;
    CategoryListLayout categoryListLayout; 
	Binder<CategoryModel> binder;
    
    ProductFormLayout productFormLayout;
    
	public CategoryList(CategoryController categoryController, CategoryModel categoryModel,CategoryListLayout categoryListLayout, ProductFormLayout productFormLayout) { 
		System.out.println("In CategoryList constructor:");
		this.categoryController = categoryController;
		this.categoryModel = categoryModel;
		this.categoryListLayout = categoryListLayout;
		
		this.productFormLayout = productFormLayout;
		
		name = new TextField();
		name.setReadOnly(true);
		checkBox = new CheckBox("",true);  
		  
		checkBox.addValueChangeListener(new ValueChangeListener<Boolean>() { 
			private static final long serialVersionUID = 1L; 
			@Override
			public void valueChange(ValueChangeEvent<Boolean> event) { 
				name.setReadOnly(checkBox.getValue()); 
			}
		});
		
		setBinder();
		
		button_update = new Button("Update");
		button_update.setData(categoryModel.getOid());
		button_update.addStyleName(ValoTheme.BUTTON_PRIMARY);
		button_delete = new Button("Delete");
		button_delete.setData(categoryModel.getOid());
		button_delete.addStyleName(ValoTheme.BUTTON_DANGER);
		

		addComponents(checkBox,name,button_update,button_delete);
		
		button_update.addClickListener(new Button.ClickListener() { 
			private static final long serialVersionUID = 1L;
			public void buttonClick(ClickEvent event) {  
			   if(checkBox.getValue())
				   Notification.show("Uncheck:",
			                "To edit Text Fields",
			                Notification.Type.HUMANIZED_MESSAGE);
			   else{
				   if(binder.isValid()){
					   update(); 
					   checkBox.setValue(true);
					   name.setReadOnly(true); 
				   }
					else
						Notification.show("Invalid Field",
				                "insertion failed!",
				                Notification.Type.ERROR_MESSAGE);
			   }
		    }
	    });
		button_delete.addClickListener(new Button.ClickListener() { 
			private static final long serialVersionUID = 1L;
			public void buttonClick(ClickEvent event) {   
				deleteById((long)button_delete.getData()); 
		    }
	   });
	}

	private void setBinder() { 
		binder = new Binder<>();
		
		// Start by defining the Field instance to use
		binder.forField(name)
		  .asRequired("name should be required")
		  // Finalize by doing the actual binding to the CategoryModel class
		  .bind(
		    // Callback that loads the name from a categoryModel instance
		    CategoryModel::getName,
		    // Callback that saves the name in a categoryModel instance
		    CategoryModel::setName); 
		
		binder.setBean(categoryModel); /**  TWO WAY BINDING **/
		
	}
	protected void deleteById(long oid) {
		deleteImagesAgainstOid(oid);
		
		categoryController.deleteById(oid);
		
		categoryListLayout.createList(); 
		
		Notification.show("Deleted",
                "Successfully!",
                Notification.Type.HUMANIZED_MESSAGE);
		
		launchCascadingEffect(true);
	} 
	protected void update() {   
    	
    	categoryController.save(categoryModel);  
    	
		Notification.show("Updated",
                "Successfully!",
                Notification.Type.HUMANIZED_MESSAGE);
		
		launchCascadingEffect(false);
    	
	}
	
	void launchCascadingEffect(boolean flag){
		productFormLayout.cascadingEffect(flag); 
	}
	
	protected void deleteImagesAgainstOid(long oid){
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query q = entityManager.createNativeQuery("SELECT * FROM products p WHERE p.categories_oid = ?",ProductModel.class);
		q.setParameter(1, oid);

		List<ProductModel> list = q.getResultList(); 
		for (ProductModel productModel : list) {
			new File(productModel.path).delete();
		} 
		 
		entityManager.close();
		
	}
}
