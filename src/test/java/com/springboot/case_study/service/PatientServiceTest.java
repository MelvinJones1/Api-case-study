package com.springboot.case_study.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.case_study.exception.InvalidIdException;
import com.springboot.case_study.model.Patient;
import com.springboot.case_study.repository.PatientRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

	 	@InjectMocks
	    private PatientService patientService;

	    @Mock
	    private PatientRepository patientRepository;

	    Patient p1;

	    @BeforeEach
	    public void init() {
	        p1 = new Patient(1, "Tony Stark", 45, null, null);
	    }

	    @Test
	    public void testPatientFindById() throws InvalidIdException {
	        when(patientRepository.findById(1)).thenReturn(Optional.of(p1));

	        Patient result = patientService.findById(1);
	        assertEquals("Tony Stark", result.getName());
	        
	        verify(patientRepository, times(1)).findById(1);
	        
	    }
}
