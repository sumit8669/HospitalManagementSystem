package com.example.demo.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepo;

@Controller
public class CoreController 
{

	@Autowired
	PatientRepo pr;
	
	@RequestMapping("/")
	String home()
	{
		return"home";
	}
	
	@GetMapping("home")
	String hom()
	{
		return "redirect:/";
	}
	
	@GetMapping("regis")
	String regis()
	{
		return "Registration";
	}
	
	@RequestMapping("save")
	String registration(@ModelAttribute Patient p) 
	{
		
		p.setDno(null);
		p.setBdname(null);
		p.setDate(null);
		pr.save(p);
		
		return"redirect:/";
	}
	
	@GetMapping("login")
	String login()
	{
		return"Login";
	}
	
	@PostMapping("check")
	String valid(@PathParam(value  = "uname")String uname,@PathParam(value  = "pass")String pass,HttpSession hs)
	{
		if(uname.equals("Admin") && pass.equals("Admin123"))
		{
			return"AdminHome";
		}
		Optional<Patient> op = pr.findByUnameAndPass(uname, pass);
		if(op.isPresent())
		{
			Patient patient = op.get();
			hs.setAttribute("pid", patient.getId());
			hs.setAttribute("pname", patient.getName());
			return "Patient";
		}
		else
		{
			return "redirect:/login";
		}
		
	}
	
	@RequestMapping("logout")
	String LogOut()
	{
		return"redirect:/";
	}
	@RequestMapping("contact")
	String ContactUs()
	{
		return"Contact";
	}
	@RequestMapping("about")
	String AboutUs()
	{
		return"About";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
