package h05.manytomanyjoins;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch05 {

public static void main(String[] args) {
		
		Students05 student = new Students05();
		Books05 book = new Books05();
		
		Configuration con = new Configuration().
									configure("hibernate.cfg.xml").
									addAnnotatedClass(Students05.class).
									addAnnotatedClass(Books05.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//1)Fetch the student whose id is 101 by using get()
//		student = session.get(Students05.class, 101);
//		System.out.println(student);
		
		//2)Fetch the book whose id is 11 by using get()
//		book = session.get(Books05.class, 11);
//		System.out.println(book);
		
		//3)Fetch the book whose name is "Art Book". I want to see the owners as well
//		String hql3 = "FROM Books05 WHERE book_name = 'Art Book'";
//		Object rs3 = session.createQuery(hql3).getSingleResult();
//		System.out.println(rs3);
		
		//4)Fetch the student names
//		String hql4 = "SELECT s.name FROM Students05 s";
//		List<String> rs4 = session.createQuery(hql4).getResultList();
//		System.out.println(rs4);
		
		//5)Fetch the book names
//		String hql5 = "SELECT b.book_name FROM Books05 b";
//		List<String> rs5 = session.createQuery(hql5).getResultList();
//		System.out.println(rs5);
		
		//6)Fetch the book name whose id is 11
//		String hql6 = "SELECT b.book_name FROM Books05 b WHERE book_id = 11";
//		String rs6 = (String) session.createQuery(hql6).getSingleResult();
//		System.out.println(rs6);
		
		//7)Fetch the student name, book name whose student id is 101
		String hql7 = "SELECT s.name, b.book_name FROM Students05 s INNER JOIN Books05 b ON s.std_id = 101";
		List<Object[]> rs7 = session.createQuery(hql7).getResultList();
		for(Object[] w:rs7) {
			System.out.println(Arrays.toString(w));
		}
		
		//How to print the "Java Book" on the console.
		System.out.println("=========> " + rs7.get(2)[1]);

		tx.commit();

	}
		

	}


