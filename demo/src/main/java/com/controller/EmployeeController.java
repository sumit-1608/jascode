package com.controller;

import java.io.FileNotFoundException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.exceptions.EmployeeIdNotFoundException;
import com.repository.EmployeeRepository;
import com.service.ReportService;

import net.sf.jasperreports.engine.JRException;
@RestController
public class EmployeeController {
	
    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private ReportService service;

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {

        return repository.findAll();
    }

    @GetMapping("/report/{format}")
    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
        return service.exportReport(format);
    }
    
    @PostMapping("/addemployee")
    public Employee addDoctor(@Valid @RequestBody Employee doctor)
    {
    	return service.addEmp(doctor);
    }
    
    @PutMapping("/updateemployee")
	public Employee updateEmployee(@RequestBody Employee doctor) throws EmployeeIdNotFoundException
	{
		return service.updateEmployee(doctor);
	}
    
    
    @DeleteMapping("/deleteemployee/{id}")
	public Employee deleteEmployee(@PathVariable int id) throws EmployeeIdNotFoundException
	{
		return service.deleteEmployee(id);
	}
	
    @GetMapping("/viewemployee/{id}")
	public Employee viewDoctor(@PathVariable int id) throws EmployeeIdNotFoundException
	{
		return service.viewEmployee(id);
	}


}
