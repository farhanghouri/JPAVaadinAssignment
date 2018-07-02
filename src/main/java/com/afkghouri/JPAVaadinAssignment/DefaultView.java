package com.afkghouri.JPAVaadinAssignment;

import com.vaadin.navigator.View;
import com.vaadin.ui.Composite;
import com.vaadin.ui.Label;

 
public class DefaultView extends Composite implements View {
 
	private static final long serialVersionUID = 1L;

	public DefaultView() {
        setCompositionRoot(new Label("This is the default view"));
    }
}