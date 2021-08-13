package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.Entity.Employee;
import za.ac.cput.Factory.EmployeeFactory;
import za.ac.cput.repository.employee.impl.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeRepositoryTest {

    private static EmployeeRepository repository = EmployeeRepository.getRepository();

    private static Employee employee = EmployeeFactory.createEmployee( "Martin");

    @Test
    void create() {
        Employee created = repository.create(employee);
        assertEquals(created.getId(),employee.getId());
        System.out.println("Create: "+ created);
    }

    @Test
    void read() {
        Employee read = repository.read(employee.getId());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void update() {
        Employee updated = new Employee.Builder().copy(employee).setEmployeeName("Tony").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: "+ updated);
    }

    @Test
    void delete() {
        Employee deleted = repository.delete(employee.getId());
        assertNotNull(deleted);
        System.out.println("Delete: "+ deleted);
    }
}