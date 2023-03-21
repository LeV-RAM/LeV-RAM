package quizS6no2;

import java.util.ArrayList;

public class Main {
	ArrayList<String> empName = new ArrayList<String>();
	ArrayList<String> empIndustry = new ArrayList<String>();
	ArrayList<String> personName = new ArrayList<String>();
	ArrayList<Integer> personAge = new ArrayList<Integer>();
	ArrayList<String> addStreet = new ArrayList<String>();
	ArrayList<String> addState = new ArrayList<String>();
	ArrayList<String> addCity = new ArrayList<String>();
	
	public Main() {
		//Employee A
		//Person A
		empName.add("Marvel");
		empIndustry.add("PabrikA");
		personName.add("Farrell");
		personAge.add(19);
		addStreet.add("StreetA");
		addState.add("StateA");
		addCity.add("CityA");
		
		//Person B
		empName.add("Marvel");
		empIndustry.add("PabrikA");
		personName.add("John");
		personAge.add(34);
		addStreet.add("StreetB");
		addState.add("StateB");
		addCity.add("CityB");
		
		//Output
		for(int i=0; i<empName.size(); i++) {
			System.out.println("Employer Name: "+empName.get(i));
			System.out.println("Employer Industry: "+empIndustry.get(i));
			System.out.println("Employee Name: "+personName.get(i));
			System.out.println("Employee Age: "+personAge.get(i));
			System.out.println("Employee Address: "+addStreet.get(i)+" street, "+addCity.get(i)+", "+addState.get(i));
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
