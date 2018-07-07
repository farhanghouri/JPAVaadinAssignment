package com.afkghouri.JPAVaadinAssignment;

import javax.annotation.PostConstruct;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.data.Binder; 
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Component
public class CategoryFormLayout extends VerticalLayout{
 
	private static final long serialVersionUID = 1L;
	TextField textField_name;
	@Autowired
	CategoryController categoryController;
	@Autowired
	CategoryListLayout categoryListLayout;
	@Autowired
	CategoryModel categoryModel;
	Binder<CategoryModel> binder;
	
	@Autowired
	ProductFormLayout productFormLayout;
	
	public CategoryFormLayout() {
    	System.out.println("In CategoryView constructor:"); 
	}
	
	@PostConstruct
	void init(){
    	System.out.println("In CategoryView init:");
    	createForm();
    }

	private void createForm() {
		textField_name = new TextField("enter name");
		
		setBinder();
		 
		Button button_submit = new Button("Add");
		button_submit.addClickListener(new Button.ClickListener() { 
				private static final long serialVersionUID = 1L;
				public void buttonClick(ClickEvent event) { 
					if(binder.isValid())
						save();
					else
						Notification.show("Invalid Field",
				                "insertion failed!",
				                Notification.Type.ERROR_MESSAGE);
			    } 
		 });
		
		addComponents(textField_name,button_submit); 
		setStyleName("FormLayout");
	}

	private void setBinder() { 
		binder = new Binder<>();
		
		// Start by defining the Field instance to use
		binder.forField(textField_name)
		  .asRequired("name should be required")
		  // Finalize by doing the actual binding to the CategoryModel class
		  .bind(
		    // Callback that loads the name from a categoryModel instance
		    CategoryModel::getName,
		    // Callback that saves the name in a categoryModel instance
		    CategoryModel::setName); 
		
		binder.setBean(categoryModel); /**  TWO WAY BINDING **/
		
	}

	protected void save() { 
		categoryModel.setOid(0); // reason: singleton bean. advantage: each time generate unique oid
		categoryController.save(categoryModel); 
    	 
		categoryListLayout.createList();
		
		Notification.show("New Category Added",
                "Successfully!",
                Notification.Type.HUMANIZED_MESSAGE);
		
		launchCascadingEffect(false);
		
	}

	private void launchCascadingEffect(boolean flag) {
		productFormLayout.cascadingEffect(flag);
	}
}
