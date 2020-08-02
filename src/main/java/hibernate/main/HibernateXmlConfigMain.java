package hibernate.main;

import java.util.Date;

import org.hibernate.Session;

import hibernate.model.Employee;
import hibernate.util.HibernateUtil;

public class HibernateXmlConfigMain {
    
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("DongVo");
        emp.setRole("CEO");
        emp.setInsertTime(new Date());
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(emp);
        session.getTransaction().commit();
        System.out.println("SUCCESSFULLYY");

        HibernateUtil.getSessionFactory().close();
    }
    
}
