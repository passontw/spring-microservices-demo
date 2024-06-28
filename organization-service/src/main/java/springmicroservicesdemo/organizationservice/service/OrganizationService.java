package springmicroservicesdemo.organizationservice.service;

import springmicroservicesdemo.organizationservice.dto.OrganizationDto;

public interface OrganizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);
}
