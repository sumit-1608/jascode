package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;

@Entity

public class Employee 
{
	
	//@Data //its @Data is a convenient shortcut annotation that bundles the features of @ToString , @EqualsAndHashCode , @Getter / @Setter and @RequiredArgsConstructor together: In other words, @Data generates all the boilerplate
			//that is normally associated with simple POJOs (Plain Old Java Objects) and beans: getters for all fields, ..
	//@AllArgsConstructor
	//@NoArgsConstructor
	//@ToString

		@Id
		@GeneratedValue
	    private int id;
		 @NotBlank(message = "Name Field is mandatory")
		 @Size(min=4 ,message="Please Enter Name with First Name and Last Name of Employee ")
	    private String name;
		 @NotBlank(message = "designation Field is mandatory")
	    private String designation;
		
	    private double salary;
	    @NotBlank(message = "Date of joining Field is mandatory to our database")
	    private String doj;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDesignation() {
			return designation;
		}
		public void setDesignation(String designation) {
			this.designation = designation;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public String getDoj() {
			return doj;
		}
		public void setDoj(String doj) {
			this.doj = doj;
		}
		@Override
		public String toString() {
			return "Employee [id=" + id + ", name=" + name + ", designation=" + designation + ", salary=" + salary
					+ ", doj=" + doj + "]";
		}
	    
	    
	    
	}

