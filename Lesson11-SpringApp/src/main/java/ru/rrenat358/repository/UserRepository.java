package ru.rrenat358.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import ru.rrenat358.model.User;


import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {
/*
    List<User> findAll();
    Optional<User> userById(long id);
    User save(User user);
    void deleteById(long id);
*/

    Page<User> findAllByUsernameLike(String usernameFilter, Pageable pageable);


    @Query(value = """
            select * from users u
            where (:usernameFilter is null or u.username like :usernameFilter)
            and (:emailFilter is null or u.email like :emailFilter)
            """,
            countQuery = """
            select count(*) from users u
            where (:usernameFilter is null or u.username like :usernameFilter)
            and (:emailFilter is null or u.email like :emailFilter)
            """,
            nativeQuery = true)
    Page<User> usersByFilter(String usernameFilter, String emailFilter, Pageable pageable);

    Optional<User> findByUsername(String username);

}
