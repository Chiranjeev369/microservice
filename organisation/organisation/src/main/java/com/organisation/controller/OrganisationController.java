package com.organisation.controller;

import com.organisation.dto.OrganisationDto;
import com.organisation.service.OrganisationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organisation")
public class OrganisationController {
    private OrganisationService organisationService;

    public OrganisationController(OrganisationService organisationService) {
        this.organisationService = organisationService;
    }

    @PostMapping
    public ResponseEntity<OrganisationDto> createOrganisation(@RequestBody OrganisationDto organisationDto){
        OrganisationDto dto=organisationService.createOrganisation(organisationDto);
        System.out.println(dto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @GetMapping("/{organisationCode}")
    public ResponseEntity<OrganisationDto> getOrganisationByCode(@PathVariable String organisationCode){
        OrganisationDto dto=organisationService.getOrganisationById(organisationCode);
        return ResponseEntity.ok(dto);
    }
    @PutMapping("/{organisationCode}")
    public ResponseEntity<OrganisationDto> updateOrganisation(@RequestBody OrganisationDto organisationDto,@PathVariable String organisationCode){
        OrganisationDto dto=organisationService.updateOrganisationByCode(organisationDto,organisationCode);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrganisation(@PathVariable Long id){
        organisationService.deleteOrganisationById(id);
        return ResponseEntity.ok("Organisation with id "+id+" has been deleted");
    }
    @GetMapping
    public List<OrganisationDto> getAll(){
        return organisationService.getAllOrganisation();
    }
}
