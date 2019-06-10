package database;


import java.io.IOException;

import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import college.Person;
import college.Rank;
import college.Student;
import lists.ArrayList;
import college.Employee;
import college.Major;
import utility.List;
/**
 * this class manages the file I/O of a student ArrayList object 
 * @author quin quintero
 * @date 6/10/2019
 */

@SuppressWarnings("unused")
public class DataStorage {
private String file;
/**
 * constructor 
 * @param filePath
 * @throws IOException
 */

public DataStorage(String filePath) throws IOException {
	String[] fname = filePath.split("/");
	filePath = "";
	for(int i = 0; i < fname.length-1; i++) {
		filePath+= fname[i] + File.separator;
	}
	filePath+=fname[fname.length-1];
	this.file = filePath;
	this.setFile();
}
/**
 * set the file location to be read or written to 
 * @throws IOException
 */

private void setFile() throws IOException{
	File fileWriter = null;
	try {
		fileWriter = new File(this.file);
		System.out.println("Successfully found/created file! yeet (DataStorage Class set file method )");
		}catch (Exception e){
		System.out.println(e);
		System.out.println("Error: Unable to create/find to file (DataStorage Class set file method)");	
	}
}
/**
 * returns an object that is compatible with the Person object
 * @param line
 * @return
 * @throws IllegalArgumentException
 */
	public Person parse(String line) throws IllegalArgumentException{
		
		String[] info = line.split(",");
		Person newPerson = null;
		String name = info[0];
		int age = Integer.parseInt(info[1]);
		//conditionals to see if it's a student or employee 
		
		if((info[3].charAt(1) >= 'A' && info[3].charAt(1) <= 'Z' )|| (info[3].charAt(1) >= 'a' && info[3].charAt(1) <= 'z')) {
			Rank rank = Rank.valueOf(info[2]);
			Major major = Major.valueOf(info[3].replaceAll(" ", ""));
			Double gpa = Double.parseDouble(info[4]);
			newPerson = new Student(name, age, rank, major, gpa);
			
			}else {
			
			String office = info[2];
			Double salary = Double.parseDouble(info[3]);
			Double years = Double.parseDouble(info[4]);
			newPerson = new Employee(name, age, office, salary, years);
			}
		
		return newPerson;
	}
	
	/**
	 * writes a file of students who are on probation
	 * @param data
	 * @throws IOException
	 */
	public void filterProbation(List<Person> data) throws IOException{
		
		List<Person> newList = new ArrayList<Person>();
	 	int i =0;
    	while(i<data.size()){
    		if(((Student) data.get(i)).getGPA() < 2.0){
    		
    		newList.add(data.get(i)); //object student
    		i++;
    		}
    	}
    	write(newList);
    }
	/**
	 * writes a file of students who are on the dean's list
	 * @param data
	 * @throws IOException
	 */
    	public void filterDeansList(List<Person> data) throws IOException {
    		
    		List<Person> newList = new ArrayList<Person>();
    	 	int i =0;
        	while(i<data.size()){
        		if(((Student) data.get(i)).isOnDeansList() ==true){
        		newList.add(data.get(i)); 
        		i++;
        		}
        	}
        	write(newList);
    	}
    	
    	/**
    	 * writes a file of employees who have been working at the college for 20 years or more
    	 * @param data
    	 * @throws IOException
    	 */
        	public void filterService(List<Person> data) throws IOException {
        		List<Person> newList = new ArrayList<Person>();
        	 	int i =0;
            	while(i<data.size()){
            		if(((Employee) data.get(i)).getYears() >= 20.0 ) {
            			newList.add(data.get(i));
            		i++;
            		}
            	}
            	write(newList);
        	}
        	/**
        	 * reads contents of a comma separated database file
        	 * @return
        	 * @throws IOException
        	 */
        	public List<Person> read() throws IOException{
        		List<Person> returnedList = new ArrayList<Person>();
        		File file = new File(this.file);
        		Scanner input = new Scanner(file);
        		while(input.hasNextLine()) {
        			String line = input.nextLine();
        			returnedList.add(parse(line));
        		}
        		input.close();
        		return returnedList;
        		
        	}
        	
        	/**
        	 * writes contents of a database element to a file
        	 * @param data
        	 * @throws IOException
        	 */
        	
        	public void write(List<Person> data) throws IOException{
        		PrintStream writer = null;
        	
    			try {
    				writer = new PrintStream(this.file);
    				 for(int i = 0; i < data.size(); i++) {
    	        			writer.println(data.get(i).toString());
    	        		}
    				writer.close();
    				System.out.println("Successfully written to file (this is in the Data Class, write method)");	

    				}catch (Exception e){
    				System.out.println(e);
    				System.out.println("Error: Unable to write to file (this is in the Data Class, write method)");	
    			}
        	}
        	/**
        	 * writes the contents of a database element to file in comma separated format
        	 * @param data
        	 * @throws IOException
        	 */
        	
        	public void writeCS(List<Person> data)throws IOException{
        		PrintStream writer = null;
            	
    			try {
    				writer = new PrintStream(this.file);
    				 for(int i = 0; i < data.size(); i++) {
    	        			writer.println(data.get(i).toFile());
    	        		}
    				writer.close();
    				System.out.println("Successfully written to file (this is in the Data Class, write method)");	

    				}catch (Exception e){
    				System.out.println(e);
    				System.out.println("Error: Unable to write to file (this is in the Data Class, write method)");	
    			}
        		
        	}
        	
    	}


	
	




