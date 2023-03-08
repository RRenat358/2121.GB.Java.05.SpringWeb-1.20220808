package ru.rrenat358;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
        System.out.println(" configure(\"hibernate.cnf.xml\") ");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManagerFactory.close();



    }
}