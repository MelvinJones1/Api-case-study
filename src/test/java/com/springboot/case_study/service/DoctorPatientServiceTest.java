package com.springboot.case_study.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.springboot.case_study.enums.Speciality;
import com.springboot.case_study.exception.InvalidIdException;
import com.springboot.case_study.model.Doctor;
import com.springboot.case_study.model.DoctorPatient;
import com.springboot.case_study.model.Patient;
import com.springboot.case_study.repository.DoctorPatientRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DoctorPatientServiceTest {

    @InjectMocks
    private DoctorPatientService doctorPatientService;

    @Mock
    private DoctorPatientRepository doctorPatientRepository;

    @Mock
    private DoctorService doctorService;

    Doctor d1, d2;
    Patient p1, p2, p3;
    DoctorPatient dp1, dp2, dp3;

    @BeforeEach
    public void init() {
        d1 = new Doctor(1, "Dr. Strange", Speciality.PHYSICIAN, null); 
        d2 = new Doctor(2, "Dr. House", Speciality.ORTHO, null);

        p1 = new Patient(1, "Tony Stark", 45, null, null); 
        p2 = new Patient(2, "Bruce Banner", 40, null, null);
        p3 = new Patient(3, "Steve Rogers", 39, null, null);

        dp1 = new DoctorPatient(1, LocalDate.of(2024, 4, 15), "10:00 AM", d1, p1);
        dp2 = new DoctorPatient(2, LocalDate.of(2024, 4, 16), "11:00 AM", d1, p2);
        dp3 = new DoctorPatient(3, LocalDate.of(2024, 4, 17), "12:00 PM", d2, p3);
    }

    @Test
    public void getPatientsByDoctorIdTest() throws InvalidIdException {
    	
        when(doctorService.findById(1)).thenReturn(d1);
        when(doctorService.findById(2)).thenReturn(d2);

        when(doctorPatientRepository.findByDoctorId(1)).thenReturn(Arrays.asList(dp1, dp2));
        when(doctorPatientRepository.findByDoctorId(2)).thenReturn(Arrays.asList(dp3));

        try {
            List<Patient> patientsForD1 = doctorPatientService.getPatientsByDoctorId(1);
            assertEquals(2, patientsForD1.size());
        } catch (InvalidIdException e) {
        }

        try {
            List<Patient> patientsForD2 = doctorPatientService.getPatientsByDoctorId(2);
            assertEquals(1, patientsForD2.size());
        } catch (InvalidIdException e) {
        }

        verify(doctorService, times(1)).findById(1);
        verify(doctorService, times(1)).findById(2);
        verify(doctorPatientRepository, times(1)).findByDoctorId(1);
        verify(doctorPatientRepository, times(1)).findByDoctorId(2);

    }
}
