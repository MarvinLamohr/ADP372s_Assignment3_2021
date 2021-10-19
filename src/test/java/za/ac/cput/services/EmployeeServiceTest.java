package za.ac.cput.services;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.services.employee.EmployeeService;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceTest {

    private static EmployeeService service = EmployeeService.getService();
    private static Employee employee = EmployeeFactory.createEmployee("Cyril","Ramaphosa","Pres2017SA","0214278359","90 Plein Street Cape Town 8000","CyrilRamaphosaSA@outlook.com","President");

    @Test
    void a_create() {
        Employee created = service.create(employee);
        assertEquals(created.getEmployeeID(),employee.getEmployeeID());
        System.out.println("Created: " +created);
    }

    @Test
    void b_read() {
        Employee read = service.read(employee.getEmployeeID());
        assertNotNull(read);
        System.out.println("Read: " +read);
    }

    @Test
    void c_update() {
        Employee updated = new Employee.Builder().copy(employee).setEmployeeFirstName("Robert").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " +updated);
    }

    @Test
    void e_delete() {
        boolean success = service.delete(employee.getEmployeeID());
        assertTrue(success);
        System.out.println("Deleted: " +success);
    }

    @Test
    void d_getAll(){
        System.out.println("Show all data: ");
        System.out.println(service.getAll());
    }
}