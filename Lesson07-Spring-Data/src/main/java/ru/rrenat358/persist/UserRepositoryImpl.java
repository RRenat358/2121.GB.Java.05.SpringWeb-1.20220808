package ru.rrenat358.persist;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository/*("persistentUserRepository")*/
public class UserRepositoryImpl implements UserRepository{


    @PersistenceContext
    private EntityManager entityManager;

    public List<User> findAll() {
        return entityManager.createQuery(
                "select u from User u",
                User.class).getResultList();
    }


    public Optional<User> userById(long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Transactional
    public User save(User user) {
        if (user.getId() != null) {
            entityManager.merge(user);
        } else {
            entityManager.persist(user);
        }
        return user;
    }

    @Transactional
    public void deleteById(long id) {
        entityManager.createQuery(
                "delete from User u where u.id = :id",
                User.class)
                .setParameter("id",id)
                .executeUpdate();
    }

}
