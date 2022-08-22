package com.springbootdemo.patientex.service;

import java.util.List;

import com.springbootdemo.patientex.entity.Patient;

public interface PatientService {

	public Patient savePatient(Patient patient);

	public List<Patient> fetchPatientList();

	public Patient fetchPatientById(String patientid);

	public void deletePatientById(String patientid);

	public Patient updatePatient(String patientid, Patient patient);

}
