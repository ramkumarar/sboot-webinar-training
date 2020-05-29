
package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status",
    "data"
})
@Data
public class EmployeeResponseDTO {

    @JsonProperty("status")
    private String status;
    @JsonProperty("data")
    private List<Employee> data = null;
}
