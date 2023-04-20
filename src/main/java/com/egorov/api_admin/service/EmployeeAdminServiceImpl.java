package com.egorov.api_admin.service;

import com.egorov.dto.EmployeeDto;
import com.egorov.exception.BadRequestException;
import com.egorov.model.Employee;
import com.egorov.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.egorov.mapper.EmployeeMapper.toEmployeeDto;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class EmployeeAdminServiceImpl implements EmployeeAdminService {
    private final EmployeeRepository employeeRepository;

    /**
     * создать пользователя
     */
    @Transactional
    @Override
    public EmployeeDto save(Employee employee) {
        if (employee.getName() == null) {
            throw new BadRequestException("Name must not be blank.");
        }
        return toEmployeeDto(employeeRepository.save(employee));
    }
}
