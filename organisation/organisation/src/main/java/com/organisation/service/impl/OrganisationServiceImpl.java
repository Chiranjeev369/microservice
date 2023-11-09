package com.organisation.service.impl;

import com.organisation.dto.OrganisationDto;
import com.organisation.entity.Organisation;
import com.organisation.repository.OrganisationRepository;
import com.organisation.service.OrganisationService;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrganisationServiceImpl implements OrganisationService {
    private OrganisationRepository organisationRepository;

    public OrganisationServiceImpl(OrganisationRepository organisationRepository) {
        this.organisationRepository = organisationRepository;
    }

    @Override
    public OrganisationDto createOrganisation(OrganisationDto organisationDto) {
        Organisation organisation=mapToEntity(organisationDto);
        System.out.println(organisation);
        Organisation newOrganisation=organisationRepository.save(organisation);
        System.out.println(newOrganisation);
        return mapToDto(newOrganisation);
    }

    @Override
    public OrganisationDto getOrganisationById(String organisationCode) {
        Organisation organisation=organisationRepository.findByOrganisationCode(organisationCode);
        return mapToDto(organisation);
    }

    @Override
    public OrganisationDto updateOrganisationByCode(OrganisationDto organisationDto, String organisationCode) {
        Organisation organisation=organisationRepository.findByOrganisationCode(organisationCode);
        organisation.setOrganisationName(organisationDto.getOrganisationName());
        organisation.setOrganisationCode(organisationDto.getOrganisationCode());
        organisation.setOrganisationDescription(organisationDto.getOrganisationDescription());
        Organisation newOrganisation=organisationRepository.save(organisation);
        return mapToDto(newOrganisation);
    }

    @Override
    public void deleteOrganisationById(Long id) {
        organisationRepository.deleteById(id);
    }

    @Override
    public List<OrganisationDto> getAllOrganisation() {
        List<Organisation> organisations=organisationRepository.findAll();
        return organisations.stream().map(organisation -> mapToDto(organisation)).collect(Collectors.toList());
    }

    OrganisationDto mapToDto(Organisation organisation){
        OrganisationDto organisationDto=new OrganisationDto();
        organisationDto.setId(organisation.getId());
        organisationDto.setOrganisationName(organisation.getOrganisationName());
        organisationDto.setOrganisationCode(organisation.getOrganisationCode());
        organisationDto.setOrganisationDescription(organisation.getOrganisationDescription());
        return organisationDto;
    }

    Organisation mapToEntity(OrganisationDto dto){
        Organisation organisation=new Organisation();
        organisation.setOrganisationName(dto.getOrganisationName());
        organisation.setOrganisationCode(dto.getOrganisationCode());
        organisation.setOrganisationDescription(dto.getOrganisationDescription());
        return organisation;
    }
}
