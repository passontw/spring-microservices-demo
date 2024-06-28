package springmicroservicesdemo.organizationservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springmicroservicesdemo.organizationservice.dto.OrganizationDto;
import springmicroservicesdemo.organizationservice.service.OrganizationService;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
    OrganizationService organizationService;


    @PostMapping
    public ResponseEntity<OrganizationDto> saveEmployee(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganizationDto = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<OrganizationDto>(savedOrganizationDto, HttpStatus.CREATED);
    }
}
