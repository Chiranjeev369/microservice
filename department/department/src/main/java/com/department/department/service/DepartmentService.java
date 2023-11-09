package com.department.department.service;

import com.department.department.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {
    DepartmentDto createDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String departmentCode);
    DepartmentDto updateDepartmentByCode(DepartmentDto departmentDto,String departmentCode );
    void deleteByDepartment(Long id );
    List<DepartmentDto> getAllDepartment();
}
