package hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import hibernate.model.EmployeeAnotation;
import hibernate.util.HibernateJavaConfigUtil;

public class HibernateJavaConfigMain {
    public static void main(String[] args) {
        EmployeeAnotation emp = new EmployeeAnotation();
        emp.setName("Dong2");
        emp.setRole("DEVELOPER");
        emp.setInsertTime(new Date());
        
        Session session = HibernateJavaConfigUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(emp);
        session.getTransaction().commit();
        HibernateJavaConfigUtil.getSessionFactory().close();
    }
}
