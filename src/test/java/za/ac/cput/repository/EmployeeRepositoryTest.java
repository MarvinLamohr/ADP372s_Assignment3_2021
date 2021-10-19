package za.ac.cput.repository;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.repository.employee.impl.EmployeeRepository;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeRepositoryTest {

    private static EmployeeRepository repository = EmployeeRepository.getRepository();

    private static Employee employee = EmployeeFactory.createEmployee( "Martin","Williams","9090909223","0823267956","27 Plum Avenue Cape Town 7954", "martinRoberts@gmail.com", "CEO");

    @Test
    void a_create() {
        Employee created = repository.create(employee);
        assertEquals(created.getEmployeeID(),employee.getEmployeeID());
        System.out.println("Create: "+ created);
    }

    @Test
    void b_read() {
        Employee read = repository.read(employee.getEmployeeID());
        assertNotNull(read);
        System.out.println("Read: "+ read);
    }

    @Test
    void c_update() {
        Employee updated = new Employee.Builder().copy(employee).setEmployeeFirstName("Tony").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: "+ updated);
    }

    @Test
    void e_delete() {
        boolean deleted = repository.delete(employee.getEmployeeID());
        assertNotNull(deleted);
        System.out.println("Delete: "+ deleted);
    }

    @Test
    void d_getAll(){
        System.out.println("Show all data: ");
        System.out.println(repository.getAll());
    }
}