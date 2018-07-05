package com.afkghouri.JPAVaadinAssignment;

import java.io.File;
import org.springframework.stereotype.Component;

import com.vaadin.server.FileResource; 
import com.vaadin.ui.Window;

@Component
public class EditImageWindow extends Window{
 
	private static final long serialVersionUID = 1L;
	String absolutePath="/Users/farhan/Documents/MAVEN/JPAVaadinAssignment/src/main/resources/images/samsung.jpg";
	ImageUploader receiver;

	public EditImageWindow() { 
		super("Product Image in Edit Mode");
	} 
	public EditImageWindow(String name) {
		super(name);
	}
	
	public void constructWindow(){  

		setImageUploader();
        // Center it in the browser window
        center();

	}
	
	private void setImageUploader() {
		receiver = new ImageUploader(); 
		setContent(receiver.setImageUploader());
		receiver.image.setVisible(true);
		receiver.image.setSource(new FileResource(new File(absolutePath)));
		
	}
	
	 
}
