package springmicroservicesdemo.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import springmicroservicesdemo.employeeservice.dto.APIResponseDto;
import springmicroservicesdemo.employeeservice.dto.DepartmentDto;
import springmicroservicesdemo.employeeservice.dto.EmployeeDto;
import springmicroservicesdemo.employeeservice.entity.Employee;
import springmicroservicesdemo.employeeservice.exception.ResourceNotFoundException;
import springmicroservicesdemo.employeeservice.mapper.AutoEmployeeMapper;
import springmicroservicesdemo.employeeservice.repository.EmployeeRepository;
import springmicroservicesdemo.employeeservice.service.EmployeeService;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private RestTemplate restTemplate;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = AutoEmployeeMapper.MAPPER.mapEmployeeDtoToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapEmployeeToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );

        ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8100/api/departments/" + employee.getDepartmentCode(), DepartmentDto.class);
        DepartmentDto departmentDto = responseEntity.getBody();

        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapEmployeeToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDepartment(departmentDto);

        return apiResponseDto;
    }
}
