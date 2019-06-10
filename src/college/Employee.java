package college;

import java.text.DecimalFormat;
/**
 * 
 * @author quin
 * @date 06/01/2019
 */
public class Employee  extends Person{
		
		
		private String office;
		private double salary;
		private double years;
		/**
		 * constructs new employee with following parameters
		 * @param name
		 * @param age
		 * @param office
		 * @param salary
		 * @param years
		 */
		
		public Employee(String name, int age, String office, double salary, double years){
			
		}
		/**
		 * constructs new employee with following parameters
		 * @param person
		 * @param office
		 * @param salary
		 * @param years
		 */
		public Employee( Person person, String office, double salary, double years) {
			
		}
		/**
		 * constructs new person with builder class
		 * @param builder
		 */
		public Employee(Builder builder) {
			this.office = builder.office; 
			this.salary = builder.salary;
			this.years = builder.years;
		}
		/**
		 *  compares two employees
		 *  @return boolean
		 */
		public boolean equals (Object ob) {
			if (this.equals(ob)) {
				return true;
			}else {
			return false; 
		}
		}
		/**
		 * 
		 * @return office 
		 */
		public String getOffice() {
			return office;
			
		}
		/**
		 * 
		 * @return salary 
		 */
		public double getSalary() {
			return salary;
		}
		/**
		 * 
		 * @return years
		 */
		public double getYears() {
			return years;
		}
		/**
		 * 
		 * @return payment each month
		 */
		public double payments() {
			return salary/24.0;
		}
		/**
		 * @return String
		 */
		public String toString() {
			
		DecimalFormat f = new DecimalFormat("0.00");
		
			
		String prettyPrint = "Name:" + name + ", "  + "Age: " + age+ ", "+ "office: " + office + ", " + "Salary: " + salary+ ", "  + "Years: " + years; 
		return prettyPrint; 
		}
		public String toStatus() {
			return "Employee";
		}
		public static int compareSalary(Employee e1, Employee e2) {
			return (int) (e1.salary - e2.salary);
		}
		public static int compareYears(Employee e1, Employee e2) {
			return (int) (e1.years - e2.years);
		}
		
		
		public String toFile() {
			return name+", "+age+ ", "+office+", "+salary+", "+years;
		}
		public static class Builder{

			private String office;
			private double salary;
			private int age;
			private String name;
			private double years;
			
			
			public Builder() {
				
			}
			public Builder setAge(int age) {
				this.age = age;
				return this;
			}
			
			
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		public Builder setOffice (String office) {
			this.office = office;
			return this;
		}
		public Builder setSalary(double salary) {
			this.salary = salary;
			return this;
			
		}
		public Builder setYears(double years) {
			this.years  = years;
			return this;
		}
		public Employee build() {
			Employee newEmp =new Employee(this);
			return newEmp;
		}
	}
}


