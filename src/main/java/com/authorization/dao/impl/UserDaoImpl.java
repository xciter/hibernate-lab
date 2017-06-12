package com.authorization.dao.impl;

import com.authorization.dao.UserDao;
import com.authorization.entities.User;
import com.authorization.entities.UserInfo;

import javax.persistence.*;


public class UserDaoImpl implements UserDao {

    private static final EntityManagerFactory ENTITY_MANAGER_PERSISTENCE =
            Persistence.createEntityManagerFactory("Authorization");

    private EntityManager manager;

    public void addUser(User user) {
        manager = ENTITY_MANAGER_PERSISTENCE.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            UserInfo info = user.getUserInfo();
            info.setUser(user);
            user.setUserInfo(info);
            manager.persist(user);
            transaction.commit();

        } catch (Exception exp) {
            System.out.println("Error during transaction, performing rollback\n" + exp);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            manager.close();
        }

    }

    public boolean isUserValid(User user) {
        manager = ENTITY_MANAGER_PERSISTENCE.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Query query = manager.createQuery("from UserInfo WHERE name=:userName");
            query.setParameter("userName", user.getUserInfo().getName());
            if (!query.getResultList().isEmpty()) {
                return false;
            }

            query = manager.createQuery("from UserInfo WHERE email=:userEmail");
            query.setParameter("userEmail", user.getUserInfo().getEmail());
            if (!query.getResultList().isEmpty()) {
                return false;
            }

            return true;

        } catch (Exception exp) {
            System.out.println("Error during transaction, performing rollback\n" + exp);
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        } finally {
            manager.close();
        }
    }

    public boolean isUserExist(User user) {
        manager = ENTITY_MANAGER_PERSISTENCE.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Query query = manager.createQuery("from UserInfo WHERE name=:userName");
            query.setParameter("userName", user.getUserInfo().getName());
            if (query.getResultList().isEmpty()) {
                return false;
            }

            return true;

        } catch (Exception exp) {
            System.out.println("Error during transaction, performing rollback\n" + exp);
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        } finally {
            manager.close();
        }
    }

    public void updateUser(User user) {
        manager = ENTITY_MANAGER_PERSISTENCE.createEntityManager();
        EntityTransaction transaction = null;

        try {
            manager.merge(user);

        } catch (Exception exp) {
            System.out.println("Error during transaction, performing rollback\n" + exp);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            manager.close();
        }
    }

    public void getUserInfo(User user) {
        manager = ENTITY_MANAGER_PERSISTENCE.createEntityManager();
        EntityTransaction transaction = null;

        try {
            Query query = manager.createQuery("from User WHERE id=:id");
            query.setParameter("id", user.getId());
            user = (User) query.getSingleResult();

        } catch (Exception exp) {
            System.out.println("Error during transaction, performing rollback\n" + exp);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            manager.close();
        }
    }
}
