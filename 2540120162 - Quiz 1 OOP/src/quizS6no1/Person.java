package quizS6no1;

import java.util.List;

public class Person {
	String name;
	int age;
	private Address address;
	
	Person(String name, int age, Address address){
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public String getName(){
		return name;
	}
	
	public int getAge(){
		return age;
	}
	
	public String getStreet(){
		return address.street;
	}
	
	public String getState(){
		return address.state;
	}
	
	public String getCity(){
		return address.city;
	}
}
