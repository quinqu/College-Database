package college;
import database.DataStorage;
import lists.ArrayList;
import utility.List;

import java.io.IOException;

/**
 * @date 06/01/2019
 * @author quin quintero
 *
 */
public class DepartmentClient {
	public static void main(String[] args) throws IOException {
	List<Person> list = new ArrayList<Person>();	
	Student s = new Student("Quin", 19, Rank.Sophomore, Major.ComputerScience , 4.0);
	Student litStudent = new Student("jake", 22, Rank.Senior, Major.Physics , 4.0);
	Employee e1 = new Employee ("Name", 43, "STEM 220", 50000.0, 4.5);
	list.add(e1);
	list.add(s);
	list.add(litStudent);
	DataStorage file = new DataStorage("College.txt");
	List<Person> readingPeople = file.read();
	System.out.println(readingPeople.toString());
	
	}
	


}
