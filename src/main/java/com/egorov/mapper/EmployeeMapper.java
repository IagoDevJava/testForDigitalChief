package com.egorov.mapper;

import com.egorov.dto.EmployeeDto;
import com.egorov.model.Employee;

public class EmployeeMapper {
    /**
     * Employee to EmployeeDto
     */
    public static EmployeeDto toEmployeeDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .build();
    }
}
