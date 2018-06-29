package com.afkghouri.JPAVaadinAssignment;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
     
    // @ManyToOne
     //public CategoryModel categoryModel;

      
     @OneToMany
    // @JoinColumn(name="categories_oid")
     public List<CategoryModel> categoryModel = new ArrayList<>();
     
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
	public List<CategoryModel> getCategoryModel() {
		return categoryModel;
	}
	public void setCategoryModel(List<CategoryModel> categoryModel) {
		this.categoryModel = categoryModel;
	}
	 
	

     
}
