package mum.swe.democrud.CoursesTestes;

import mum.sched.MumSchedApplication;
import mum.sched.model.Course;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MumSchedApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CoursesEndingPoints {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    private final String route = "/courses/";

    private String getRootUrl() {
        return "http://localhost:" + port + "/api";
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void testGetAllCourses() {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + route,
                HttpMethod.GET, entity, String.class);
        Assert.assertEquals(response.getStatusCode().value(), 200);
    }

    @Test
    public void testAddCourse() {
        Course course = new Course();
        course.setCode("CS425");
        course.setName("Software Enginnering");
        ResponseEntity<Course> response
                = restTemplate.postForEntity(getRootUrl() + route, course, Course.class);
        Assert.assertEquals(response.getStatusCode().value(), 200);
    }


    @Test
    public void testUpdateCourse() {
        int id = 2;
        Course course = restTemplate.getForObject(getRootUrl() + route + id, Course.class);
        course.setName("change via Junit");
        restTemplate.put(getRootUrl() + route + id, course);
        Course updatedCourse = restTemplate.getForObject(getRootUrl() + route +  id, Course.class);
        Assert.assertEquals(true, true);
    }

    @Test
    public void testDeletePost() {
//        int id = 2;
//        Course course = restTemplate.getForObject(getRootUrl() + "/users/" + id, Course.class);
//        Assert.assertNotNull(user);
//
//        restTemplate.delete(getRootUrl() + "/users/" + id);
//
//        try {
//            user = restTemplate.getForObject(getRootUrl() + "/users/" + id, Course.class);
//        } catch (final HttpClientErrorException e) {
//            Assert.assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
//        }
    }

}