package com.assignment.restApi.controller;

import com.assignment.restApi.dto.request.EmployeeReqDTO;
import com.assignment.restApi.dto.request.EmployeeUpdateDTO;
import com.assignment.restApi.dto.response.EmployeeDTO;
import com.assignment.restApi.services.implementations.EmployeeService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(HttpServletRequest request
//            ,@CookieValue(value = "access_token") String username
    ) {
        System.out.println(request);
        System.out.println(Arrays.toString(request.getCookies()));
        System.out.println(Arrays.stream(request.getCookies()).findAny());
//        System.out.println(username);
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{Id}")
    public EmployeeDTO getEmployeeById(@PathVariable Long Id) {
        return employeeService.getEmployeeById(Id);
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeReqDTO dto) {
        return employeeService.createEmployee(dto);
    }

    @PutMapping("/{Id}")
    public EmployeeDTO updateEmployee(@PathVariable Long Id, @RequestBody EmployeeReqDTO dto) {
        return employeeService.updateEmployee(Id, dto);
    }

    @PatchMapping("/{Id}")
    public EmployeeDTO partialUpdateEmployee(@PathVariable Long Id, @RequestBody EmployeeReqDTO dto) {

        // ??? todo
        return employeeService.updateEmployee(Id, dto);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long Id) {

        employeeService.deleteEmployee(Id);
        return ResponseEntity.ok().build();
    }

}
