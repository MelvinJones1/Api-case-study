package com.springboot.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.case_study.exception.InvalidIdException;
import com.springboot.case_study.model.Patient;
import com.springboot.case_study.service.PatientService;


@RestController
@RequestMapping("/api/patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	
	@PostMapping("/add/{userId}/{mhId}")
	public Patient addPatient(@PathVariable int userId,@PathVariable int mhId, @RequestBody Patient patient) throws InvalidIdException {
		return patientService.addPatient(userId,mhId,patient);
	}
	

}
