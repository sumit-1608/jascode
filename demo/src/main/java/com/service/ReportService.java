package com.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.entity.Employee;
import com.exceptions.EmployeeIdNotFoundException;
import com.repository.EmployeeRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

//import javax.validation.Valid;

@Service
public class ReportService {

    @Autowired
    private EmployeeRepository repository;


 

	public String exportReport(String format) throws FileNotFoundException, JRException {
		String path = "C:\\Users\\SUMDHOLE\\Desktop\\report";
        List<Employee> employees = repository.findAll();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:employees.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "sumeet");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (format.equalsIgnoreCase("html")) {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, path + "\\employees.html");
        }
        if (format.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path + "\\employees.pdf");
        }

        return "report generated in path : " + path;

			}




	public Employee addEmp(Employee doctor) {
		// TODO Auto-generated method stub
		
		return repository.saveAndFlush(doctor);
		
	}
		
	public Employee updateEmployee(Employee doctor) throws EmployeeIdNotFoundException {

		Optional<Employee> result=repository.findById(doctor.getId());
		if(result.isPresent())
		{
			return repository.saveAndFlush(doctor);
		}
		else
		{
			throw new EmployeeIdNotFoundException("please enter valid  id");
		}
	}
	
	
	
	public Employee deleteEmployee(int employeeId) throws EmployeeIdNotFoundException {

		Optional<Employee> result=repository.findById(employeeId);
			if(result.isPresent())
			{
				repository.deleteById(employeeId);
				return result.get();
			}
			else
			{
				throw new EmployeeIdNotFoundException("there is no record found in our database");
			}
}
	
	
	public Employee viewEmployee(int employeeId) throws EmployeeIdNotFoundException {
		java.util.Optional<Employee> result = repository.findById(employeeId); 
		if(result.isPresent()) {
			repository.findById(employeeId);
			return result.get();
		}
		else {
			throw new EmployeeIdNotFoundException("there is no Records found in our database");
		}
	}
}