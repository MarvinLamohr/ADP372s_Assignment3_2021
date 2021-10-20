package za.ac.cput.controller.venue;

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
import za.ac.cput.entity.Venue;
import za.ac.cput.factory.VenueFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class VenueControllerTest {
    private static Venue venue = VenueFactory.createVenue("MPH","D six",200);
    @Autowired
    private TestRestTemplate restTemplate;
    private  final  String BASE_URL = "http://localhost:8080/address";
    @Test
    void a_created() {
        String url = BASE_URL + "/create";
        ResponseEntity<Venue> postResponse = restTemplate.postForEntity(url, venue,Venue.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        venue = postResponse.getBody();
        System.out.println("Save data "+ venue);
        assertEquals(venue.getVenueName(), postResponse.getBody().getVenueName());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read";
        System.out.println("URL "+ url);
        ResponseEntity<Venue> response = restTemplate.getForEntity(url,Venue.class);
        assertEquals(venue.getVenueName(),response.getBody().getVenueName());
    }

    @Test
    void c_update() {
        Venue updated = new Venue.Builder().copy(venue).setVenueLocation("Wellington").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: "+ url);
        System.out.println("Post data: "+ updated);
        ResponseEntity<Venue> response = restTemplate.postForEntity(url,updated,Venue.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete"+ venue.getVenueName();
        System.out.println("URL: "+ url);
        restTemplate.delete(url);
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);
        System.out.println("Show all");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}