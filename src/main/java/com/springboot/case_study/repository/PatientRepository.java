package com.springboot.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.case_study.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
