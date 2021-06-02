package h03.onetoonejoins;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import h02.embedable.Students02;

public class RunnerSave03 {

	public static void main(String[] args) {
		Dairy d1= new Dairy(11,"first dairy");
		Dairy d2= new Dairy(12,"second dairy");
		Dairy d3= new Dairy(13,"Third dairy");
		
		
		Students03 student1=new Students03(101,"aLI cAN",11,d1);
		Students03 student2=new Students03(102,"velihan",11,d2);
		Students03 student3=new Students03(103,"AyseTan",11,d3);
		
		d1.setStudent(student1);
		d2.setStudent(student2);
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Students03.class).addAnnotatedClass(Dairy.class);
		SessionFactory sf = con.buildSessionFactory();
		Session session = sf.openSession();
				
		Transaction tx = session.beginTransaction();
		
		session.save(d1);
		session.save(d2);
		session.save(d3);
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
        tx.commit();
	}

}
