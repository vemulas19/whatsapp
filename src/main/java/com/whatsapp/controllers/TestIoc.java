package com.whatsapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.whatsapp.pojo.EmployeePojo;
import com.whatsapp.pojo.PassportPojo;

@Controller
public class TestIoc {
  
//	@Qualifier(value="jdaemp")
	@Autowired
	EmployeePojo emp;
	
//	@Qualifier(value="jdaemp")
	@Autowired
	EmployeePojo emp1;
	
//    @Qualifier(value="infosysemp")
	@Autowired
	EmployeePojo emp2;
	
	
//    @Qualifier(value="infosysemp")
	@Autowired
	EmployeePojo emp3;
	
	
	@RequestMapping(value="/test")
	public String testIoc(){
		
		PassportPojo p= emp.getPport();
		PassportPojo p1=emp1.getPport();
		
		
		
		System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getCity()+" "+emp.getCompany()+" "+p.getId()+" "+p.getLocationissued()+" "+p.getAddress().getArea()+" "+p.getAddress().getPincode());
		System.out.println(emp1.getId()+" "+emp1.getName()+" "+emp1.getCity()+" "+emp1.getCompany()+" "+p1.getId()+" "+p1.getLocationissued()+" "+p1.getAddress().getArea()+" "+p1.getAddress().getPincode());
		System.out.println(emp2.getId()+" "+emp2.getName()+" "+emp2.getCity()+" "+emp2.getCompany()+" "+p.getId()+" "+p.getLocationissued()+" "+p.getAddress().getArea()+" "+p.getAddress().getPincode());
		System.out.println(emp3.getId()+" "+emp3.getName()+" "+emp3.getCity()+" "+emp3.getCompany()+" "+p1.getId()+" "+p1.getLocationissued()+" "+p1.getAddress().getArea()+" "+p1.getAddress().getPincode());
		
		
		emp.setId(1);
		emp.setName("bittuakula");
		emp.setCity("hyd");
		emp.getPport().setId(1565);
		emp.getPport().setLocationissued("hyderabad");
		emp.getPport().getAddress().setArea("gandhi chowk");
		emp.getPport().getAddress().setPincode("505301");
	
		System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getCity()+" "+emp.getCompany()+" "+p.getId()+" "+p.getLocationissued()+" "+p.getAddress().getArea()+" "+p.getAddress().getPincode());
		System.out.println(emp1.getId()+" "+emp1.getName()+" "+emp1.getCity()+" "+emp1.getCompany()+" "+p1.getId()+" "+p1.getLocationissued()+" "+p1.getAddress().getArea()+" "+p1.getAddress().getPincode());
		System.out.println(emp2.getId()+" "+emp2.getName()+" "+emp2.getCity()+" "+emp2.getCompany()+" "+p.getId()+" "+p.getLocationissued()+" "+p.getAddress().getArea()+" "+p.getAddress().getPincode());
		System.out.println(emp3.getId()+" "+emp3.getName()+" "+emp3.getCity()+" "+emp3.getCompany()+" "+p1.getId()+" "+p1.getLocationissued()+" "+p1.getAddress().getArea()+" "+p1.getAddress().getPincode());
		
		
		emp1.setId(2);
		emp1.setName("sheshi");
		emp1.setCity("banglore");
		emp1.getPport().setId(7272);
		emp1.getPport().setLocationissued("banglore");
		emp1.getPport().getAddress().setArea("nehru nagar");
		emp1.getPport().getAddress().setPincode("909090");
		
		System.out.println(emp.getId()+" "+emp.getName()+" "+emp.getCity()+" "+emp.getCompany()+" "+p.getId()+" "+p.getLocationissued()+" "+p.getAddress().getArea()+" "+p.getAddress().getPincode());
		System.out.println(emp1.getId()+" "+emp1.getName()+" "+emp1.getCity()+" "+emp1.getCompany()+" "+p1.getId()+" "+p1.getLocationissued()+" "+p1.getAddress().getArea()+" "+p1.getAddress().getPincode());
		System.out.println(emp2.getId()+" "+emp2.getName()+" "+emp2.getCity()+" "+emp2.getCompany()+" "+p.getId()+" "+p.getLocationissued()+" "+p.getAddress().getArea()+" "+p.getAddress().getPincode());
		System.out.println(emp3.getId()+" "+emp3.getName()+" "+emp3.getCity()+" "+emp3.getCompany()+" "+p1.getId()+" "+p1.getLocationissued()+" "+p1.getAddress().getArea()+" "+p1.getAddress().getPincode());
		
		return "register";
		
	}
}
