package com.department.department.service.impl;

import com.department.department.dto.DepartmentDto;
import com.department.department.entity.Department;
import com.department.department.repository.DepartmentRepository;
import com.department.department.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department=mapToEntity(departmentDto);
        Department newDepartment=departmentRepository.save(department);
        return mapToDto(newDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
        Department department=departmentRepository.findByDepartmentCode(departmentCode);
        return mapToDto(department);
    }

    @Override
    public DepartmentDto updateDepartmentByCode(DepartmentDto departmentDto, String departmentCode) {
        Department department=departmentRepository.findByDepartmentCode(departmentCode);
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentCode(departmentDto.getDepartmentCode());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        Department newDepartment=departmentRepository.save(department);
        return mapToDto(newDepartment);
    }

    @Override
    public void deleteByDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<DepartmentDto> getAllDepartment() {
        List <Department> departments=departmentRepository.findAll();
        return departments.stream().map(department -> mapToDto(department)).collect(Collectors.toList());
    }

    Department mapToEntity(DepartmentDto departmentDto){
        Department department=new Department();
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentCode(departmentDto.getDepartmentCode());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        return department;
    }
    DepartmentDto mapToDto(Department department){
        DepartmentDto dto=new DepartmentDto();
        dto.setId(department.getId());
        dto.setDepartmentName(department.getDepartmentName());
        dto.setDepartmentCode(department.getDepartmentCode());
        dto.setDepartmentDescription(department.getDepartmentDescription());
        return dto;
    }
}
