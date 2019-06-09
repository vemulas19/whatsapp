package com.whatsapp.pojo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Component
public class EmployeePojo {
	
	private Integer id;
	private String name;
	private String city;
	private String company;
	
	private PassportPojo pport;
	private Pancard pan;
	
	public Pancard getPan() {
		return pan;
	}
	public void setPan(Pancard pan) {
		this.pan = pan;
	}
	public EmployeePojo() {
		System.out.println("hello emp constructor");
	}
	public EmployeePojo(PassportPojo p) {
		this.pport = p;
	}
	
	public PassportPojo getPport() {
		return pport;
	}
	public void setPport(PassportPojo pport) {
		this.pport = pport;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	

}
