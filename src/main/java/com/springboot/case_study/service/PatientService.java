package com.springboot.case_study.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.case_study.exception.InvalidIdException;
import com.springboot.case_study.model.MedicalHistory;
import com.springboot.case_study.model.Patient;
import com.springboot.case_study.model.User;
import com.springboot.case_study.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;
	@Autowired
	private AuthService authService;
	@Autowired
	private MedicalHistoryService medicalHistoryService;

	public Patient addPatient(int userId, int mhId, Patient patient) throws InvalidIdException {
		

        User user = authService.findById(userId); 
       

        MedicalHistory medicalHistory = medicalHistoryService.findById(mhId);

        patient.setUser(user);
        patient.setMedicalHistory(medicalHistory);

        return patientRepository.save(patient);
	}

	public Patient findById(int patId) throws InvalidIdException {
		
		Optional<Patient> optional = patientRepository.findById(patId);
		
		if(optional.isEmpty()) {
			throw new InvalidIdException("Invalid Patient Id...");
		}
		
		return optional.get();
		
	}

}
