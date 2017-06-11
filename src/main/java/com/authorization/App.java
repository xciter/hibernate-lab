package com.authorization;


import com.authorization.entities.User;
import com.authorization.entities.UserInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class App {

    private static final EntityManagerFactory ENTITY_MANAGER_PERSISTENCE =
            Persistence.createEntityManagerFactory("Authorization");

    public static void main(String[] args) {

        create(1, "nagebator", "xxxNAGIBxxx@mail.ru", "Vasya", "Pupkin", "qwerty");
        create(2, "sexbomb", "dusya55@mail.ru", "Dusya", "Lyalya", "0000");
        create(3, "nagebatorXXX", "xxxNAGIB1111xxx@mail.ru", "Vasya", "Pupkin", "qwerty");
        create(4, "sexbomba", "dusya58@mail.ru", "Dusya", "Lyalya", "0000");

        List users = readAll();
        for (Object user : users) {
            System.out.println(user);
        }
        ENTITY_MANAGER_PERSISTENCE.close();

    }

    public static void create(int id, String name, String email, String firstName, String secondName, String password) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_PERSISTENCE.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Create a new User object
            User user = new User();
            user.setId(id);
            user.setPassword(password);
            UserInfo userInfo = new UserInfo();
            userInfo.setName(name);
            userInfo.setEmail(email);
            userInfo.setFirstName(firstName);
            userInfo.setSecondName(secondName);
            user.setUserInfo(userInfo);

            // Save the user object
            manager.persist(user);

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
    }

    public static List readAll() {
        List users = null;

        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_PERSISTENCE.createEntityManager();
        EntityTransaction transaction = null;

        try {
            // Get a transaction
            transaction = manager.getTransaction();
            // Begin the transaction
            transaction.begin();

            // Get a List of Users
            users = manager.createQuery("SELECT u FROM User u",
                    User.class).getResultList();

            // Commit the transaction
            transaction.commit();
        } catch (Exception ex) {
            // If there are any exceptions, roll back the changes
            if (transaction != null) {
                transaction.rollback();
            }
            // Print the Exception
            ex.printStackTrace();
        } finally {
            // Close the EntityManager
            manager.close();
        }
        return users;
    }
}
