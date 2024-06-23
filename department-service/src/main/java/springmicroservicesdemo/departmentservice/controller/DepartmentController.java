package springmicroservicesdemo.departmentservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springmicroservicesdemo.departmentservice.dto.DepartmentDto;
import springmicroservicesdemo.departmentservice.service.DepartmentService;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {
    private DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto savedDepartmentDto = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<DepartmentDto>(savedDepartmentDto, HttpStatus.CREATED);
    }

    @GetMapping("{departmentCode}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable String departmentCode) {
        DepartmentDto departmentDto = departmentService.getDepartmentByDepartmentCode(departmentCode);
        return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);
    }
}
