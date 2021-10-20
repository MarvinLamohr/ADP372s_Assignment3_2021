package za.ac.cput.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.services.employee.EmployeeService;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private static EmployeeService employeeService;
    private static Employee employee = EmployeeFactory.createEmployee("Cyril","Ramaphosa","Pres2017SA","0214278359","90 Plein Street Cape Town 8000","CyrilRamaphosaSA@outlook.com","President");

    @Test
    void a_create() {
        Employee created = employeeService.create(employee);
        assertEquals(created.getEmployeeID(),employee.getEmployeeID());
        System.out.println("Created: " +created);
    }

    @Test
    void b_read() {
        Employee read = employeeService.read(employee.getEmployeeID());
        assertNotNull(read);
        System.out.println("Read: " +read);
    }

    @Test
    void c_update() {
        Employee updated = new Employee.Builder().copy(employee).setEmployeeFirstName("Robert").build();
        assertNotNull(employeeService.update(updated));
        System.out.println("Updated: " +updated);
    }

    @Test
    void e_delete() {
        employeeService.delete(employee.getEmployeeID());
        assertNotNull(employeeService);
        System.out.println("Deleted: " +employeeService.getAll());
    }

    @Test
    void d_getAll(){
        System.out.println("Show all data: ");
        System.out.println(employeeService.getAll());
    }
}