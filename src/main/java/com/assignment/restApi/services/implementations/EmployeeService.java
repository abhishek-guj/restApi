package com.assignment.restApi.services.implementations;

import com.assignment.restApi.dto.request.EmployeeReqDTO;
import com.assignment.restApi.dto.response.EmployeeDTO;
import com.assignment.restApi.entities.Employee;
import com.assignment.restApi.exceptions.EmployeeNotFoundException;
import com.assignment.restApi.mapper.EntityMapper;
import com.assignment.restApi.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    private final EntityMapper entityMapper;
    private final EmployeeRepository employeeRepository;

    @Autowired
    EmployeeService(EntityMapper entityMapper, EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.entityMapper = entityMapper;
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return entityMapper.toEmployeeDTOList(employees);
    }

    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException());
        return entityMapper.toEmployeeDTO(employee);
    }

    public EmployeeDTO createEmployee(EmployeeReqDTO dto) {
        Employee employee = entityMapper.toEmployee(dto);
        employeeRepository.save(employee);
        return entityMapper.toEmployeeDTO(employee);
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeReqDTO dto) {
        
        Employee exists = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException());

        Employee employee = entityMapper.toEmployee(dto);
        employee.setId(exists.getId());

        employeeRepository.save(employee);
        return entityMapper.toEmployeeDTO(employee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException());
        employeeRepository.delete(employee);
    }
}
