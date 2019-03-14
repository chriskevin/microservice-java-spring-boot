package se.chriskevin.microservice.springboot.data.repository;

import org.springframework.data.repository.CrudRepository;
import se.chriskevin.microservice.springboot.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {}
