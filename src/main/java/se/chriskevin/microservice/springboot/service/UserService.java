package se.chriskevin.microservice.springboot.service;

import io.vavr.collection.List;
import io.vavr.control.Option;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.chriskevin.microservice.springboot.data.UserStore;
import se.chriskevin.microservice.springboot.model.User;
import se.chriskevin.microservice.springboot.model.WritableUserDetails;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

  @Autowired private UserStore userStore;

  public List<User> getUsers() {
    return userStore.getUsers();
  }

  public Option<User> getUser(final UUID id) {
    return userStore.getUsers().find(user -> user.getId().equals(id));
  }

  public void deleteUser(final UUID uuid) {
    userStore.removeUser(uuid);
  }

  public User addUser(final WritableUserDetails userDetails) {
    return userStore.addUser(new User(UUID.randomUUID(), userDetails.getUsername()));
  }
}
