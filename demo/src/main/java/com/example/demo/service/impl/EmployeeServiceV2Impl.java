package com.example.demo.service.impl;

import com.example.demo.dto.Employee;
import com.example.demo.dto.EmployeeResponseDTO;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.client.EmployeeClient;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("employeesv2")
public class EmployeeServiceV2Impl implements EmployeeService {

    private final EmployeeClient employeeClient;

    public List<Employee> employees() {
        EmployeeResponseDTO  employeeResponseDTO = employeeClient.getEmployee();
        return employeeResponseDTO.getData();
    }

}
