package com.afkghouri.JPAVaadinAssignment;
 
 
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne; 
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="products")
public class ProductModel {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     public long oid;
     @Column(name="name")
     public String name;
     @Column(name="price")
     public int price;
     @Column(name="quantity")
     public int quantity;
     @Column(name="path")
     public String path;
      
     
     @ManyToOne
     @JoinColumn(name="categories_oid")
     public CategoryModel categoryModel;
      
     
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public CategoryModel getCategoryModel() {
		return categoryModel;
	}
	public void setCategoryModel(CategoryModel categoryModel) {
		this.categoryModel = categoryModel;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	 

     
}
