package ru.rrenat358.persist;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

/*
    List<User> findAll();

    Optional<User> userById(long id);

    User save(User user);


    void deleteById(long id);
*/

}
