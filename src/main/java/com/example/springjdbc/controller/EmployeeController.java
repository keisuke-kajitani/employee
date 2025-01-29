package com.example.springjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springjdbc.controller.service.EmployeeService;
import com.example.springjdbc.domain.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
@Autowired
private EmployeeService service;

@RequestMapping("/execute")
public String execute(){
 Employee employee = new Employee();
 employee.setName("浦島太郎");
 employee.setAge(20);
 employee.setDepartmentId(1);
 employee.setGender("男");
 service.save(employee);
Employee employee2 = service.load(3);
System.out.println(employee2);
service.deleteById(3);
// service.findAll().forEach(System.out::println);
List<Employee>employeeList = service.findAll();
for(Employee emp:employeeList){
    System.out.println(emp);
}
return "finished";
}
}
