package com.jasper.service;

import com.jasper.entity.Employee;

import net.sf.jasperreports.engine.JRException;

public interface EmployeeService {

	void addEmployeeInService(Employee emp);

	void reportGeneration(String format) throws JRException;

}
