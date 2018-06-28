package com.afkghouri.JPAVaadinAssignment;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;


public class Waseem {
	ProductModel pm;
	Button b; 
	ProductController pc;
	
	public Waseem(){}
	public Waseem(ProductModel pm,ProductController pc) {
		System.out.println("In waseem constructor ");
		this.pm=pm;
		this.pc=pc;
	}
	@PostConstruct
	void init(){
		System.out.println("In waseem init "+pc); 
		 
	}
	 
}
