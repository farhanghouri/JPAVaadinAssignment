package com.afkghouri.JPAVaadinAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

 

@SpringBootApplication
public class JpaVaadinAssignmentApplication {

	public static void main(String[] args) { 
		   ConfigurableApplicationContext configurableApplicationContext =  SpringApplication.run(JpaVaadinAssignmentApplication.class, args);
	  //     EmployeeController  employeeController = configurableApplicationContext.getBean(EmployeeController.class); 
	    //   employeeController.findAll();
	}
}
