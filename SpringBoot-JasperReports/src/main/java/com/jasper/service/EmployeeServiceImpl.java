package com.jasper.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.jasper.entity.Employee;
import com.jasper.repository.EmployeeRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

	@Autowired
	private EmployeeRepository er;
	
	@Override
	public void addEmployeeInService(Employee emp) 
	{
		er.save(emp);
	}

	@Override
	public void reportGeneration(String format) throws JRException 
	{
		List<Employee> employees = er.findAll();
		
		try {
			
			//1. Load File
			File file = ResourceUtils.getFile("classpath:EmployeeDetails.jrxml");
			
			//2. compile report
			JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
			
			//3. datasource creation
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
			
			//Parameter setting
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("created by", "Nihaab");
			
			//4. filling data inside report
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters,dataSource);
			
			//5. checking format of report
			if(format.equalsIgnoreCase("html"))
			{
				JasperExportManager.exportReportToHtmlFile(jasperPrint,"C:\\JasperReports\\employees.html");
			}
			else if(format.equalsIgnoreCase("pdf"))
			{
				JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\JasperReports\\employees.pdf");
			}
			else if(format.equalsIgnoreCase("csv"))
			{
				JRCsvExporter csvFile = new JRCsvExporter();
				
				csvFile.setExporterInput(new SimpleExporterInput(jasperPrint));
				
				csvFile.setExporterOutput(new SimpleWriterExporterOutput("C:\\JasperReports\\employees.csv"));
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
