package se.chriskevin.microservice.springboot.service;

import io.vavr.collection.List;
import io.vavr.control.Option;
import se.chriskevin.microservice.springboot.model.User;

public interface UserService {

  List<User> getUsers();

  Option<User> getUser(final Integer id);

  Option<User> deleteUser(final Integer id);

  User addUser(final User user);

  Option<User> updateUser(final Integer id, final User user);
}
