package springmicroservicesdemo.departmentservice.service;

import springmicroservicesdemo.departmentservice.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByDepartmentCode(String code);
}
