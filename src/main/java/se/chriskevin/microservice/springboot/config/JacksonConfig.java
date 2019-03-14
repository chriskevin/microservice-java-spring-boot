package se.chriskevin.microservice.springboot.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import io.vavr.jackson.datatype.VavrModule;
import java.util.Arrays;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonConfig {

  @Bean
  @Primary
  public Jackson2ObjectMapperBuilder objectMapperBuilder() {
    return new Jackson2ObjectMapperBuilder()
        .modules(
            Arrays.asList(
                new Jdk8Module(),
                new JavaTimeModule(),
                new ParameterNamesModule(),
                new VavrModule()))
        .indentOutput(true)
        .visibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
        .visibility(PropertyAccessor.CREATOR, JsonAutoDetect.Visibility.ANY);
  }
}
