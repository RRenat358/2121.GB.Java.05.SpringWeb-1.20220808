package ru.rrenat358.homework;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import ru.rrenat358.model.User;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class UserRepository {

    private final EntityManagerFactory emFactory;

    public UserRepository(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public Optional<User> findById(long id) {
        return executeForEntityManager(entityManager ->
                Optional.ofNullable(entityManager.find(User.class, id)));
    }

    public List<User> findAll() {
        return executeForEntityManager(entityManager ->
                entityManager.createNamedQuery("findAllUsers", User.class).getResultList());
    }

    public long count() {
        return executeForEntityManager(entityManager ->
                entityManager.createNamedQuery("countAllUsers", Long.class).getSingleResult());
    }

    public void save(User user) {
        executeInTransaction(entityManager -> {
            if (user.getId() == null) {
                entityManager.persist(user);
            } else {
                entityManager.merge(user);
            }
        });
    }

    public void delete(long id) {
        executeInTransaction(entityManager -> entityManager.createNamedQuery("deleteUserById")
                .setParameter("id", id)
                .executeUpdate());
    }

    private <R> R executeForEntityManager(Function<EntityManager, R> function) {
        EntityManager em = emFactory.createEntityManager();
        try {
            return function.apply(em);
        } finally {
            em.close();
        }
    }

    private void executeInTransaction(Consumer<EntityManager> consumer) {
        EntityManager em = emFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            consumer.accept(em);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
