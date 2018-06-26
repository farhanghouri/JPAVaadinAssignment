package com.afkghouri.JPAVaadinAssignment;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class EmployeeModel {
     @Id
     public long oid;
     public String ename;
     public int phno;
	public long getOid() {
		return oid;
	}
	public void setOid(long oid) {
		this.oid = oid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public int getPhno() {
		return phno;
	}
	public void setPhno(int phno) {
		this.phno = phno;
	}
     
}
