package org.tomasbarauskas.services.user.services;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.tomasbarauskas.entities.user.User;
import org.tomasbarauskas.utilities.HibernateConfiguration;

public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(Long id) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();
        User user = null;

        try {
            user = session.get(User.class, id);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return user;
    }

    @Override
    public User getUserByUserId(String userId) {
        Session session = HibernateConfiguration.openSession();
        Query query = session.createQuery("FROM User WHERE userId = :userId", User.class);
        query.setParameter("userId", userId);

        return (User) query.getSingleResult();
    }

    @Override
    public void saveOrUpdate(User user) {
        Session session = HibernateConfiguration.openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.saveOrUpdate(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
    }
}