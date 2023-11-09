package com.employee.service.impl;

import com.employee.dto.EmployeeDto;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
        Employee employee=mapToEntity(employeeDto);
        Employee newEmployee=employeeRepository.save(employee);
        return mapToDto(newEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee=employeeRepository.findById(id).get();
        return mapToDto(employee);
    }

    @Override
    public EmployeeDto updateEmployeeById(EmployeeDto employeeDto, Long id) {
        Employee employee=employeeRepository.findById(id).get();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        Employee newEmployee=employeeRepository.save(employee);
        return mapToDto(newEmployee);

    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDto> getAllEmployee() {
        List<Employee> employee=employeeRepository.findAll();
        return employee.stream().map(employee1 -> mapToDto(employee1)).collect(Collectors.toList());
    }

    EmployeeDto mapToDto(Employee employee){
        EmployeeDto dto=new EmployeeDto();
        dto.setId(employee.getId());
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmail(employee.getEmail());
        return dto;
    }
    Employee mapToEntity(EmployeeDto employeeDto){
        Employee employee=new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        employee.setEmail(employeeDto.getEmail());
        return employee;
    }

}
