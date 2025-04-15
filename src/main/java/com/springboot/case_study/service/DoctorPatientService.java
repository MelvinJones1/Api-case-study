package com.springboot.case_study.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.case_study.exception.InvalidIdException;
import com.springboot.case_study.model.Doctor;
import com.springboot.case_study.model.DoctorPatient;
import com.springboot.case_study.model.Patient;
import com.springboot.case_study.repository.DoctorPatientRepository;

@Service
public class DoctorPatientService {
	
	@Autowired
	private DoctorPatientRepository doctorPatientRepository;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DoctorService doctorService;
	
	

	public DoctorPatient addAppointment(int docId, int patId, DoctorPatient doctorPatient) throws InvalidIdException {
		
		Patient patient = patientService.findById(patId);

        Doctor doctor = doctorService.findById(docId);
        
        if(doctorPatient.getAppointment()==null) {
        	doctorPatient.setAppointment(LocalDate.now());
        }

        doctorPatient.setPatient(patient);
        doctorPatient.setDoctor(doctor);

        return doctorPatientRepository.save(doctorPatient);
	}



	public List<Patient> getPatientsByDoctorId(int docId) throws InvalidIdException {
       
		if(doctorService.findById(docId)==null) {
			throw new InvalidIdException("Invalid Doctor Id....");
		}
		
		List<DoctorPatient> doctorPatients = doctorPatientRepository.findByDoctorId(docId);
		
		
	    List<Patient> patients = doctorPatients.stream()
                .map(DoctorPatient::getPatient)
                .toList();
	    
	    // used list first then tried stream
//	    for(DoctorPatient dp : doctorPatients) {    
//	    	patients.add(dp.getPatient());
//	    }
	                                     
	    return patients;
	}
	
	

}
