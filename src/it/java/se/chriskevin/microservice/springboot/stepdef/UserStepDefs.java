package se.chriskevin.microservice.springboot.stepdef;

import static org.assertj.core.api.Assertions.assertThat;

import cucumber.api.java8.En;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import se.chriskevin.microservice.springboot.SpringBootIntegrationTestBase;

@RunWith(SpringRunner.class)
public final class UserStepDefs extends SpringBootIntegrationTestBase implements En {
  private static final String REGEX_HTTP_STATUS_CODE = "\\d{3}";
  private static final String REGEX_PATH = "/([a-zA-Z0-9]-?/?)*";
  private static final String REGEX_REQUEST_PARAMS = "(\\?([a-zA-Z0-9]\\=[a-zA-Z0-9])+)?";

  private ResponseEntity<String> response;
  private String path;

  public UserStepDefs() {

    Given("^REST URL <\"(.*)\">$", (final String path) -> this.path = path);

    When("^GET request is sent$", () -> response = restTemplate.getForEntity(path, String.class));

    Then(
        "^response status should be <(" + REGEX_HTTP_STATUS_CODE + ")>",
        (final Integer expected) ->
            assertThat(response.getStatusCode().value()).isEqualTo(expected));

    Then(
        "^response body should match$",
        (final String expected) -> JSONAssert.assertEquals(expected, response.getBody(), false));
  }
}
