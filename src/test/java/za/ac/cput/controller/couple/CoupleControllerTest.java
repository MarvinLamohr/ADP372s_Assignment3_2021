package za.ac.cput.controller.couple;

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
import org.springframework.web.bind.annotation.RequestMapping;
import za.ac.cput.entity.Contact;
import za.ac.cput.entity.Couple;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CoupleFactory;
import za.ac.cput.services.contact.ContactService;
import za.ac.cput.services.couple.CoupleService;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CoupleControllerTest {
    private static Couple couple = CoupleFactory.createCouple("Jorge","Philippi","male","21");
    public static String SECURITY_USERNAME= "jorge";
    public static String SECURITY_PASSWORD="pass";

    @Autowired
    private TestRestTemplate restTemplate;
    private final String base_URL = "http://localhost:8080/couple";

    @Test
    void a_create() {
        String url = base_URL + "/create";
        ResponseEntity<Couple> postResponse = restTemplate.postForEntity(url,couple, Couple.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        //assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        couple = postResponse.getBody();
        System.out.println("Saved data" + couple);
        assertEquals(couple.getCoupleId(), postResponse.getBody().getCoupleId());
    }

    @Test
    void b_read() {
        String url = base_URL + "/read" + couple.getCoupleId();
        System.out.println("URL" + url);
        ResponseEntity<Couple> response = restTemplate.postForEntity(url,couple,Couple.class);
        assertEquals(couple.getCoupleId(), response.getBody().getCoupleId());
    }

    @Test
    void c_update() {
        Couple updated  = new Couple.Builder().copy(couple).setAge("26").build();
        String url = base_URL + "/updated";
        System.out.println("URL" + url);
        System.out.println("Post data" + updated);
        ResponseEntity<Couple> response = restTemplate.postForEntity(url,updated, Couple.class);
        assertNotNull(response.getBody());
    }

    @Test
    void delete() {
        String url = base_URL + "/deleted";
        System.out.println("URL" + url);
        restTemplate.delete(url);
    }
    @Test
    void getAll() {

        String url = base_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity entity= new HttpEntity<>(null,headers);
        ResponseEntity<String> response  = restTemplate
                .withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all:");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}