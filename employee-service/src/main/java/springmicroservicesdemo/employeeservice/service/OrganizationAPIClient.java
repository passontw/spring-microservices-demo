package springmicroservicesdemo.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springmicroservicesdemo.employeeservice.dto.OrganizationDto;

@FeignClient(name = "ORGANIZATION-SERVICE")
public interface OrganizationAPIClient {
    @GetMapping("api/organizations/{organizationId}")
    public OrganizationDto getOrganization(@PathVariable String organizationId);
}
