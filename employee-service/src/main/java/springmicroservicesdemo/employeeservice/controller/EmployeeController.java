package springmicroservicesdemo.employeeservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springmicroservicesdemo.employeeservice.dto.APIResponseDto;
import springmicroservicesdemo.employeeservice.dto.EmployeeDto;
import springmicroservicesdemo.employeeservice.service.EmployeeService;

@CrossOrigin
@RestController
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto savedEmployeeDto = employeeService.saveEmployee(employeeDto);
        return new ResponseEntity<EmployeeDto>(savedEmployeeDto, HttpStatus.CREATED);
    }

    @GetMapping("{employeeId}")
    public ResponseEntity<APIResponseDto> getEmployee(@PathVariable Long employeeId) {
        APIResponseDto apiResponseDto  = employeeService.getEmployeeById(employeeId);
        return new ResponseEntity<APIResponseDto>(apiResponseDto, HttpStatus.OK);
    }
}
