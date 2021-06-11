package za.ac.cput.Factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.Entity.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

private Employee employee1;
private Employee employee2;

    @BeforeEach
    void setUp(){
        Employee employee1 = new Employee.Builder().
                                 setEmployeeName("Marvin").
                                 setEmployeeID("214273830").
                                 setEmployeeAddress("90 Plein Street,Cape Town").
                                 setEmployeeEmail("214273830@mycput.ac.za").
                                 setPosition("CEO").
                                 build();

        Employee employee2 = employee1;
    }

    @Test
    void objectEquality(){

        assertEquals(employee2,employee1);

    }

    @Test
    void objectIdentity(){

        assertSame(employee1,employee2);

    }

    @Test
    @Timeout(3)
    void timeOuts() throws InterruptedException{

        Thread.sleep(300);
        System.out.println("Loadshedding Will Be Over Soon... Please be patient...");

    }

    @Test
    @Disabled
    void disablingTest() throws InterruptedException{

        assertEquals(employee1,employee2);
        System.out.println("Welcome");

    }
}