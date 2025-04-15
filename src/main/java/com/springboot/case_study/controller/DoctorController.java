package com.springboot.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.case_study.exception.InvalidIdException;
import com.springboot.case_study.model.Doctor;
import com.springboot.case_study.service.DoctorService;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {
	
	@Autowired
	private DoctorService doctorService;
	
	@PostMapping("/add/{userId}")
	public Doctor addDoctor(@PathVariable int userId, @RequestBody Doctor doctor) throws InvalidIdException {
		return doctorService.addDoctor(userId,doctor);
		
	}

}
