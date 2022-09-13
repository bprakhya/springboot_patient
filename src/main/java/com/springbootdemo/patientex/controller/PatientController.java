package com.springbootdemo.patientex.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	@CrossOrigin(origins ="http://localhost:4200/")
	//@ResponseStatus(code= HttpStatus.OK, reason="OK")
	public ResponseEntity<Patient> savePatient (@RequestBody Patient patient) {
		Patient p;
		try {
			p=patientservice.savePatient(patient);
			return ResponseEntity.of(Optional.of(p));
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		//return patientservice.savePatient(patient);
	}

	//@ResponseStatus(code= HttpStatus.OK, reason="OK")
	@GetMapping("/patients")
	@CrossOrigin(origins ="http://localhost:4200/")
	public ResponseEntity<List<Patient>> fetchPatientList(){
		List<Patient> l=patientservice.fetchPatientList();
		if(l.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(l));
	}
	
	@GetMapping("/patient/{id}")
	@CrossOrigin(origins ="http://localhost:4200/")
	public ResponseEntity<Patient> fetchPatientById(@PathVariable("id")String Patientid) {
		Patient p=patientservice.fetchPatientById(Patientid);
		if(Objects.isNull(p)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(p));
	}
	
	@DeleteMapping("/patients/{id}")
	@CrossOrigin(origins ="http://localhost:4200/")
	public ResponseEntity<String> deletePatientById(@PathVariable("id")String Patientid) {
		Patient p=patientservice.fetchPatientById(Patientid);
		if(Objects.isNull(p)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			patientservice.deletePatientById(Patientid);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Patient deleted successfully");
		}
		//return "Patient deleted successfully";
	}
	
	@PutMapping("/patients/{id}")
	@CrossOrigin(origins ="http://localhost:4200/")
	public ResponseEntity<Patient> updatePatient(@PathVariable("id")String Patientid,@RequestBody Patient patient) {
		Patient p=patientservice.fetchPatientById(Patientid);
		if(Objects.isNull(p)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else {
			p=patientservice.updatePatient(Patientid,patient);
			return ResponseEntity.of(Optional.of(p));
		}
		//return patientservice.updatePatient(Patientid,patient);
	}

}
