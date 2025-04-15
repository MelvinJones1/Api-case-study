package com.springboot.case_study.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.case_study.model.MedicalHistory;

public interface MedicalHistoryRepository  extends JpaRepository<MedicalHistory, Integer>{

}
