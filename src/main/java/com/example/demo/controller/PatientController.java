package com.example.demo.controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Booking;
import com.example.demo.entity.DoctorEntity;
import com.example.demo.entity.Patient;
import com.example.demo.repository.BookingRepo;
import com.example.demo.repository.DoctorEntityRepo;
import com.example.demo.repository.PatientRepo;

@Controller
public class PatientController {
	@Autowired
	private DoctorEntityRepo dr;

	@Autowired
	private PatientRepo pr;

	@Autowired
	private BookingRepo br;

	String ss;

	@RequestMapping("dentist")

	String dentist(Model m) {
		ss = "Dentist";

		m.addAttribute("doclist", dr.findByDept(ss));
		return "Dentist";
	}

	@ResponseBody
	@RequestMapping("image")
	byte[] showImage(@RequestParam(name = "id") long id) {
		return dr.findById(id).get().getImage();
	}

	@RequestMapping("medicine")
	String generalmedicine(Model m) {
		ss = "GeneralMedicine";

		m.addAttribute("doclist", dr.findByDept(ss));

		return "GeneralMedicine";
	}

	@RequestMapping("card")
	String cardiology(Model m) {
		ss = "Cardiology";

		m.addAttribute("doclist", dr.findByDept(ss));

		return "Cardiology";
	}

	@RequestMapping("neuro")
	String neurology(Model m) {
		ss = "Neurology";

		m.addAttribute("doclist", dr.findByDept(ss));

		return "Neurology";
	}

	@RequestMapping("ortho")
	String orthopedic(Model m) {
		ss = "Orthopedic";

		m.addAttribute("doclist", dr.findByDept(ss));

		return "Orthopedic";
	}

	@RequestMapping("saveap")
	String bookDoctor(@RequestParam(name = "id") long id, HttpSession hs) {

		Optional<DoctorEntity> dlist = dr.findById(id);
		if (dlist.isPresent()) {
			DoctorEntity d = dlist.get();
			pr.update(d.getName(), d.getMobile(), d.getEmail(), (long) hs.getAttribute("pid"));

			Booking bb = new Booking();

			Optional<Patient> p2 = pr.findById((long) hs.getAttribute("pid"));
			Patient p3 = p2.get();

			bb.setPname(p3.getName());
			bb.setDname(d.getName());
			bb.setDno(d.getMobile());
			bb.setDmail(d.getEmail());

			br.save(bb);

			return "redirect:/phome";

		} else {
			return "Login";
		}
	}

	@RequestMapping("phome")
	String home() {
		return "Patient";
	}

	@RequestMapping("feed")
	String feedBack() {
		return "feedback";
	}

	@RequestMapping("viewapp")
	String viewApp(HttpSession hs, Model m) {
		Optional<Patient> op = pr.findById((long) hs.getAttribute("pid"));
		if (op.isPresent()) {
			Patient patient = op.get();
			m.addAttribute("Dt", patient);

			return "ViewAppointment";
		} else {
			return "redirect:/phome";
		}

	}
}
