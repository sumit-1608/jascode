package com;

import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.repository.EmployeeRepository;
import com.service.ReportService;

import java.io.FileNotFoundException;
import java.util.List;

import javax.validation.Valid;

@SpringBootApplication
//@RestController
public class DemoApplication {

//    @Autowired
//    private EmployeeRepository repository;
//    @Autowired
//    private ReportService service;
//
//    @GetMapping("/getEmployees")
//    public List<Employee> getEmployees() {
//
//        return repository.findAll();
//    }
//
//    @GetMapping("/report/{format}")
//    public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
//        return service.exportReport(format);
//    }
//    
//    @PostMapping("/addemployee")
//    public Employee addDoctor(@Valid @RequestBody Employee doctor)
//    {
//    	return service.addEmp(doctor);
//    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("connected to database......");
    }

}