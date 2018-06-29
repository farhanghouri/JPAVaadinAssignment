package com.afkghouri.JPAVaadinAssignment;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class CategoryModel {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      public long oid;
      public String name;
      
      //@OneToMany(mappedBy="productModel")
    //  public List<ProductModel> list;
      
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
}
