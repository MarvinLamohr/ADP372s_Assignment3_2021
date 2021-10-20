package za.ac.cput.controller.employee;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

    private static Employee employee = EmployeeFactory.createEmployee("Myles","Evans","evens1234","0735684025","10 Main Road Woodstock 7654","mylesevens@gmail.com","Designer");

    public static String SECURITY_USERNAME="xyz";
    public static String SECURITY_PASSWORD="123";

    @Autowired
    private TestRestTemplate restTemplate;
    private String BASE_URL = "http://localhost:8080/employee/";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Employee> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url,employee,Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        employee = postResponse.getBody();
        System.out.println("Saved data: "+ employee);
        assertEquals(employee.getEmployeeID(),postResponse.getBody().getEmployeeID());

    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + employee.getEmployeeID();
        System.out.println("URL: "+ url);
        ResponseEntity<Employee> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url,Employee.class);
        assertEquals(employee.getEmployeeID(),response.getBody().getEmployeeID());

    }

    @Test
    void c_update() {
        Employee updated = new Employee.Builder().copy(employee).setPosition("IT").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: "+ url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Employee> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, updated,Employee.class);
        assertNotNull(response.getBody());

    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/" + employee.getEmployeeID();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }

    @Test
    void e_getAll(){
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all data: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}