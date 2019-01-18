package se.chriskevin.microservice.springboot.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Wither;

@AllArgsConstructor
@Getter
@Setter
@Wither
@EqualsAndHashCode
@ToString
public class WritableUserDetails {

  @NonNull private String username;
}
