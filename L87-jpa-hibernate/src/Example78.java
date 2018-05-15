import java.util.Map;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import de.vogella.jpa.eclipselink.model.Person;

public class Example78 {

	public static void main(String[] args) {
		String punitName = "shag";
		// Map props = null;
		// Persistence
		// .createEntityManagerFactory(punitName, props);
		EntityManagerFactory emFact = Persistence.createEntityManagerFactory(punitName);
		EntityManager em = emFact.createEntityManager();

		// System.out.println(em.getClass());

		Query q = em.createQuery("delete from Person p where p.lastName = :name");
		q.setParameter("name", "mitrofanov");
		EntityTransaction trans = em.getTransaction();
		trans.begin(); //SQL: BEGIN TRANSACTION ... 
		q.executeUpdate();
		for (int i = 0; i<10; i++){
			Person p = new Person();
			p.setFirstName("Alexey " + Math.random());
			em.persist(p);
		}


		//query("снять деньги у Васи")
		//query("зачислить деньги Маше")
		//if (всёХорошо) {
		//   trans.commit(); //SQL COMMIT TRANNSACTION
		//} else {
		//   trans.rollback(); //SQL...
		// }
		trans.commit();
		
		em.close();
		emFact.close();
		

	}

}
