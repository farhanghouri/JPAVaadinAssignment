package com.afkghouri.JPAVaadinAssignment;

 
 
import com.vaadin.ui.Window;

 
public class EditImageWindow extends Window{
 
	private static final long serialVersionUID = 1L; 
	ImageUploader receiver;

	public EditImageWindow() { 
		super("Product Image in Edit Mode");
		constructWindow();
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
