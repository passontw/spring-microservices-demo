package springmicroservicesdemo.employeeservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springmicroservicesdemo.employeeservice.dto.EmployeeDto;
import springmicroservicesdemo.employeeservice.entity.Employee;

@Mapper
public interface AutoEmployeeMapper {
    AutoEmployeeMapper MAPPER = Mappers.getMapper(AutoEmployeeMapper.class);

    EmployeeDto mapEmployeeToEmployeeDto(Employee employee);
    Employee mapEmployeeDtoToEmployee(EmployeeDto employeeDto);
}
