package org.tomasbarauskas.utilities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {

    private static Configuration configuration = new Configuration().configure();

    private static SessionFactory sessionFactory;

    public static Session openSession() {
        return sessionFactory.openSession();
    }

    public static void buildSessionFactory() {
        sessionFactory = configuration.buildSessionFactory();
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}