package com.mindtree.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Patient {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int patientId;
	private String patientName;
	private int age;
	@OneToOne(cascade=CascadeType.ALL)
	private QuarantineCenter quarantine;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(int patientId, String patientName, int age, QuarantineCenter quarantine) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.age = age;
		this.quarantine = quarantine;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public QuarantineCenter getQuarantine() {
		return quarantine;
	}
	public void setQuarantine(QuarantineCenter quarantine) {
		this.quarantine = quarantine;
	}
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", age=" + age + ", quarantine="
				+ quarantine + "]";
	}
	
	
	

}
