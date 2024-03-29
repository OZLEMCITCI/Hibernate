package h04.onetomanyjoins;

import java.net.MulticastSocket;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {

	public static void main(String[] args) {
		
		Students04 student = new Students04();
		Books04 book = new Books04();

		Configuration con = new Configuration().
								configure("hibernate.cfg.xml").
								addAnnotatedClass(Students04.class).
								addAnnotatedClass(Books04.class);

		SessionFactory sf = con.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();
		
		//1: Fetch all books of a student whose id is 101 by using get() method
//		student = session.get(Students04.class, 101);
//		for(Books04 w : student.getBooksList()) {
//			System.out.println(w);
//		}
		
		//2: Fetch the owner of a book whose id is 11 by using get() method
//		book = session.get(Books04.class, 11);
//		student = session.get(Students04.class, book.getStudent().getStd_id());
//		System.out.println(student);
		
		//3: Fetch student name, book name of common records from Students04 and Books04 tables (INNER JOIN)
		//1.Way: SQL Query
		//In SQL, you can use createSQLQuery() or createNativeQuery(). Both work. But In HQL you should use createQuery()
//		String sqlQuery1 = "SELECT s.std_name, b.book_name \n"
//							+ "FROM students_table s INNER JOIN books_table b\n"
//							+ "ON s.std_id = b.std_id";
//		
//		List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
//		for(Object[] w : resultList1) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//2.Way: HQL Query
//		String hqlQuery1 = "SELECT s.name, b.book_name "
//				+ "FROM Students04 s INNER JOIN Books04 b "
//				+ "ON s.std_id = b.student";
//		List<Object[]> resultList2 = session.createQuery(hqlQuery1).getResultList();
//		for(Object[] w : resultList2) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//4:Fetch student name, book name of all records from Students04 and Books04 table (FULL JOIN)
		//1:SQL Query
//		String sqlQuery2 = "SELECT s.std_name, b.book_name FROM students_table s FULL JOIN books_table b ON s.std_id = b.std_id";
//		List<Object[]> resultList3 = session.createSQLQuery(sqlQuery2).getResultList();
//		for(Object[] w : resultList3) {
//			System.out.println(Arrays.toString(w));
//		}
		
		//1:HQL Query
//		String hqlQuery2 = "SELECT s.name, b.book_name FROM Students04 s FULL JOIN Books04 b ON s.std_id = b.student";
//		List<Object[]> resultList4 = session.createQuery(hqlQuery2).getResultList();
//		for(Object[] w : resultList4) {
//		System.out.println(Arrays.toString(w));
//	    }
		
		//How to delete all records from a table
		
		//5: Delete all records from child table
		//1:SQL Query
//		String sqlQuery3 = "DELETE FROM books_table";
//		int numOfDeletedRecs1 = session.createSQLQuery(sqlQuery3).executeUpdate();
//		System.out.println(numOfDeletedRecs1 + " records are deleted");
		
		
		
		
		//6: Delete all records from parent table
		/*
		 	Note: If a table has child table, you cannot delete records from parent table.
		 	If you insist to delete records from parent table you have 2 options;
		 	a)Delete child records first then delete parent records.
		 	b)By using annotation we can tell to Hibernate like;
		 	  If I delete parent delete child
		 */
		//1:SQL Query
		//a)Delete child records first then delete parent records.
//		String sqlQuery3 = "DELETE FROM books_table";
//		int numOfDeletedRecs1 = session.createSQLQuery(sqlQuery3).executeUpdate();
//		System.out.println(numOfDeletedRecs1 + " records are deleted");
//		
//		String sqlQuery4 = "DELETE FROM students_table";
//		int numOfDeletedRecs2 = session.createSQLQuery(sqlQuery4).executeUpdate();
//		System.out.println(numOfDeletedRecs2 + " records are deleted");
		
		//b)By using annotation we can tell to Hibernate like;
//		student = session.get(Students04.class, 101);
//		session.delete(student);
//		
//		book=session.get(Books04.class,13);
//		session.delete(book);
//		session.delete("Books04",book );//2. way deleting data from table
		
		int max= Integer.MAX_VALUE;
		
		String hqlQuery="FROM Students04 WHERE std_id <"+max;
		
		List<Students04>resultList=session.createQuery(hqlQuery).getResultList();
		
		for (Students04 w: resultList ) {
			session.delete(session.get(Students04.class,w.getStd_id()));
		}
		
		//How to update data by using Hibernate
		
		//7:Update the name the student whose id is 11 to Mark Stone 
		
		String hql6="Update s.name from Students04 set s.name='Mark Stone' where s.std_id=11";
		int numberofUpdatedRec6=session.createQuery(hql6).executeUpdate();
		
		System.out.println("number of update rows"+ numberofUpdatedRec6);
		
		
		//8:Update the grades of students to 12 whose grade are grader than 8.
		String hql7="Update Students04 s set s.grade=12 where a.grade>8";
		int numberofUpdatedRec8=session.createQuery(hql7).executeUpdate();
		System.out.println("number of update rows"+ numberofUpdatedRec8);
		
		
		tx.commit();
		session.close();
		
	
	
	
	
	}

  
  
  
  
  
  
  
  
  
  
  


}
