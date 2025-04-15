package com.springboot.case_study.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.case_study.exception.InvalidIdException;
import com.springboot.case_study.model.Doctor;
import com.springboot.case_study.model.User;
import com.springboot.case_study.repository.DoctorRepository;

@Service
public class DoctorService {
	
	@Autowired
	private DoctorRepository doctorRepository;
	
	@Autowired
	private AuthService authService;

	public Doctor addDoctor(int userId, Doctor doctor) throws InvalidIdException {
		 User user = authService.findById(userId); 
		 doctor.setUser(user);
		return doctorRepository.save(doctor);
	}

	public Doctor findById(int docId) throws InvalidIdException {
		Optional<Doctor> optional = doctorRepository.findById(docId);
		
		if(optional.isEmpty()) {
			throw new InvalidIdException("Invalid Doctor Id...");
		}
		
		return optional.get();
		
	}
	
	

}
