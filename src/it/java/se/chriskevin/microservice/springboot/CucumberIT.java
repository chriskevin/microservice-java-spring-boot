package se.chriskevin.microservice.springboot;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/it/resources/features",
    glue = "se.chriskevin.microservice.springboot.stepdef",
    plugin = {
      "pretty",
      "html:target/cucumber-report/html",
      "junit:target/surefire-reports/cucumber.xml"
    },
    strict = true)
public class CucumberIT {
  public CucumberIT() {}
}
