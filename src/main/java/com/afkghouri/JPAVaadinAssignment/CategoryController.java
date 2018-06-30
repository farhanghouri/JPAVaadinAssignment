package com.afkghouri.JPAVaadinAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	public CategoryModel findByName(String name){ 
		return categoryRepository.findByName(name);
	}
}
