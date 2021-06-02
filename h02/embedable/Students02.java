package h02.embedable;


	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.Id;
	import javax.persistence.Table;
	import javax.persistence.Transient;
	
	@Entity
	public class Students02  {
		
		@Id
		private int student_id;
		@Column(name="students_name")
		private String name;
		
		private Courses02 course;
		@Column(name="student_grade")
		private int grade;
		
		public Students02()  {
			
		}

		public Students02(int student_id, String name, int grade,Courses02 course) {
			super();
			this.student_id = student_id;
			this.name = name;
			this.course = course;
			this.grade = grade;
		}

		public int getStudent_id() {
			return student_id;
		}

		public void setStudent_id(int student_id) {
			this.student_id = student_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Courses02 getCourse() {
			return course;
		}

		public void setCourse(Courses02 course) {
			this.course = course;
		}

		public int getGrade() {
			return grade;
		}

		public void setGrade(int grade) {
			this.grade = grade;
		}

		@Override
		public String toString() {
			return "Students02 [student_id=" + student_id + ", name=" + name + ", course=" + course + ", grade=" + grade
					+ "]";
		}
		

}
