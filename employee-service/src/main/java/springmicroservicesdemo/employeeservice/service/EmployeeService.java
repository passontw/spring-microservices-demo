package springmicroservicesdemo.employeeservice.service;

import springmicroservicesdemo.employeeservice.dto.APIResponseDto;
import springmicroservicesdemo.employeeservice.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long employeeId);
}
