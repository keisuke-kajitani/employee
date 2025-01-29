package com.example.springjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.springjdbc.controller.service.DepartmentService;
import com.example.springjdbc.domain.Department;

@Controller
@RequestMapping("/department")
public class DpartmentController {
@Autowired
private DepartmentService service;

@RequestMapping("/execute")
public String execute(){
 Department department = new Department();
 department.setName("生産部");
 service.save(department);
Department employee2 = service.load(3);
System.out.println(employee2);
service.deleteById(3);
// service.findAll().forEach(System.out::println);
List<Department>departmentList = service.findAll();
for(Department emp:departmentList){
    System.out.println(emp);
}
return "finished";
}
}
