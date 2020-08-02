package hibernate.example;

import java.util.Date;

import org.hibernate.Session;

import hibernate.model.Employee;
import hibernate.util.HibernateUtil;

public class GetAndLoadExample {
    public static void main(String[] args) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        
        Employee emp = new Employee();
        emp.setName("Dong3");
        emp.setRole("ADMIN");
        emp.setInsertTime(new Date());
        
        session.save(emp);
        session.flush();
        
        HibernateUtil.getSessionFactory().close();
    }
}
