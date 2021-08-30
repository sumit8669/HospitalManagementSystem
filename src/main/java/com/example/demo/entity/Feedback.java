package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	private String pname;
	
	private String feedback;
	
	private String ans;
	
	
	
	public Feedback()
	{
		
	}
	
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", pname=" + pname + ", feedback=" + feedback + ", ans=" + ans + "]";
	}

	public Feedback(String pname, String feedback, String ans) {
		this.pname = pname;
		this.feedback = feedback;
		this.ans = ans;
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
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	
	
}
