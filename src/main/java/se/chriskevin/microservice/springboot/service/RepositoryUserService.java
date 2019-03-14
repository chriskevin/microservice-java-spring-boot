package se.chriskevin.microservice.springboot.service;

import io.vavr.collection.List;
import io.vavr.control.Option;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import se.chriskevin.microservice.springboot.data.repository.UserRepository;
import se.chriskevin.microservice.springboot.model.User;

@Service
@AllArgsConstructor
public final class RepositoryUserService implements UserService {

  private final UserRepository userRepository;

  @Override
  public List<User> getUsers() {
    return List.ofAll(userRepository.findAll());
  }

  @Override
  public Option<User> getUser(final Integer id) {
    return Option.ofOptional(userRepository.findById(id));
  }

  @Override
  public Option<User> deleteUser(final Integer id) {
    final var maybeUser = Option.ofOptional(userRepository.findById(id));
    maybeUser.forEach(userRepository::delete);
    return maybeUser;
  }

  @Override
  public User addUser(final User user) {
    return userRepository.save(user);
  }

  @Override
  public Option<User> updateUser(final Integer id, User user) {
    final var maybeUser = Option.ofOptional(userRepository.findById(id));
    maybeUser.forEach(userRepository::save);
    return maybeUser;
  }
}
