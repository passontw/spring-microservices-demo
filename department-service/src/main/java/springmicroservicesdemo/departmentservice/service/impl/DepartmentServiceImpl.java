package springmicroservicesdemo.departmentservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springmicroservicesdemo.departmentservice.dto.DepartmentDto;
import springmicroservicesdemo.departmentservice.entity.Department;
import springmicroservicesdemo.departmentservice.mapper.AutoDepartmentMapper;
import springmicroservicesdemo.departmentservice.repository.DepartmentRepository;
import springmicroservicesdemo.departmentservice.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department = AutoDepartmentMapper.MAPPER.mapDepartmentDtoToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        return AutoDepartmentMapper.MAPPER.mapDepartmentToDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByDepartmentCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return AutoDepartmentMapper.MAPPER.mapDepartmentToDepartmentDto(department);
    }
}
