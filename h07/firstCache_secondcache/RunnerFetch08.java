package h07.firstCache_secondcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {

	public static void main(String[] args) {
Books07 book = new Books07();
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Students07.class).addAnnotatedClass(Books07.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session1 = sf.openSession();
		Transaction tx1 = session1.beginTransaction();
		tx1.commit();
	}

}
