package com.jasper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jasper.entity.Employee;
import com.jasper.service.EmployeeService;

import net.sf.jasperreports.engine.JRException;

@RestController
public class EmployeeController 
{
	@Autowired
	private EmployeeService es;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<?> addEmployee(@RequestBody Employee emp)
	{
		System.out.println(emp);
		
		es.addEmployeeInService(emp);
		
		return ResponseEntity.ok("success......");
		
		
	}
	
	@GetMapping("/report/{format}")
	public ResponseEntity<?> addEmployee(@PathVariable String format) throws JRException
	{
		es.reportGeneration(format);
		
		return ResponseEntity.ok("Report Generated.....");
		
		
	}
}
