package ru.rrenat358.persist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UserRepository {


    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {
        return entityManager.createQuery(
                "select u from User u",
                User.class).getResultList();
    }


    private Optional<User> userById(long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    public User save(User user) {
        if (user.getId() != null) {
            entityManager.merge(user);
        } else {
            entityManager.persist(user);
        }
        return user;
    }

    public void deleteById(long id) {
        entityManager.createQuery(
                "delete from User u where u.id = id",
                User.class)
                .setParameter("id",id)
                .executeUpdate();
    }

}
