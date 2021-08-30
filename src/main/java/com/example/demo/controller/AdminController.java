package com.example.demo.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.DoctorEntity;
import com.example.demo.entity.Feedback;
import com.example.demo.entity.Patient;
import com.example.demo.repository.BookingRepo;
import com.example.demo.repository.DoctorEntityRepo;
import com.example.demo.repository.FeedBackRepo;
import com.example.demo.repository.PatientRepo;



@Controller
public class AdminController 
{
	
	@Autowired
	private DoctorEntityRepo der;
	
	@Autowired
	private FeedBackRepo fbr;
	
	@Autowired
	private PatientRepo pr;
	
	@Autowired
	private BookingRepo br;
	
	
	
	@RequestMapping("adddoc")
	String addDoctor()
	{
		return"AddDoctor";
	}
	
	@RequestMapping("deldoc")
	String delDoctor()
	{
		
		return"DelDoctor";
	}
	@RequestMapping("book")
	String book(Model m)
	{
		m.addAttribute("ad",br.findAll());
		return "BookingDetails";
	}
	
	@RequestMapping("alogout")
	String logout()
	{
		return"redirect:/";
	}
	
	@RequestMapping("saveDoctor")
	String addDoc(@ModelAttribute DoctorEntity doc,@RequestParam("file")MultipartFile mf)
			throws Exception
	{
		  
		
		 doc.setImage(mf.getBytes());
		
		 der.save(doc);
		 
		return "AdminHome";
	}
	
	@RequestMapping("deld")
	String delete(@PathParam(value = "docid")String docid, Model m1)
	{
		Optional<DoctorEntity> oid = der.findByDocid(docid);
		if(oid.isPresent())
		{
			DoctorEntity doctorEntity = oid.get();
			
			m1.addAttribute("doc1",doctorEntity);
			
			return"DelDoctor1";
		}
		else
		{
			return"DelDoctor";
		}
	}
	@RequestMapping("delDoc")
	String delete(@RequestParam(name = "docid")String id)
	{
		der.deleteByDocid(id);
		
		return"AdminHome";
	}
	
	@RequestMapping("saveFeed")
	String saveFeedBack(@RequestParam(name = "feedback")String fd ,@RequestParam(name = "ans")String a , HttpSession hs)
	{
		Feedback fb = new Feedback();
		fb.setAns(a);
		fb.setFeedback(fd);
		fb.setPname(hs.getAttribute("pname").toString());
		fbr.save(fb);
		return "ThankYou";
	}
	@RequestMapping("notify")
	String notifi(Model m)
	{
		m.addAttribute("fd",fbr.findAll() );
		
		return "AdminNotify";
	}
	@RequestMapping("feedDelete")
	String deleteFeedBack(@RequestParam(name = "pid")int pid)
	{
		fbr.deleteById(pid);
		return "AdminNotify";
	}
	
	
	@RequestMapping("setD")
	String setDate(@RequestParam(value = "date")String date,@RequestParam(value = "did")int id,HttpSession ss)
	{
		pr.dateUpdate(date,(long) ss.getAttribute("pid"));
		
		Optional<Patient> pm = pr.findById((long) ss.getAttribute("pid"));
		String msg ="Your Appointment Booked Successfully";
		if(pm.isPresent())
		{
			Mail.send(msg, pm.get().getEmail());
		}
		
		br.deleteById(id);
		
		return "redirect:/book";
	}
	
	
	
	
	
	
	
}
