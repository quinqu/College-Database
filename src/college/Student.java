package college;
/**
 * 
 * @author quin quintero
 * @date 06/01/2019
 *
 */



	public class Student  extends Person{
		
		
			double gpa; 
			Major major;
			Rank rank; 
		/**
		 * constructs new student 
		 * @param name
		 * @param age
		 * @param rank
		 * @param major
		 * @param gpa
		 */
		public Student(String name, int age, Rank rank, Major major, double gpa) {
			this.name = name;
			this.age = age;
			this.rank = rank;
			this.major = major;
			this.gpa= gpa;
		}
		/**
		 * constructs new Student 
		 * @param name
		 * @param age
		 */
		public Student(String name, int age) {
			super(name, age);
			
			
		}
		/**
		 * consturcts student with person 
		 * @param person
		 */
		public Student(Person person) {
		
		}
		/**
		 * constructs student with builder
		 * @param builder
		 */
		public Student (Builder builder) {
			this.age = builder.age;
			this.gpa = builder.gpa;
			this.major = builder.major;
			this.name = builder.name;
			this.rank = builder.rank;
			
		}
		/**
		 * @return boolean
		 */
		public boolean equals(Object other) {
			
			return this.equals(other);
		}
		/**
		 * 
		 * @return GPA
		 */
		public double getGPA() {
			return gpa;
		}
		/**
		 * 
		 * @return rank
		 */
		public Rank getRank() {
			return rank;
		}
		/**
		 * 
		 * @return major
		 */
		public Major getMajor() {
			return major;
		}
		/**
		 * 
		 * @return status of dean list
		 */
		public boolean isOnDeansList() {
			if(getGPA() >= 3.8) {
				return true;
			}
			return false;
			
		}
		/**
		 * 
		 * @return probation status 
		 */
		public boolean isOnProbation() {
			if ( getGPA() < 2.0) {
				return true;
			}
			return false;
		}
		/**
		 * pretty print
		 * @String student stats
		 */
		public String toString() {
			String prettyPrint = "Name:" + name + ", "  + "Age: " + age+ ", "+ "Rank: " + rank + ", " + "Major: " + major+ ", "  + "GPA: " + gpa+ ", " + "Deans List: "+ isOnDeansList()+ ", "+ "On Probation: " + isOnProbation();
			return prettyPrint;
		}
		/**
		 * @return student 
		 */
		public String printStatus() {
			return "Student";
		}
		public static int  compareByGPA(Student s1, Student s2) {
			return (int) (s1.gpa - s2.gpa);
		}
		public String toFile() {
			
				return name+", "+age+ ", "+rank+", "+major+", "+gpa;
			
		}
		
		/**
		 * 
		 * @author quin quintero 
		 * @date 06/01/2019
		 */
		public static class Builder{
			private int age;
			private double gpa;
			private Major major;
			private String name;
			private Rank rank;
			
			public Builder() {
				
			}
			public Builder setAge(int age) {
				this.age =age;
				return this;
			}
			public Builder setGPA(double GPA) {
				this.gpa = GPA;
				return this;
			}
			public Builder setMajor(Major major) {
				this.major = major; 
				return this;
			}
			public Builder setName( String name) {
				this.name = name;
				 return this;
			}
			public Builder setRank(Rank rank) {
				this.rank = rank;
				return this;
			}
			public Student build() {
				Student newBuild = new Student(this);

				return newBuild;
			}
			
			
		}
		
		
	}
 


