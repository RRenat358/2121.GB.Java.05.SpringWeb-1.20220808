package ru.rrenat358;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;

public class MainLesson06 {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        //==============================//==============================
//        Contact mobile = new Contact(ContactType.MOBILE_PHONE, "123");
//        Contact email = new Contact(ContactType.HOME_EMAIL, "email@mail.com");
//        List<Contact> firstUserContactList = Arrays.asList(mobile, email);
//
//        Contact mobile2 = new Contact(ContactType.MOBILE_PHONE, "456");
//        Contact email2 = new Contact(ContactType.HOME_EMAIL, "email3222@mail.com");
//        List<Contact> secondUserContactList = Arrays.asList(mobile2, email2);

        //==============================
//        User user = new User("User1", firstUserContactList, "pass1");
//        User user2 = new User("User2", secondUserContactList, "pass2");


        //==============================//==============================
//        User user3 = new User("User3", firstUserContactList, "pass2");
//        Passport passport = new Passport("1234", "123", "RUVD", Instant.now());
////        Passport passport2 = new Passport("1234", "123", "RUVD", Instant.now());
//        user3.setPassport(passport);
////        user2.setPassport(passport2);
//        entityManager.getTransaction().begin();
//        entityManager.persist(user3);
//        entityManager.getTransaction().commit();

//        User user31 = new User("User31", firstUserContactList, "pass31");
//        Passport passport31 = new Passport("31313", "31311", "RUVD31", Instant.now());
//        user31.setPassport(passport31);
//        entityManager.getTransaction().begin();
//        entityManager.persist(user31);
//        entityManager.getTransaction().commit();

        //==============================//==============================
        //INSERT
//        entityManager.getTransaction().begin();
//        firstUserContactList.forEach(contact -> contact.setUser(user));
//        secondUserContactList.forEach(contact -> contact.setUser(user2));
//        entityManager.persist(user);
//        entityManager.persist(user2);
//        entityManager.getTransaction().commit();

        //OR

        //==============================
        //INSERT
//        entityManager.getTransaction().begin();
//        firstUserContactList.forEach(contact -> contact.setUser(user));
//        secondUserContactList.forEach(contact -> contact.setUser(user2));
//        user2.setId(2L);
//        entityManager.merge(user2);
//        entityManager.getTransaction().commit();


        //==============================
        //SELECT
//        entityManager.getTransaction().begin();
//
//        List<User> users = entityManager.createNamedQuery("findAllUsers", User.class).getResultList();
//
//        List<Contact> contacts = users.get(0).getContacts();
//
//        for (User user1 : users) {
//            user1.getContacts().forEach(System.out::println);
//        }
//        entityManager.getTransaction().commit();

        //==============================
        //SELECT JOIN FETCH
//        entityManager.getTransaction().begin();
//
//        List<User> users = entityManager.createQuery("""
//                SELECT u FROM User u
//                JOIN FETCH u.contacts
//                """, User.class)
//                .getResultList();
//
//        List<Contact> contacts = users.get(0).getContacts();
//
//        for (User user1 : users) {
//            user1.getContacts().forEach(System.out::println);
//        }
//        entityManager.getTransaction().commit();


        //DELETE & orphanRemoval
//        entityManager.getTransaction().begin();
//
//        User user = entityManager.find(User.class, 2L);
//        user.getContacts().remove(0);
//        entityManager.merge(user);
//
//        entityManager.getTransaction().commit();


        //==============================//==============================
        System.out.println();
        System.out.println();
        System.out.println();

        entityManager.close();
        entityManagerFactory.close();


    }
}
