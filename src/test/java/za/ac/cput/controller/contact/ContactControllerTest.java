package za.ac.cput.controller.contact;

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
import za.ac.cput.entity.Contact;
import za.ac.cput.factory.ContactFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ContactControllerTest {
    private static Contact contact = ContactFactory.createContact("027","025","asive@gmail.com");
    public static String SECURITY_USERNAME= "asive";
    public static String SECURITY_PASSWORD="pass";

    @Autowired
    private TestRestTemplate restTemplate;
    private final String base_URL = "http://localhost:8080/contact";

    @Test
    void a_create() {
        String url = base_URL + "/create";
        ResponseEntity<Contact> postResponse = restTemplate.postForEntity(url,contact, Contact.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        contact = postResponse.getBody();
        System.out.println("Saved data" + contact);
        assertEquals(contact.getId(), postResponse.getBody().getId());
    }

    @Test
    void b_read() {

        String url = base_URL + "/read" + contact.getId();
        System.out.println("URL" + url);
        ResponseEntity<Contact> response = restTemplate.postForEntity(url,contact,Contact.class);
        assertEquals(contact.getId(), response.getBody().getId());
    }

    @Test
    void c_update() {
        Contact updated  = new Contact.Builder().copy(contact).setEmail("savie@gmail.com").build();
        String url = base_URL + "/updated";
        System.out.println("URL" + url);
        System.out.println("Post data" + updated);
        ResponseEntity<Contact> response = restTemplate.postForEntity(url,updated, Contact.class);
        assertNotNull(response.getBody());


    }

    @Test
    void d_delete() {
        String url = base_URL + "/deleted";
        System.out.println("URL" + url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url = base_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity= new HttpEntity<>(null,headers);
        ResponseEntity<String> response  = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url,HttpMethod.GET, entity, String.class);
        System.out.println("Show all:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}