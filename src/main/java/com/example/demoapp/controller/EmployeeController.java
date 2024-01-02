package com.example.demoapp.controller;
import com.example.demoapp.dto.request.RequestEmployeeDto;
import com.example.demoapp.dto.request.RequestEmployeeGetById;
import com.example.demoapp.dto.request.RequestUpdateEmployeeDto;
import com.example.demoapp.dto.response.ResponseEmployeeDto;
import com.example.demoapp.service.impl.EmployeeService;
import com.example.demoapp.util.StandardResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("api/v1/emp")
public class EmployeeController {
    private final EmployeeService empService;

    public EmployeeController(EmployeeService empService) {
        this.empService = empService;
    }

    @PostMapping("/save-emp")
    public ResponseEntity<StandardResponse> saveEmployee(@RequestBody @Valid RequestEmployeeDto requestEmployeeDto) {
        empService.addEmployee(requestEmployeeDto);
        return new ResponseEntity<>(
                new StandardResponse(201,"emp-saved", requestEmployeeDto.getFullName()),
                HttpStatus.CREATED
        );
    }

    @PostMapping("/updateEmployee")
    public ResponseEntity<StandardResponse> updateEmployee(@Valid @RequestBody RequestUpdateEmployeeDto requestUpdateEmployeeDto) {
        return empService.updateEmployee(requestUpdateEmployeeDto);
    }

    @GetMapping("/get-all")
    public ResponseEntity<StandardResponse>getAll() {
        List<ResponseEmployeeDto> employees = empService.getAllEmployees();
        return new ResponseEntity<>(
                new StandardResponse(200, "success", employees),
                HttpStatus.OK
        );
    }

    @PostMapping("/get-by-id")
    public ResponseEntity<StandardResponse>getById(@RequestBody RequestEmployeeGetById requestEmployeeGetById) {
        return empService.getEmployeeById(requestEmployeeGetById.getId());

    }
}
