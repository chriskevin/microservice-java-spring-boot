package se.chriskevin.microservice.springboot.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import lombok.*;

@Entity
@Table(name = "user")
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Getter
@With
@EqualsAndHashCode
@ToString
public class User {

  @ApiModelProperty(value = "UUID that identifies a unique user")
  @JsonProperty(access = JsonProperty.Access.READ_ONLY)
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private final Integer id;

  @ApiModelProperty(value = "Alias for the users real name")
  @NonNull
  private final String name;
}
