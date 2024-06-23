package com.nikhil.DemoHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
public class App 
{
    public static void main( String[] args )
    {
        Alien nik=new Alien();
        
        nik.setAid(12);
        nik.setAname("anamika");
        nik.setColor("blue");
        
        
        Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class); //By default file ka name yehi hota hai ,to do ya mtt do file name do it's your choice but in case of different file name ,it is mandatory to specify the name of the file 
        //ServiceRegistry is a Interface ,we can't create its object 
        ServiceRegistry reg=new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sf=con.buildSessionFactory(reg);
        Session session=sf.openSession();
        Transaction tx=session.beginTransaction();
        session.save(nik);
        tx.commit();
    }
}
