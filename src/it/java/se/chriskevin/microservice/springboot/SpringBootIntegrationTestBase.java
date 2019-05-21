package se.chriskevin.microservice.springboot;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("integration-test")
@SpringBootTest(
  classes = Application.class,
  webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT
)
public class SpringBootIntegrationTestBase {
  @Autowired protected TestRestTemplate restTemplate;

  public SpringBootIntegrationTestBase() {}
}
