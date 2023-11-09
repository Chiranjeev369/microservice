package com.organisation.dto;

import lombok.Data;

@Data
public class OrganisationDto {
    private Long id;
    private String organisationName;
    private String organisationCode;
    private String organisationDescription;
}
