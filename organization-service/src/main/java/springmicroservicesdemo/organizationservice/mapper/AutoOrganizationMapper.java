package springmicroservicesdemo.organizationservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springmicroservicesdemo.organizationservice.dto.OrganizationDto;
import springmicroservicesdemo.organizationservice.entity.Organization;

@Mapper
public interface AutoOrganizationMapper {
    AutoOrganizationMapper MAPPER = Mappers.getMapper(AutoOrganizationMapper.class);

    OrganizationDto mapEmployeeToEmployeeDto(Organization employee);
    Organization mapEmployeeDtoToEmployee(OrganizationDto employeeDto);
}
