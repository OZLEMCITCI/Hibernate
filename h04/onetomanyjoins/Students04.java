package h04.onetomanyjoins;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="students_table")
public class Students04 {
@Id
private int std_id;
@Column (name="std_name")
private String name;
@Column (name="std_grade")
private int grade;
@OneToMany(mappedBy="student", orphanRemoval=true, cascade=CascadeType.ALL)
private List<Books04> bookList=new ArrayList<>();


public Students04() {
	
}

public Students04(int std_id, String name, int grade) {

	this.std_id = std_id;
	this.name = name;
	this.grade = grade;
	
}

public int getStd_id() {
	return std_id;
}

public void setStd_id(int std_id) {
	this.std_id = std_id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getGrade() {
	return grade;
}

public void setGrade(int grade) {
	this.grade = grade;
}

public List<Books04> getBookList() {
	return bookList;
}

public void setBookList(List<Books04> bookList) {
	this.bookList = bookList;
}

@Override
public String toString() {
	return "Students04 [std_id=" + std_id + ", name=" + name + ", grade=" + grade + ", bookList=" + bookList + "]";
}





}
