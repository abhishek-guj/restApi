package com.assignment.restApi.dto.request;

import com.assignment.restApi.entities.Employee;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeReqDTO {
    @NotBlank(groups = {Employee.Update.class}, message = "fname is required")
    private String employeeFName;
    @NotBlank(message = "lname is required")
    private String employeeLName;

    @NotBlank(message = "department is required")
    private String department;
}
