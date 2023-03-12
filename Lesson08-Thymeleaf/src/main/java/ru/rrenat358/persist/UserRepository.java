package ru.rrenat358.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {
/*
    List<User> findAll();
    Optional<User> userById(long id);
    User save(User user);
    void deleteById(long id);
*/

    List<User> findAllByUsernameLike(String usernameFilter);

    @Query(value = """
            select * from users u
            where (:usernameFilter is null or u.username like :usernameFilter)
            and (:emailFilter is null or u.email like :emailFilter)
            """, nativeQuery = true)
    List<User> usersByFilter(String usernameFilter, String emailFilter);


}
