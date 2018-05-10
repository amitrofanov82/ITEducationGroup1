import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.simple.contact.entity.Address;
import com.simple.contact.entity.Contact;

public class HibernateUser {

	public static void main(String[] args) {
		Session hibernateSession;
		
        Configuration configuration = new Configuration();
        configuration.configure("hibernate_sp.cfg.xml");
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Contact.class);
        StandardServiceRegistryBuilder ssrb = 
        		new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sessionFactory = configuration.buildSessionFactory(ssrb.build());
        System.out.println("Before session Opening");
        hibernateSession = sessionFactory.openSession();
        System.out.println("Session Opened");
        
        Contact c = new Contact();
        c.setEmail("me@ma");
        c.setName("V.P.");
        c.setAddress(new Address());
        c.getAddress().setStreetAndHouse("T.8");
        
        Transaction t = hibernateSession.beginTransaction();
        hibernateSession.save(c.getAddress());
        hibernateSession.save(c);
        t.commit();
        
        
        hibernateSession.close();
        sessionFactory.close();
        
		
        
		
		
		
		//EntityManager
	}

}
