package com.springbootdemo.patientex.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
	@Id
	private String ID;
	private String Name;
	private String Address;
	private String dcode;
	private String ddate;
	
	public String getPatient_ID() {
		return ID;
	}
	public void setPatient_ID(String ID) {
		this.ID=ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name=Name;
	}
	public String getdcode() {
		return dcode;
	}
	public void setdcode(String dcode) {
		this.dcode=dcode;
	}
	public String getddate() {
		return ddate;
	}
	public void setddate(String ddate) {
		this.ddate=ddate;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String Address) {
		this.Address=Address;
	}
	public Patient(String ID,String Name,String Address,String dcode,String ddate) {
		this.ID=ID;
		this.Name=Name;
		this.Address=Address;
		this.dcode=dcode;
		this.ddate=ddate;
	}
	public Patient() {}
	@Override
	public String toString() {
		return "Patient{"+ "PatientID="+ ID +" ,Name="+ Name+" ,Address="+ Address+" ,Diseasecode="+ dcode+" ,Date="+ddate+" }";
	}
}
