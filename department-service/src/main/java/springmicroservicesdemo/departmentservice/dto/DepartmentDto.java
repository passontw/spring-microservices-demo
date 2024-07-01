package springmicroservicesdemo.departmentservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        description = "DepartmentDto Model Information"
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {
    private Long id;
    @Schema(
            defaultValue = "test001",
            description = "Department Name"
    )
    private String departmentName;
    @Schema(
            defaultValue = "test001 description",
            description = "Department Description"
    )
    private String departmentDescription;
    @Schema(
            defaultValue = "IT001",
            description = "Department Code"
    )
    private String departmentCode;
}
