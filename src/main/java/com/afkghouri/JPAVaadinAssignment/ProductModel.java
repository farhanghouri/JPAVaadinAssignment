package com.afkghouri.JPAVaadinAssignment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="products")
public class ProductModel {
     @Id
     public long oid;
     @Column(name="name")
     public String name;
     @Column(name="price")
     public int price;
     @Column(name="quantity")
     public int quantity;
     
     @ManyToOne
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
	

     
}
