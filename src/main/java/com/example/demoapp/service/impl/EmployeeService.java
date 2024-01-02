package com.example.demoapp.service.impl;
import com.example.demoapp.dto.request.RequestEmployeeDto;
import com.example.demoapp.dto.request.RequestUpdateEmployeeDto;
import com.example.demoapp.dto.response.ResponseEmployeeDto;
import com.example.demoapp.entity.Employee;
import com.example.demoapp.repository.EmployeeRepository;
import com.example.demoapp.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public void addEmployee(RequestEmployeeDto requestEmployeeDto) {
        Employee employee = Employee.builder()
                .fullName(requestEmployeeDto.getFullName())
                .birthOfDate(requestEmployeeDto.getBirthOfDate())
                .phone(requestEmployeeDto.getPhone())
                .nic(requestEmployeeDto.getNic())
                .build();

        employeeRepository.save(employee);
    }


    public ResponseEntity<StandardResponse> updateEmployee(RequestUpdateEmployeeDto requestUpdateEmployeeDto) {

        Optional<Employee> existingEmployee = employeeRepository.findById(requestUpdateEmployeeDto.getId());

        if (existingEmployee.isEmpty()) {
            return new ResponseEntity<>(
                    new StandardResponse(201,"emp-not-found", requestUpdateEmployeeDto.getFullName()),
                    HttpStatus.CREATED
            );
        }else {
            Employee employee = Employee.builder()
                    .fullName(requestUpdateEmployeeDto.getFullName())
                    .birthOfDate(requestUpdateEmployeeDto.getBirthOfDate())
                    .phone(requestUpdateEmployeeDto.getPhone())
                    .nic(requestUpdateEmployeeDto.getNic())
                    .build();
            employeeRepository.save(employee);

        }
        return new ResponseEntity<>(
                new StandardResponse(201,"emp-updated", requestUpdateEmployeeDto.getFullName()),
                HttpStatus.CREATED
        );
    }


    public List<ResponseEmployeeDto> getAllEmployees() {

        List<Employee> employeeList = employeeRepository.findAll();
        List<ResponseEmployeeDto> responseEmployeeDtos = new ArrayList<>();

        for(Employee employee: employeeList) {
            ResponseEmployeeDto responseEmployeeDto = new ResponseEmployeeDto();
            responseEmployeeDto.setNic(employee.getNic());
            responseEmployeeDto.setId(employee.getId());
            responseEmployeeDto.setFullName(employee.getFullName());
            responseEmployeeDto.setBirthOfDate(employee.getBirthOfDate());
            responseEmployeeDto.setPhone(employee.getPhone());
            responseEmployeeDtos.add(responseEmployeeDto);
        }
        return responseEmployeeDtos;
    }

    public ResponseEntity<StandardResponse>getEmployeeById(String id) {
        Employee employee = employeeRepository.findOneById(Long.parseLong(id));

        if (employee == null) {
            return new ResponseEntity<>(
                    new StandardResponse(201,"emp-not-found", ""),
                    HttpStatus.CREATED
            );

        }else {
            Map<String, Object> response = new HashMap<>();
            response.put("employee_details", employee);
            return new ResponseEntity<>(
                    new StandardResponse(201,"emp-Get", response),
                    HttpStatus.CREATED
            );

        }

    }
}
