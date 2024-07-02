package springmicroservicesdemo.organizationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Schema(
        description = "Organization Model Information"
)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDto {
    @Schema(
            defaultValue = "1",
            description = "Organization Id"
    )
    private Long id;
    @Schema(
            defaultValue = "test001",
            description = "Organization Name"
    )
    private String organizationName;
    @Schema(
            defaultValue = "test001",
            description = "Organization Description"
    )
    private String organizationDescription;
    @Schema(
            defaultValue = "test001",
            description = "Organization Code"
    )
    private String organizationCode;
    @Schema(
            description = "Organization Data Created Local Time"
    )
    private LocalDateTime createdAt;
    @Schema(
            description = "Organization Data Update Local Time"
    )
    private LocalDateTime updatedAt;
}
