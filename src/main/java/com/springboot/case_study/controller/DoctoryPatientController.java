package com.springboot.case_study.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.case_study.exception.InvalidIdException;
import com.springboot.case_study.model.DoctorPatient;
import com.springboot.case_study.model.Patient;
import com.springboot.case_study.service.DoctorPatientService;

@RestController
@RequestMapping("/api")
public class DoctoryPatientController {
	
	@Autowired
	private DoctorPatientService doctorPatientService;
	
	
	@PostMapping("/doctor/patient/appointment/{docId}/{patId}")
	public DoctorPatient addAppointment(@PathVariable int docId, @PathVariable int patId, @RequestBody DoctorPatient doctorPatient) throws InvalidIdException {
		return doctorPatientService.addAppointment(docId,patId,doctorPatient);
	}
	
	@GetMapping("/patients/all/{docId}")
	public List<Patient> getPatientsByDoctorId(@PathVariable int docId) throws InvalidIdException{
		
		return doctorPatientService.getPatientsByDoctorId(docId);
		
	}
	

}
