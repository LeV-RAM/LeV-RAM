package quizS6no1;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public Main() {
		Address addressA = new Address("StreetA", "CityA", "StateA");
		Address addressB = new Address("StreetB", "CityB", "StateB");
		
		Person personA = new Person("Farrell", 19, addressA);
		Person personB = new Person("John", 34, addressB);
		
		List<Person> persons = new ArrayList<Person>();
		persons.add(personA);
		persons.add(personB);
	
		Employer empA = new Employer("Marvel", "PabrikA", persons);
		
		System.out.println(empA.name+" from "+empA.industry+" industry has "+empA.getTotalPerson()+" employee(s), which are:");
		for(int i=0; i<persons.size(); i++) {
			System.out.println((i+1)+". "+empA.persons.get(i).getName()+", age of "+empA.persons.get(i).getAge()+", from "+empA.persons.get(i).getStreet()+" street, "+empA.persons.get(i).getCity()+", "+empA.persons.get(i).getState());
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
