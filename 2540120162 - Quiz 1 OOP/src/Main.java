import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Student s1 = new Student("Mia", 1, "CS");
		Student s2 = new Student("Priya", 2, "CS");
		Student s3 = new Student("Priya", 3, "GAT");
		Student s4 = new Student("Priya", 4, "GAT");
		Student s5 = new Student("Priya", 5, "GAT");
		
		List<Student> cs_students = new ArrayList<Student>();
		cs_students.add(s1);
		cs_students.add(s2);
		
		
		System.out.println(cs_students);
		
		List<Student> gat_students = new ArrayList<Student>();
		gat_students.add(s3);
		gat_students.add(s4);
		gat_students.add(s5);
		
		System.out.println(gat_students);
		
		Departement CS = new Departement("CS", cs_students);
		Departement GAT = new Departement("GAT", gat_students);
		
		List<Departement> departements = new ArrayList<Departement>();
		departements.add(CS);
		departements.add(GAT);
		
		Institute institute = new Institute("SUNIB", departements);
		System.out.println("Total students in institute: "  +institute.getTotalStudentInstitute());
		
	}
	
	
	
}
