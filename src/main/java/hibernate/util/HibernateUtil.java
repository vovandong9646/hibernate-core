package hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    
    private static SessionFactory sessionFactory;
    
    private static SessionFactory buildSessionFactory() {
        Configuration config = new Configuration();
        config.configure("hibernate_xml.cfg.xml");
        ServiceRegistry service = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();
        SessionFactory sessionFactory = config.buildSessionFactory(service);
        return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }
}
