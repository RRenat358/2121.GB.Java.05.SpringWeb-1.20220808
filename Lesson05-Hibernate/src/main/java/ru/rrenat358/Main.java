package ru.rrenat358;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import ru.rrenat358.model.User;

import java.util.List;
//import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        System.out.println("==============================");
        System.out.println("=== Start \"hibernate.cnf.xml\" === ");

        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();


        System.out.println("==============================");
        System.out.println("=== Query === ");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //INSERT
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(new User("User1", "1"));
//        entityManager.persist(new User("User2", "2"));
//        entityManager.persist(new User("User3", "3"));
//
//        entityManager.getTransaction().commit();

        //SELECT
//        User user = entityManager.find(User.class, 2L);

        //JPQL, HQL
        List<User> users = entityManager
                .createQuery("select u from User u where u.id in (2, 3)", User.class)
                .getResultList();
        for (User userFromDB : users) {
            System.out.println(userFromDB);
        }


        entityManagerFactory.close();
    }
}