package se.chriskevin.microservice.springboot.data;

import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import se.chriskevin.microservice.springboot.model.User;

@Component
@NoArgsConstructor
@Getter
public class UserStore {

  private List<User> users = List.of(new User(1, "Chris"), new User(2, "Kevin"));

  public Option<User> getUser(final Integer id) {
    return this.users.find(user -> user.getId().equals(id));
  }

  public User addUser(final User user) {
    this.users = this.users.append(user);
    return user;
  }

  public Option<User> removeUser(final Integer id) {
    final var user = getUser(id);
    this.users = user.map(x -> this.users.remove(x)).getOrElse(this.users);
    return user;
  }

  public Option<User> updateUser(final Integer id, final User updatedUser) {
    final var user = getUser(id);
    this.users = user.map(x -> this.users.replace(x, updatedUser)).getOrElse(this.users);
    return user;
  }
}
