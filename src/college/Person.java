package college;


/**
 * 
 * @author quin
 * @date 06/01/2019
 *
 */
public class Person {
	String name;
	int age;

	//constructor 
	public Person() {	
		
	}
	/**constructor 
	* @param name 
	* @param age
	*/
	public Person(String name, int age) {
		this.name = name;
		this.age = age;

	}
	/**constructor 
	 * @param person
	 */
	public Person(Person person) {
		
	}
	/** An accessor 
	 * 
	 * @param other 
	 * 
	 */

	public boolean equals(Object other) {
		
		return this==other;
	}
	/**
	 * 
	 * @return age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * 
	 * @return name 
	 */
	public String getName() {
		
		return name;
	}
	/**
	 * @return 
	 */
	public String toString() {
		String age = Integer.toString( getAge());
		return "Name: "+ name + "Age: " + age;
	}
	/**
	 * 
	 * @return stat of person 
	 */
	public String printStatus() {
		String stat= "Person";
		return stat;

	}
	public String getFirstName() {
		String [] info = name.split(" ");
		return info[0];
	}
	public String getLastName() {
		String [] info = name.split(" ");
		return info[1];
	}
	public static int compareByAge(Person one, Person two) {
		return one.getAge() - two.getAge();	
	}
	public static int compareByFirstName(Student one, Student two) {
		String s1 = one.getFirstName();
		String s2 = two.getFirstName();
		return s1.compareTo(s2);
	}
	public int compareTo(Student other) {
		String s1 = this.getLastName();
		String s2 = other.getLastName();
		return s1.compareTo(s2);
	}
	
	
	public String toFile() {
		return name+ ", " + age;
			
		}
	
		
	
}


	
	
	

	



