package springmicroservicesdemo.employeeservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springmicroservicesdemo.employeeservice.dto.EmployeeDto;
import springmicroservicesdemo.employeeservice.entity.Employee;
import springmicroservicesdemo.employeeservice.exception.ResourceNotFoundException;
import springmicroservicesdemo.employeeservice.mapper.AutoEmployeeMapper;
import springmicroservicesdemo.employeeservice.repository.EmployeeRepository;
import springmicroservicesdemo.employeeservice.service.EmployeeService;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = AutoEmployeeMapper.MAPPER.mapEmployeeDtoToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
        EmployeeDto savedEmployeeDto = AutoEmployeeMapper.MAPPER.mapEmployeeToEmployeeDto(savedEmployee);
        return savedEmployeeDto;
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );
        EmployeeDto employeeDto = AutoEmployeeMapper.MAPPER.mapEmployeeToEmployeeDto(employee);
        return employeeDto;
    }
}
