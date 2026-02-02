package com.assignment.restApi.mapper;


import com.assignment.restApi.dto.request.EmployeeReqDTO;
import com.assignment.restApi.dto.request.EmployeeUpdateDTO;
import com.assignment.restApi.dto.response.EmployeeDTO;
import com.assignment.restApi.entities.Employee;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityMapper {
    @Autowired
    private ModelMapper modelMapper;

    public EmployeeDTO toEmployeeDTO(Employee employee) {
        return modelMapper.map(employee,EmployeeDTO.class);
    }

    public List<EmployeeDTO> toEmployeeDTOList(List<Employee> employees) {
    return employees.stream().map(this::toEmployeeDTO).collect(Collectors.toList());
    }

    public Employee toEmployee(EmployeeReqDTO dto) {
        return modelMapper.map(dto,Employee.class);
    }

    public Employee toEmployee(EmployeeUpdateDTO dto){
        return modelMapper.map(dto,Employee.class);
    }
}

