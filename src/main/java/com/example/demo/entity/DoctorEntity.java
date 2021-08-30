package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class DoctorEntity 
{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

private String dept;
private String name;
private String docid;
private String mobile;
private String email;




@Lob
private byte[] image;

public DoctorEntity()
{
	
}


public DoctorEntity(long id, String dept, String name, String docid, String mobile, byte[] image,String email) {
	this.id = id;
	this.dept = dept;
	this.name = name;
	this.docid = docid;
	this.mobile = mobile;
	this.image = image;
	this.email=email;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getDept() {
	return dept;
}
public void setDept(String dept) {
	this.dept = dept;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getDocid() {
	return docid;
}
public void setDocid(String docid) {
	this.docid = docid;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}

public byte[] getImage() {
	return image;
}

public void setImage(byte[] image) {
	this.image = image;
}




}
