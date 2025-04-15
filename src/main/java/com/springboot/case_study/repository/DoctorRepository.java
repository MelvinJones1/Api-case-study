package com.springboot.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.case_study.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>{

}
