package com.afkghouri.JPAVaadinAssignment;

import org.springframework.beans.factory.annotation.Autowired;

 
import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI; 
import com.vaadin.ui.themes.ValoTheme;
 

@SpringUI
@Theme("valo")
public class VaadinUI extends UI{

	private static final long serialVersionUID = 1L;
	HorizontalLayout mainLayout;
	@Autowired
	ProductView productView;
	@Autowired
	CategoryView categoryView;
	 
	@Override
	protected void init(VaadinRequest request) { 
		System.out.println("init");
		setLayout(); 
		setNavBar(); 
	}

	private void setNavBar() {
		Label title = new Label("Menu");
        title.addStyleName(ValoTheme.MENU_TITLE);

        Button button_product = new Button("Products", e -> getNavigator().navigateTo("product")); 
        button_product.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);
        //button_product.setStyleName(".b");
        Button button_category = new Button("Categories", e -> getNavigator().navigateTo("category"));
        button_category.addStyleNames(ValoTheme.BUTTON_LINK, ValoTheme.MENU_ITEM);

        CssLayout menu = new CssLayout(title, button_product, button_category);
        menu.addStyleName(ValoTheme.MENU_ROOT); 
        
        CssLayout viewContainer = new CssLayout(); 
        
        mainLayout.addComponents(menu,viewContainer);

        Navigator navigator = new Navigator(this, viewContainer);
        navigator.addView("", DefaultView.class);
        navigator.addView("product", productView);
        navigator.addView("category", categoryView);
       
        /**
         * 
         * 
         */
        
//        UI.getCurrent().getPage().getStyles().add(".b"+
//        " {\n"+
//         " color: red;"+
//        "\n}");
        
        
		
	}
 
	 
	private void setLayout() {
		mainLayout = new HorizontalLayout();  
		mainLayout.setSizeFull();
		setContent(mainLayout); 
	}
	

}
