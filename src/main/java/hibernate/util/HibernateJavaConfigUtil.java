package hibernate.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import hibernate.model.EmployeeAnotation;

public class HibernateJavaConfigUtil {

    private static SessionFactory sessionFactory;

    private static SessionFactory buildSessionFactory() {
        Configuration config = new Configuration();
        Properties prop = new Properties();
        prop.put("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
        prop.put("hibernate.connection.url",
                "jdbc:mysql://localhost:3306/hibernate_core01");
        prop.put("hibernate.connection.username", "root");
        prop.put("hibernate.connection.password", "");
        // có cái dòng current_session_context_class này thì mới gọi được getCurrentSession();
        prop.put("hibernate.current_session_context_class", "thread");
        config.addProperties(prop);

        // add mapping class
        config.addAnnotatedClass(EmployeeAnotation.class);

        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(config.getProperties()).build();

        return config.buildSessionFactory(serviceRegistry);
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

}
