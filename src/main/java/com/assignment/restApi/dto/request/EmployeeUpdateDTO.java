package com.assignment.restApi.dto.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeUpdateDTO {
    private Long id;
    private String employeeFName;
    private String employeeLName;
    private String department;

}
