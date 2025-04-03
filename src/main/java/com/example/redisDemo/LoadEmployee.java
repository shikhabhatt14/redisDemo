package com.example.redisDemo;

import com.example.redisDemo.model.Department;
import com.example.redisDemo.model.Employee;
import com.example.redisDemo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadEmployee {

    private static final Logger log = LoggerFactory.getLogger(LoadEmployee.class);

    @Bean
    CommandLineRunner initUserDatabase(EmployeeRepository repository) {
        //CommandLineRunner initDatabase(UserRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Employee("abc", 5, Department.TECHNOLOGY)));
            log.info("Preloading " + repository.save(new Employee("def", 6, Department.FINANCE)));
            log.info("Preloading " + repository.save(new Employee("admin", 10, Department.ADMIN)));
        };
    }

}
