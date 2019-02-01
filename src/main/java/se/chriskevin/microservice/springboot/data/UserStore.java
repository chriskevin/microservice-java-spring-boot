package se.chriskevin.microservice.springboot.data;

import io.vavr.collection.List;
import io.vavr.control.Option;
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

  public Option<User> getUser(final UUID uuid) {
    return this.users.find(user -> user.getId().equals(uuid));
  }

  public User addUser(final User user) {
    this.users = this.users.append(user);
    return user;
  }

  public Option<User> removeUser(final UUID uuid) {
    final Option<User> user = getUser(uuid);
    this.users = user.map(x -> this.users.remove(x)).getOrElse(this.users);
    return user;
  }

  public Option<User> updateUser(final UUID uuid, final User updatedUser) {
    final Option<User> user = getUser(uuid);
    this.users = user.map(x -> this.users.replace(x, updatedUser)).getOrElse(this.users);
    return user;
  }
}
