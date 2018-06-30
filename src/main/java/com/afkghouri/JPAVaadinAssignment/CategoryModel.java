package com.afkghouri.JPAVaadinAssignment;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class CategoryModel {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      public long oid;
      public String name;
      
//      @OneToOne
//      @JoinColumn(name="products_oid")
//      public ProductModel productModel;
      
     //   @ManyToOne
       // public ProductModel productModel;
      
//      @OneToMany(mappedBy = "categoryModel")
//      public List<ProductModel> productModels = new ArrayList<>();
      
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
	
//	public ProductModel getProductModel() {
//		return productModel;
//	}
//	public void setProductModel(ProductModel productModel) {
//		this.productModel = productModel;
//	}
	
	
}
