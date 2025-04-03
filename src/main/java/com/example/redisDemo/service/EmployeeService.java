package com.example.redisDemo.service;

import com.example.redisDemo.model.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> listEmployees();
    public Employee getEmployee(long id);
    public void deleteEmployee(long id);
    public Employee saveEmployee(Employee employee);
}
