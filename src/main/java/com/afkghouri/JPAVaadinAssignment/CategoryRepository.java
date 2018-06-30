package com.afkghouri.JPAVaadinAssignment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
	public CategoryModel findByName(String name);
}
