package za.ac.cput.controller.booking;

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
import za.ac.cput.entity.Booking;
import za.ac.cput.factory.BookingFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookingControllerTest {

    private static Booking booking = BookingFactory.createBooking("0001", "Hendricks", "21 that str", "10 Nov 2021", "Active", 10000.00);

    public static String SECURITY_USERNAME="xyz";
    public static String SECURITY_PASSWORD="123";

    @Autowired
    private TestRestTemplate restTemplate;
    private String BASE_URL = "http://localhost:8080/booking";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Booking> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url,booking,Booking.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        booking = postResponse.getBody();
        System.out.println("Saved data: "+ booking);
        assertEquals(booking.getBookingID(), postResponse.getBody().getBookingID());
    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read" + booking.getBookingID();
        System.out.println("URL: "+ url);
        ResponseEntity<Booking> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).getForEntity(url,Booking.class);
        assertEquals(booking.getBookingID(), response.getBody().getBookingID());
    }

    @Test
    void c_update() {
        Booking updated = new Booking.Builder().copy(booking).setAddress("22 This str").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: "+ url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Booking> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).postForEntity(url, updated, Booking.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete" + booking.getBookingID();
        System.out.println("URL: " + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD).delete(url);
    }

    @Test
    void e_getAll() {
        String url = BASE_URL + "/getall";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).exchange(url, HttpMethod.GET, entity, String.class);
        
        System.out.println("Show all data: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}