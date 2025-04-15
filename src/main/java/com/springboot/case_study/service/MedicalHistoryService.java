package com.springboot.case_study.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.case_study.exception.InvalidIdException;
import com.springboot.case_study.model.MedicalHistory;
import com.springboot.case_study.repository.MedicalHistoryRepository;

@Service
public class MedicalHistoryService {
	
	@Autowired
	private MedicalHistoryRepository medicalHistoryRepository;

	public MedicalHistory addMedicalHistory(MedicalHistory medicalHistory) {

		
		return medicalHistoryRepository.save(medicalHistory);
	}

	public MedicalHistory findById(int mhId) throws InvalidIdException  {
		
		Optional<MedicalHistory> optional = medicalHistoryRepository.findById(mhId);
		
		if(optional.isEmpty()) {
			throw new InvalidIdException("Medical History  Id...");
		}
		
		return optional.get();

	}
	

}
