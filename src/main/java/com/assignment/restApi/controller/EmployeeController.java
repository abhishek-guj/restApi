package com.assignment.restApi.controller;

import com.assignment.restApi.dto.request.EmployeeReqDTO;
import com.assignment.restApi.dto.request.EmployeeUpdateDTO;
import com.assignment.restApi.dto.response.EmployeeDTO;
import com.assignment.restApi.entities.Employee;
import com.assignment.restApi.services.implementations.EmployeeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    @Tag(name="get all employees v1")
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
    @Tag(name="get employee by id")
    @Tag(name="employee CRUD")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long Id) {
        EmployeeDTO emp = employeeService.getEmployeeById(Id);
        return ResponseEntity.ok(emp);
    }

    @PostMapping
    @Tag(name="create new employee")
    @Tag(name="employee CRUD")
    public ResponseEntity<EmployeeDTO> createEmployee(@Valid @RequestBody EmployeeReqDTO dto) {
        EmployeeDTO emp = employeeService.createEmployee(dto);
        return ResponseEntity.ok(emp);

    }

    @PutMapping("/{Id}")
    @Tag(name="employee CRUD")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long Id, @Valid @RequestBody EmployeeReqDTO dto) {
        EmployeeDTO emp = employeeService.updateEmployee(Id, dto);
        return ResponseEntity.ok(emp);

    }

    @PatchMapping("/{Id}")
    @Tag(name="employee CRUD")
    public ResponseEntity<EmployeeDTO> partialUpdateEmployee(@PathVariable Long Id, @Validated(Employee.Update.class) @RequestBody EmployeeReqDTO dto) {

        // ??? todo
        EmployeeDTO emp = employeeService.updateEmployee(Id, dto);
        return ResponseEntity.ok(emp);
    }

    @DeleteMapping("/{Id}")
    @Tag(name="employee CRUD")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long Id) {

        employeeService.deleteEmployee(Id);
        return ResponseEntity.ok().build();
    }

    @GetMapping(headers = "X-API-VERSION=1")
    @Tag(name="employee CRUD")
    @Tag(name="versioning by header")
    public ResponseEntity<String> getVersionHeader(){
        return ResponseEntity.ok("api-version-headers:1");
    }
    @GetMapping(params = "version=2")
    @Tag(name="employee CRUD")
    @Tag(name="versioning by query params")
    public ResponseEntity<String> getVersionParam(){
        return ResponseEntity.ok("api-version-params:2");
    }
    @GetMapping( produces = "application/org.roima.app-v1+json")
    @Tag(name="employee CRUD")
    @Tag(name="versioning by content negotiation")
    public ResponseEntity<String> getVersionContentNegotiation(){
        return ResponseEntity.ok("api-version-ContentNegotiation:2");
    }

}
