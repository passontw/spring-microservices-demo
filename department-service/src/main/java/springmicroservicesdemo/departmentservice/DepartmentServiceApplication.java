package springmicroservicesdemo.departmentservice;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info=@Info(
                title = "Department Service REST APIs",
                description = "Department Service REST APIs Documentation",
                version = "V1.0.0",
                contact = @Contact(
                        name="Tomas",
                        email="passon.com.tw@gmail.com",
                        url="https://www.javaguides.net"
                ),
                license = @License(
                        name="Apache 2.0",
                        url="https://www.javaguides.net"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "Department-Service Doc",
                url = "https://www.javaguides.net"
        ),
        servers = @Server(url = "http://localhost:8100")
)
@SpringBootApplication
public class DepartmentServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DepartmentServiceApplication.class, args);
    }

}
