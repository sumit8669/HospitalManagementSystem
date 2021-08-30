package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Booking 
{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	
	private String pname;
	
	private String dname;
	
	private String dno;
	
	private String dmail;
	
	
	
	public Booking()
	{
		
	}

	public Booking(String pname, String dname, String dno, String dmail) {
		this.pname = pname;
		this.dname = dname;
		this.dno = dno;
		this.dmail = dmail;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getDno() {
		return dno;
	}

	public void setDno(String dno) {
		this.dno = dno;
	}

	public String getDmail() {
		return dmail;
	}

	public void setDmail(String dmail) {
		this.dmail = dmail;
	}

	
	
}
