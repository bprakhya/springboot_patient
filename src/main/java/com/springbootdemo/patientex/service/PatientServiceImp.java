package com.springbootdemo.patientex.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootdemo.patientex.entity.Patient;
import com.springbootdemo.patientex.repository.PatientRepository;

@Service
public class PatientServiceImp implements PatientService{
	
	@Autowired
	private PatientRepository patientrepository;

	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientrepository.save(patient);
	}

	@Override
	public List<Patient> fetchPatientList() {
		// TODO Auto-generated method stub
		return patientrepository.findAll();
	}

	@Override
	public Patient fetchPatientById(String patientid) {
		// TODO Auto-generated method stub
		Patient p=null;
		try {
			p=patientrepository.findById(patientid).get();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deletePatientById(String patientid) {
		// TODO Auto-generated method stub
		patientrepository.deleteById(patientid);
	}

	@Override
	public Patient updatePatient(String patientid, Patient patient) {
		// TODO Auto-generated method stub
		Patient patDB=patientrepository.findById(patientid).get();
		if(Objects.nonNull(patient.getName()) && !"".equalsIgnoreCase(patient.getName())) {
			patDB.setName(patient.getName());
		}
		if(Objects.nonNull(patient.getAddress()) && !"".equalsIgnoreCase(patient.getAddress())) {
			patDB.setAddress(patient.getAddress());
		}
		return patientrepository.save(patDB);
	}

}
