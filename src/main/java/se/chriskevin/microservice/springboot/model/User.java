package se.chriskevin.microservice.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;
import lombok.experimental.Wither;

@AllArgsConstructor
@Getter
@Wither
@EqualsAndHashCode
@ToString
public class User {

  @ApiModelProperty(value = "UUID that identifies a unique user")
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @NonNull
  private final UUID id;

  @NonNull
  @ApiModelProperty(value = "Alias for the users real name")
  private final String username;
}
