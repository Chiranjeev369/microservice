package com.department.department.controller;

import com.department.department.dto.DepartmentDto;
import com.department.department.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto dto=departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable String departmentCode){
        return ResponseEntity.ok(departmentService.getDepartmentByCode(departmentCode));
    }

    @PutMapping("/{departmentCode}")
    public ResponseEntity<DepartmentDto> updateDepartmentById(@RequestBody DepartmentDto departmentDto,@PathVariable String departmentCode){
        DepartmentDto dto=departmentService.updateDepartmentByCode(departmentDto,departmentCode);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteByDepartment(@PathVariable Long id){
        departmentService.deleteByDepartment(id);
        return ResponseEntity.ok("department with id"+ id +" has been deleted");
    }
    @GetMapping
    public List<DepartmentDto> getAllDepartment(){
        return departmentService.getAllDepartment();
    }
}
