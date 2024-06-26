package springmicroservicesdemo.organizationservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springmicroservicesdemo.organizationservice.dto.OrganizationDto;
import springmicroservicesdemo.organizationservice.service.OrganizationService;

@Tag(
        name="Organization Service - OrganizationController",
        description = "Organization Controller Exposes REST APIs for Organization-Service"
)
@RestController
@RequestMapping("api/organizations")
@AllArgsConstructor
public class OrganizationController {
    OrganizationService organizationService;

    @Operation(
            summary = "Save Organization REST API",
            description = "Save Organization REST API is used to save department object in a database"
    )
    @ApiResponse(
            responseCode="201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping
    public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
        OrganizationDto savedOrganizationDto = organizationService.saveOrganization(organizationDto);
        return new ResponseEntity<OrganizationDto>(savedOrganizationDto, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get Organization REST API",
            description = "Get Organization REST API is used to get department object in a database"
    )
    @ApiResponse(
            responseCode="200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("{organizationId}")
    public ResponseEntity<OrganizationDto> getOrganization(@PathVariable Long organizationId) {
        OrganizationDto savedOrganizationDto = organizationService.getOrganization(organizationId);
        return new ResponseEntity<OrganizationDto>(savedOrganizationDto, HttpStatus.OK);
    }
}
