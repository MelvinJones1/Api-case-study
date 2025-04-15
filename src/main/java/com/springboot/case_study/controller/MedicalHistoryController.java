package com.springboot.case_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.case_study.model.MedicalHistory;
import com.springboot.case_study.service.MedicalHistoryService;

@RestController
@RequestMapping("/api/medical-history")
public class MedicalHistoryController {
	
	@Autowired
	private MedicalHistoryService medicalHistoryService;
	
	
	@PostMapping("/add")
	public MedicalHistory addMedicalHistory(@RequestBody MedicalHistory medicalHistory) {
		return medicalHistoryService.addMedicalHistory(medicalHistory);
	}
	
	
	
	

}
