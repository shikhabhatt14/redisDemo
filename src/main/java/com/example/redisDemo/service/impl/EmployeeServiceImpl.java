package com.example.redisDemo.service.impl;

import com.example.redisDemo.controller.EmployeeController;
import com.example.redisDemo.model.Employee;
import com.example.redisDemo.repository.EmployeeRepository;
import com.example.redisDemo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    EmployeeRepository repository;

    @Override
    public List<Employee> listEmployees() {
        LOG.info("inside EmployeeServiceImpl - listEmployees");
        return repository.findAll();
    }

    @Override
    @Cacheable(value = "employeeCache", key = "#id")
    public Employee getEmployee(long id) {
        LOG.info("inside EmployeeServiceImpl - getEmployee");
        return repository.findById(id); //.orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    @CacheEvict(value = "employeeCache", key = "#id")
    public void deleteEmployee(long id) {
        repository.deleteById(id);
    }

    @Override
    @CachePut(value = "employeeCache", key = "#employee.id")
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }
}
