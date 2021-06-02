package h01.annotation;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave01 {

	public static void main(String[] args) {
		Student01 std1=new Student01(101,"Ali Can",11);
		Student01 std2=new Student01(102,"Aliye Can",9);
		 
		Configuration con=new  Configuration().configure("hibernate.cfg.xml")
		.addAnnotatedClass(Student01.class);
		
		SessionFactory sf=con.buildSessionFactory();
		Session s1=sf.openSession();
		
		Transaction tx =s1.beginTransaction();
		s1.save(std1);
		s1.save(std2);
		tx.commit();

	}

}
