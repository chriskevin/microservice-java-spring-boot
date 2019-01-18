package se.chriskevin.microservice.springboot.data;

import io.vavr.collection.List;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import se.chriskevin.microservice.springboot.model.User;

@Component
@NoArgsConstructor
@Getter
public class UserStore {

  private List<User> users =
      List.of(new User(UUID.randomUUID(), "Chris"), new User(UUID.randomUUID(), "Kevin"));

  public User addUser(final User user) {
    this.users = this.users.append(user);
    return user;
  }

  public UUID removeUser(final UUID uuid) {
    this.users = this.users.remove(unsafeGetUser(uuid));
    return uuid;
  }

  public User updateUser(final UUID uuid, final User updatedUser) {
    this.users = this.users.replace(unsafeGetUser(uuid), updatedUser);
    return unsafeGetUser(uuid);
  }

  private User unsafeGetUser(final UUID uuid) {
    return this.users.find(user -> user.getId().equals(uuid)).get();
  }
}
