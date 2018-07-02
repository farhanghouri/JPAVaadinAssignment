package com.afkghouri.JPAVaadinAssignment;
 

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
    
    ProductFormLayout productFormLayout;
    
	public CategoryList(CategoryController categoryController, CategoryModel categoryModel,CategoryListLayout categoryListLayout, ProductFormLayout productFormLayout) { 
		System.out.println("In CategoryList constructor:");
		this.categoryController = categoryController;
		this.categoryModel = categoryModel;
		this.categoryListLayout = categoryListLayout;
		
		this.productFormLayout = productFormLayout;
		
		name = new TextField();
		checkBox = new CheckBox("",true);  
		  
		checkBox.addValueChangeListener(new ValueChangeListener<Boolean>() { 
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent<Boolean> event) { 
				name.setReadOnly(checkBox.getValue()); 
			}
		});
		
		name.setValue(categoryModel.getName());
		name.setReadOnly(true);
		
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
			                "To Update.",
			                Notification.Type.HUMANIZED_MESSAGE);
			   else{
				   update(); 
				   checkBox.setValue(true);
				   name.setReadOnly(true); ;
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

	protected void deleteById(long oid) {
		categoryController.deleteById(oid);
		
		categoryListLayout.createList(); 
		
		Notification.show("Deleted",
                "Successfully!",
                Notification.Type.HUMANIZED_MESSAGE);
		
		launchCascadingEffect(true);
	} 
	protected void update() { 
    	categoryModel.setName(name.getValue());   
    	
    	categoryController.save(categoryModel);  
    	
		Notification.show("Updated",
                "Successfully!",
                Notification.Type.HUMANIZED_MESSAGE);
		
		launchCascadingEffect(false);
    	
	}
	
	void launchCascadingEffect(boolean flag){
		productFormLayout.cascadingEffect(flag); 
	}
	
}
