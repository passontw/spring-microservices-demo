package springmicroservicesdemo.employeeservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springmicroservicesdemo.employeeservice.dto.DepartmentDto;

@FeignClient(url = "http://localhost:8100", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{departmentCode}")
    public DepartmentDto getDepartment(@PathVariable String departmentCode);
}
