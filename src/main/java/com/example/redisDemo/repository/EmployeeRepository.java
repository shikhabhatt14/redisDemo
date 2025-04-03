package com.example.redisDemo.repository;

import com.example.redisDemo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findAll();

    public Employee findById(long id);

    public Employee save(Employee employee);

    public void deleteById(long id);
}
