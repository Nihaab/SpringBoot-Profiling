package com.jasper.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee 
{
	@Id
	private String eid;
	
	private String ename;
	
	private String eaddress;
	
	private double esalary;
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employee(String eid, String ename, String eaddress, double esalary) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.eaddress = eaddress;
		this.esalary = esalary;
	}


	public String getEid() {
		return eid;
	}


	public void setEid(String eid) {
		this.eid = eid;
	}


	public String getEname() {
		return ename;
	}


	public void setEname(String ename) {
		this.ename = ename;
	}


	public String getEaddress() {
		return eaddress;
	}


	public void setEaddress(String eaddress) {
		this.eaddress = eaddress;
	}


	public double getEsalary() {
		return esalary;
	}


	public void setEsalary(double esalary) {
		this.esalary = esalary;
	}


	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", ename=" + ename + ", eaddress=" + eaddress + ", esalary=" + esalary + "]";
	}
	
	
}
