package com.example.demo.service.client;

import com.example.demo.dto.EmployeeResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "employee", url = "${employee.base.url}")
public interface EmployeeClient {

    @RequestMapping(method = RequestMethod.GET, value = "/employees")
    EmployeeResponseDTO getEmployee();
}
