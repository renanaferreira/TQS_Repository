package tqsdemo.employeemngr.employee;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import tqsdemo.employeemngr.data.Employee;
import tqsdemo.employeemngr.data.EmployeeRepository;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContainerTest {

    @Autowired
    private EmployeeRepository repository;

    @Container
    public static PostgreSQLContainer container = new PostgreSQLContainer()
            .withUsername("postgres")
            .withPassword("postgres")
            .withDatabaseName("employees");

    @DynamicPropertySource
    static void properties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",container::getJdbcUrl);
        registry.add("spring.datasource.username",container::getUsername);
        registry.add("spring.datasource.password",container::getPassword);
    }

    @Test
    @Order(1)
    public void saveEmployee() {
        Employee alex = new Employee("Alex", "alex@deti.com");
        repository.save(alex);

        Employee found = repository.findByName(alex.getName());
        assertThat(found).isEqualTo(alex);
    }

}
