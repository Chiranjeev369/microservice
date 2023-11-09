package com.organisation.service;

import com.organisation.dto.OrganisationDto;

import java.util.List;

public interface OrganisationService {
    OrganisationDto createOrganisation(OrganisationDto organisationDto);
    OrganisationDto getOrganisationById(String organisationCode);
    OrganisationDto updateOrganisationByCode(OrganisationDto organisationDto,String organisationCode);
    void deleteOrganisationById(Long id);
    List<OrganisationDto> getAllOrganisation();
}
