package com.egorov.api_admin.controller;

import com.egorov.api_admin.service.EmployeeAdminService;
import com.egorov.dto.EmployeeDto;
import com.egorov.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/admin/employees")
public class EmployeeAdminController {
    private final EmployeeAdminService employeeAdminService;

    /**
     * создать пользователя
     * ``` POST "/users" ```
     */
    @PostMapping()
    public ResponseEntity<EmployeeDto> save(@RequestBody @Valid Employee employee) {
        return ResponseEntity.ok(employeeAdminService.save(employee));
    }
}
