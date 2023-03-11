package ru.rrenat358.persist;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    List<User> findAll();

    Optional<User> userById(long id);

    User save(User user);


    void deleteById(long id);


}
