package com.example.redisDemo.controller;

import com.example.redisDemo.model.Employee;
import com.example.redisDemo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService service;

    Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/employees")
    public List<Employee> listEmployees(){
        LOG.info("inside EmployeeController - listEmployees");
        return service.listEmployees();
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable long id){
        LOG.info("inside EmployeeController - getEmployee");
        return service.getEmployee(id);
    }
}
