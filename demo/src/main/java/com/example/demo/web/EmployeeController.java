package com.example.demo.web;

import com.example.demo.dto.Employee;
import com.example.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor //(onConstructor=@__(@Autowired))
public class EmployeeController {

    @Qualifier("employeesv2")
    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> employees(){
        return  employeeService.employees();
    }
}
