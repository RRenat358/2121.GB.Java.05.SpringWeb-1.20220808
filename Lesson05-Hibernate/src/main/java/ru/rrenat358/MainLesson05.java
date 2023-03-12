package ru.rrenat358;

//import org.hibernate.cfg.Configuration;

public class MainLesson05 {
    public static void main(String[] args) {

//        System.out.println("==============================");
//        System.out.println("=== Start \"hibernate.cnf.xml\" === ");
//
//        EntityManagerFactory entityManagerFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .buildSessionFactory();
//
//
//        System.out.println("==============================");
//        System.out.println("=== Query === ");
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //==============================
        //INSERT
//        entityManager.getTransaction().begin();
//
//        entityManager.persist(new User("User1", "1"));
//        entityManager.persist(new User("User2", "2"));
//        entityManager.persist(new User("User3", "3"));
//
//        entityManager.getTransaction().commit();

//        entityManager.getTransaction().begin();
//
//        entityManager.persist(new User("User1", "1@a.com", "pass1"));
//        entityManager.persist(new User("User2", "2@a.com", "pass2"));
//        entityManager.persist(new User("User3", "3@a.com", "pass3"));
//
//        entityManager.getTransaction().commit();

        //==============================
        //SELECT
//        User user = entityManager.find(User.class, 1L);
//
//        //JPQL, HQL
//        List<User> users = entityManager
//                .createQuery("select u from User u where u.id in (3, 1)", User.class)
//                .getResultList();
//        for (User userFromDB : users) {
//            System.out.println(userFromDB);
//        }

        //==============================
        //UPDATE
//        entityManager.getTransaction().begin();
//
//        User user = entityManager.find(User.class, 2L);
//        user.setUsername("User2 NEW");
//
//        entityManager.getTransaction().commit();


//        entityManager.getTransaction().begin();
//
//        //===
//        User user = new User("User3 NEW", "333");
//        user.setId(3L);
//        entityManager.merge(user);
//
//        entityManager.getTransaction().commit();


        //==============================
        // DELETE
//        entityManager.getTransaction().begin();
//
//        User user = entityManager.find(User.class, 2L);
////        entityManager.createQuery("delete from User u where u.id = 3").executeUpdate();
//        entityManager.remove(user);
//
//        entityManager.getTransaction().commit();

//        Object singleResult = entityManager.createNativeQuery("""
//                            select u.id as userId
//                            from users u
//                            where u.username like '%ne%'
//                """, String.class).getSingleResult();


        //==============================
//        entityManager.close();
//        entityManagerFactory.close();
    }
}