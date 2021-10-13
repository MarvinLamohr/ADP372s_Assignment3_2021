package za.ac.cput.controller.event;

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
import za.ac.cput.entity.Event;
import za.ac.cput.factory.EventFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EventControllerTest {

    private static Event event = EventFactory.createEvent("Lamohr Wedding","LamW2021","100",200,"2021/08/25");

    public static String SECURITY_USERNAME="xyz";
    public static String SECURITY_PASSWORD="123";

    @Autowired
    private TestRestTemplate restTemplate;
    private final String BASE_URL = "http://localhost:8080/event";

    @Test
    void a_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Event> postResponse = restTemplate.postForEntity(url,event,Event.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());

        event = postResponse.getBody();
        System.out.println("Saved data: "+ event);
        assertEquals(event.getEventID(),postResponse.getBody().getEventID());

    }

    @Test
    void b_read() {
        String url = BASE_URL + "/read/" + event.getEventID();
        System.out.println("URL: "+ url);
        ResponseEntity<Event> response = restTemplate.getForEntity(url,Event.class);
        assertEquals(event.getEventID(),response.getBody().getEventID());
    }

    @Test
    void c_update() {
        Event updated = new Event.Builder().copy(event).setGuestList("150").build();
        String url = BASE_URL + "/update";
        System.out.println("URL: "+ url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Event> response = restTemplate.postForEntity(url, updated,Event.class);
        assertNotNull(response.getBody());
    }

    @Test
    void d_delete() {
        String url = BASE_URL + "/delete/" + event.getEventID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
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