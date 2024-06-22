package springmicroservicesdemo.departmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springmicroservicesdemo.departmentservice.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
