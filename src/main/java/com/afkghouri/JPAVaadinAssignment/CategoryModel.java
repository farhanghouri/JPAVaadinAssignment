package com.afkghouri.JPAVaadinAssignment;
 
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="categories")
public class CategoryModel {
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      public long oid;
      public String name;
      
      @OneToMany(cascade = CascadeType.ALL)
      @JoinColumn(name="categories_oid")
      List<ProductModel> list;
       
      
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
