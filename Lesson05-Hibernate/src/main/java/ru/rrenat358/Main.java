package ru.rrenat358;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import ru.rrenat358.model.User;
//import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        System.out.println("==============================");
        System.out.println("=== Start \"hibernate.cnf.xml\" === ");
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        System.out.println("==============================");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(new User("User1", "1"));
        entityManager.persist(new User("User2", "2"));
        entityManager.persist(new User("User3", "3"));




        entityManager.getTransaction().commit();



        entityManagerFactory.close();



    }
}