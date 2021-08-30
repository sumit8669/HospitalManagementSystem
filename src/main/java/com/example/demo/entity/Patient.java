package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String email;
	private String mobile;
	private String uname;
	private String pass;
	private String cpass;
	private String bdname;
	private String dno;
	private String demail;
	private String date;
	
	public String getBdname() {
		return bdname;
	}

	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setBdname(String bdname) {
		this.bdname = bdname;
	}


	public String getDno() {
		return dno;
	}


	public void setDno(String dno) {
		this.dno = dno;
	}


	public Patient()
	{
		
	}
	
	
	
	public String getDemail() {
		return demail;
	}


	public void setDemail(String demail) {
		this.demail = demail;
	}


	public Patient(String name, String email, String mobile, String uname, String pass, String cpass, String bdname,
			String dno ,String demail ,String date) {
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.uname = uname;
		this.pass = pass;
		this.cpass = cpass;
		this.bdname = bdname;
		this.dno = dno;
		this.demail=demail;
		this.date=date;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getCpass() {
		return cpass;
	}
	public void setCpass(String cpass) {
		this.cpass = cpass;
	}

	
}
