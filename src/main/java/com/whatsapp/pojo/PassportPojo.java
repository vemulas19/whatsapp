package com.whatsapp.pojo;

public class PassportPojo {
	
	private Integer id;
	private String locationissued;
	private AddressPojo address;
	
	public PassportPojo() {
		System.out.println("passport");
	}
	public AddressPojo getAddress() {
		return address;
	}
	public void setAddress(AddressPojo address) {
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLocationissued() {
		return locationissued;
	}
	public void setLocationissued(String locationissued) {
		this.locationissued = locationissued;
	}
	

}
