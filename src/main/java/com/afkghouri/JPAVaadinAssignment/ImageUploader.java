package com.afkghouri.JPAVaadinAssignment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Layout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;

class ImageUploader implements Receiver, SucceededListener {
     
	private static final long serialVersionUID = 1L;
	public File file;
	String absolutePath;
    public Embedded image;
    Upload upload;
    

    public ImageUploader(){}
    public ImageUploader(Embedded image) {
		this.image = image;
	}
   
    public Panel setImageUploaderLayout(){
    	       // Show uploaded file in this placeholder
    			image = new Embedded("Uploaded Image");
    			image.setVisible(false);
    			 
    			// Create the upload with a caption and set receiver later
    		    upload = new Upload("Upload Image Here", this);
    			upload.setButtonCaption("Start Upload");
    			upload.addSucceededListener(this);

    			// Put the components (upload, image) in a panel
    			Panel panel = new Panel("Product Image Storage");
    			Layout panelContent = new VerticalLayout();
    			panelContent.addComponents(upload, image);
    			panel.setContent(panelContent);
    			return panel;
    }
    @Override
    public OutputStream receiveUpload(String filename,
                                      String mimeType) {
    	this.absolutePath = "/Users/farhan/Documents/MAVEN/JPAVaadinAssignment/src/main/resources/images/"+filename;
        // Create upload stream
        FileOutputStream fos = null; // Stream to write to
        try {
            // Open the file for writing.
            file = new File(absolutePath);
            fos = new FileOutputStream(file);
        } catch (final java.io.FileNotFoundException e) {
            new Notification("Could not open file<br/>",
                             e.getMessage(),
                             Notification.Type.ERROR_MESSAGE)
                .show(Page.getCurrent());
            return null;
        }
        return fos; // Return the output stream to write to
    }

    @Override
    public void uploadSucceeded(SucceededEvent event) {
        // Show the uploaded file in the image viewer
        image.setVisible(true);
        image.setSource(new FileResource(file));
		Notification.show("Image Saved",
                "Successfully!",
                Notification.Type.HUMANIZED_MESSAGE);
    }
    
    
}