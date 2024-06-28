package springmicroservicesdemo.departmentservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import springmicroservicesdemo.departmentservice.dto.DepartmentDto;
import springmicroservicesdemo.departmentservice.entity.Department;

@Mapper
public interface AutoDepartmentMapper {
    AutoDepartmentMapper MAPPER = Mappers.getMapper(AutoDepartmentMapper.class);

    DepartmentDto mapDepartmentToDepartmentDto(Department department);
    Department mapDepartmentDtoToDepartment(DepartmentDto departmentDto);
}
