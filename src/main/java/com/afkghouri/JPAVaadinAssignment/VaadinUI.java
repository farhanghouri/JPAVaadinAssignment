package com.afkghouri.JPAVaadinAssignment;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI; 
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
 

@SpringUI
@Theme("valo")
public class VaadinUI extends UI{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	VerticalLayout mainLayout;
	@Autowired
	FormLayout formLayout;
	@Autowired
	ListLayout listLayout;
	
	
	@Override
	protected void init(VaadinRequest request) { 
		setLayout(mainLayout); 
		setLabel();
		setFormLayout();
		setListLayout();
	}

	private void setListLayout() { 
		System.out.println("vaui: "+listLayout);
		mainLayout.addComponent(listLayout);
	}

	private void setFormLayout() { 
		mainLayout.addComponent(formLayout);
	}

	private void setLabel() { 
		com.vaadin.ui.Label label = new com.vaadin.ui.Label("PRODUCT'S FORM");
		mainLayout.addComponent(label);
	}

	private void setLayout(VerticalLayout mainLayout2) {
		mainLayout = new VerticalLayout(); 
		mainLayout.setMargin(true);
		mainLayout.setSpacing(true); 
		setContent(mainLayout); 
	}
	

}
