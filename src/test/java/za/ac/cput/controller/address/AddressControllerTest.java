package za.ac.cput.controller.address;

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
import za.ac.cput.entity.Address;
import za.ac.cput.factory.AddressFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AddressControllerTest {
    private static Address address = AddressFactory.createAddress("X63 Molokwane","8000");
    @Autowired
    private TestRestTemplate restTemplate;
    private  final  String BASE_URL = "http://localhost:8080/address";

    @Test
    void a_created() {
        String url = BASE_URL + "/create";
        ResponseEntity<Address> postResponse = restTemplate.postForEntity(url, address,Address.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        address = postResponse.getBody();
        System.out.println("Save data "+ address);
        assertEquals(address.getStreetAddress(), postResponse.getBody().getStreetAddress());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read";
        System.out.println("URL "+ url);
        ResponseEntity<Address> response = restTemplate.getForEntity(url,Address.class);
        assertEquals(address.getStreetAddress(), response.getBody().getStreetAddress());


    }

    @Test
    void c_update() {
        Address updated = new Address.Builder().copy(address).setPostalAddress("7860").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: "+ url);
        System.out.println("Post data: "+ updated);
        ResponseEntity<Address> response = restTemplate.postForEntity(url,updated,Address.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete"+ address.getStreetAddress();
        System.out.println("URL: "+ url);
        restTemplate.delete(url);
    }


    @Test
    void getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }

}