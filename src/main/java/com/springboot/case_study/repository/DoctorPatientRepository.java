package com.springboot.case_study.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.case_study.model.DoctorPatient;

public interface DoctorPatientRepository extends JpaRepository<DoctorPatient, Integer> {

	List<DoctorPatient> findByDoctorId(int docId);

}
