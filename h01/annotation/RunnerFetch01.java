package h01.annotation;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch01 {

	public static void main(String[] args) {
		Student01 stdRead=new Student01();
		Configuration con=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
		 SessionFactory sf=con.buildSessionFactory();
		  Session s1=sf.openSession();
		  
		  Transaction tx =s1.beginTransaction();
		  
		  stdRead=s1.get(Student01.class, 102);
		  
		  tx.commit();
		  
		  System.out.println(stdRead.getGrade());
		  
		  

	}

}
