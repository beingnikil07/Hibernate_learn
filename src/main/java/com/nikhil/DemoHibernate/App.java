package com.nikhil.DemoHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Alien nik=new Alien();
        nik.setAid(10);
        nik.setAname("Nikhil Kumar Rana");
        nik.setColor("black");
        
        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class); //By default file ka name yehi hota hai ,to do ya mtt do file name do it's your choice but in case of different file name ,it is mandatory to specify the name of the file 
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        session.save(nik);
        tx.commit();
    }
}
