package com.afkghouri.JPAVaadinAssignment;

import java.io.File;
import org.springframework.stereotype.Component;

import com.vaadin.server.FileResource; 
import com.vaadin.ui.Window;

@Component
public class EditImageWindow extends Window{
 
	private static final long serialVersionUID = 1L; 
	ImageUploader receiver;

	public EditImageWindow() { 
		super("Product Image in Edit Mode");
	} 
	public EditImageWindow(String name) {
		super(name);
	}
	
	public void constructWindow(){  

		setImageUploaderLayout();
        // Center it in the browser window
        center();  

	}
	
	private void setImageUploaderLayout() {
		receiver = new ImageUploader(); 
		setContent(receiver.setImageUploaderLayout()); 
		
	}
	
	 
}
