package springmicroservicesdemo.organizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springmicroservicesdemo.organizationservice.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {
}
