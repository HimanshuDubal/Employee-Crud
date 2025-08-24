package com.EmpCrud.entity;

import jakarta.persistence.*;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fnm;
	
	private String lnm;
	
	private String email;
	
	private String dob;
	
	private String gender;
	
	private String education;
	
	private String company;
	
	private String exp;
	
	private String pkg;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id=id;
	}
	
	public String getFnm() {
		return fnm;
	}
	
	public void setFnm(String fnm) {
		this.fnm=fnm;
	}
	
	public String getLnm() {
		return lnm;
	}
	
	public void setLnm(String lnm) {
		this.lnm=lnm;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}
	
	public String getDob() {
		return dob;
	}
	
	public void setDob(String dob) {
		this.dob=dob;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender=gender;
	}
	
	public String getEducation() {
		return education;
	}
	
	public void setEducation(String edu) {
		this.education=edu;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String com) {
		this.company=com;
	}
	
	public String getExp() {
		return exp;
	}
	
	public void setExp(String exp) {
		this.exp=exp;
	}
	
	public String getPkg() {
		return pkg;
	}
	
	public void setPkg(String pkg) {
		this.pkg=pkg;
	}
}
