package com.afkghouri.JPAVaadinAssignment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryController {

	@Autowired
	CategoryRepository categoryRepository;
	
	public CategoryModel findByName(String name){ 
		return categoryRepository.findByName(name);
	}
	
	public void save(CategoryModel categoryModel){
		System.out.println("Category saveCall():");
		categoryRepository.save(categoryModel);
	}
	
	public List<CategoryModel> findAll(){
		System.out.println("Category findAll():");
		return categoryRepository.findAll();
	}

	public void deleteById(long oid) {
		System.out.println("Category deleteById():");
		categoryRepository.deleteById(oid); 
	}
}
