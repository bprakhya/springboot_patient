package com.springbootdemo.patientex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootdemo.patientex.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient ,String>{

}
