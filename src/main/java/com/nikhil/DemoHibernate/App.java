package com.nikhil.DemoHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        Alien nik=new Alien();
        nik.setAid(10);
        nik.setAname("Nikhil Kumar Rana");
        nik.setColor("black");
        
        Configuration con=new Configuration();
        SessionFactory sf=con.buildSessionFactory();
        Session session=sf.openSession();
        session.save(nik);
    }
}
