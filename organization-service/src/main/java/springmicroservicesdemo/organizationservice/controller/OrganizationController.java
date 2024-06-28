package springmicroservicesdemo.organizationservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springmicroservicesdemo.organizationservice.dto.OrganizationDto;
import springmicroservicesdemo.organizationservice.service.OrganizationService;

@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
    OrganizationService organizationService;


    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganizationDto = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<OrganizationDto>(savedOrganizationDto, HttpStatus.CREATED);
    }

    @GetMapping("{organizationId}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable Long organizationId) {
        OrganizationDto savedOrganizationDto = organizationService.getOrganization(organizationId);
        return new ResponseEntity<OrganizationDto>(savedOrganizationDto, HttpStatus.OK);
    }
}
