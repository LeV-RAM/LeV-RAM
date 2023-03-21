package quizS6no1;

import java.util.List;

public class Employer {
	String name;
	String industry;
	List<Person> persons;
	
	Employer(String name, String industry, List<Person> persons){
		this.name = name;
		this.industry = industry;
		this.persons = persons;
	}
	
	public List<Person> getPersons(){
		return persons;
	}
	
	public int getTotalPerson(){
		int noOfPersons = 0;
		
		for(Person p: persons) {
			noOfPersons++;
		}
		
		return noOfPersons;
	}

}
