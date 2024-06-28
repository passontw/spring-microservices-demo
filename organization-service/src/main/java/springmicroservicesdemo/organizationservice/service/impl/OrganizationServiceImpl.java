package springmicroservicesdemo.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springmicroservicesdemo.organizationservice.dto.OrganizationDto;
import springmicroservicesdemo.organizationservice.exception.ResourceNotFoundException;
import springmicroservicesdemo.organizationservice.entity.Organization;
import springmicroservicesdemo.organizationservice.mapper.AutoOrganizationMapper;
import springmicroservicesdemo.organizationservice.repository.OrganizationRepository;
import springmicroservicesdemo.organizationservice.service.OrganizationService;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {

        Organization organization = AutoOrganizationMapper.MAPPER.mapEmployeeDtoToEmployee(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        OrganizationDto savedOrganizationDto = AutoOrganizationMapper.MAPPER.mapEmployeeToEmployeeDto(savedOrganization);
        return savedOrganizationDto;
    }

    @Override
    public OrganizationDto getOrganization(Long organizationId) {
        Organization organization = organizationRepository.findById(organizationId).orElseThrow(
                () -> new ResourceNotFoundException("Organization", "id", organizationId)
        );
        OrganizationDto organizationDto = AutoOrganizationMapper.MAPPER.mapEmployeeToEmployeeDto(organization);
        return organizationDto;
    }
}
