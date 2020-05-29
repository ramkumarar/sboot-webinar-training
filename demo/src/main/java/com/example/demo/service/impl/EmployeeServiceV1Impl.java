package com.example.demo.service.impl;

import com.example.demo.dto.Employee;
import com.example.demo.dto.EmployeeResponseDTO;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("employeesv1")
public class EmployeeServiceV1Impl implements EmployeeService {

    @Value("${employee.url}")
    private String employeeUrl;

    private final RestTemplate restTemplate;

    public List<Employee> employees() {
        ResponseEntity<EmployeeResponseDTO> responseEntity = restTemplate.getForEntity(employeeUrl, EmployeeResponseDTO.class);
        return responseEntity.getBody().getData();
    }

}
