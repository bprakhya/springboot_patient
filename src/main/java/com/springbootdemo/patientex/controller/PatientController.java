package com.springbootdemo.patientex.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootdemo.patientex.entity.Patient;
import com.springbootdemo.patientex.service.PatientService;



@RestController
@ResponseBody
public class PatientController {
	@Autowired
	private PatientService patientservice;
	
	@PostMapping("/patients")
	//@ResponseStatus(code= HttpStatus.OK, reason="OK")
	public ResponseEntity<Patient> savePatient (@RequestBody Patient patient) {
		Patient p=patientservice.savePatient(patient);
		return ResponseEntity.status(HttpStatus.OK).body(p);
		//return patientservice.savePatient(patient);
	}
	
	@GetMapping("/patients")
	public List<Patient> fetchPatientList(){
		return patientservice.fetchPatientList();
	}
	
	@GetMapping("/patient/{id}")
	public ResponseEntity<Patient> fetchPatientById(@PathVariable("id")String Patientid) {
		Patient p=patientservice.fetchPatientById(Patientid);
		if(Objects.isNull(p)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(p);
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(p);
		}
		//return patientservice.fetchPatientById(Patientid);
	}
	
	@DeleteMapping("/patients/{id}")
	public String deletePatientById(@PathVariable("id")String Patientid) {
		patientservice.deletePatientById(Patientid);
		return "Patient deleted successfully";
	}
	
	@PutMapping("/patients/{id}")
	public Patient updatePatient(@PathVariable("id")String Patientid,@RequestBody Patient patient) {
		return patientservice.updatePatient(Patientid,patient);
	}

}
