package com.springbootdemo.patientex.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
	@Id
	private String Patient_ID;
	private String Name;
	private String Address;
	
	public String getPatient_ID() {
		return Patient_ID;
	}
	public void setPatient_ID(String Patient_ID) {
		this.Patient_ID=Patient_ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name=Name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address=Address;
	}
	public Patient(String Patient_ID,String Name,String Address) {
		this.Patient_ID=Patient_ID;
		this.Name=Name;
		this.Address=Address;
	}
	public Patient() {}
	@Override
	public String toString() {
		return "Patient{"+ "PatientID="+ Patient_ID +" ,Name="+ Name+" ,Address="+ Address+" }";
	}
}
