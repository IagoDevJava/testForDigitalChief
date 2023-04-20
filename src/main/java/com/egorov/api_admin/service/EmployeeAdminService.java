package com.egorov.api_admin.service;

import com.egorov.dto.EmployeeDto;
import com.egorov.model.Employee;

public interface EmployeeAdminService {
    /**
     * создать пользователя
     */
    EmployeeDto save(Employee employee);
}
