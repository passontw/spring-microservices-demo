package springmicroservicesdemo.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springmicroservicesdemo.employeeservice.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
