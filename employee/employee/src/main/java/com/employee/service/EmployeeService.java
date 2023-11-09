package com.employee.service;

import com.employee.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);
    EmployeeDto getEmployeeById(Long id);
    EmployeeDto updateEmployeeById(EmployeeDto employeeDto,Long id);
    void deleteEmployeeById(Long id);
    List<EmployeeDto> getAllEmployee();
}
