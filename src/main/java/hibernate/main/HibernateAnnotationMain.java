package hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import hibernate.model.EmployeeAnotation;
import hibernate.util.HibernateAnnotationUtil;

public class HibernateAnnotationMain {
    
    public static void main(String[] args) {
        EmployeeAnotation emp = new EmployeeAnotation();
        emp.setName("Dong1");
        emp.setRole("DEVELOPER");
        emp.setInsertTime(new Date());
        
        Session session = HibernateAnnotationUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(emp);
        session.getTransaction().commit();
        HibernateAnnotationUtil.getSessionFactory().close();
    }
    
}
