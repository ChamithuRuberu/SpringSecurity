package com.example.demoapp.repository;

import com.example.demoapp.dto.response.ResponseEmployeeDto;
import com.example.demoapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    Employee findOneById(Long id);

}
