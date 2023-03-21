import java.util.List;

public class Institute {
	String InstituteName;
	private List<Departement> departements;
	
	Institute(String InstituteName, List<Departement> departements){
		this.InstituteName = InstituteName;
		this.departements = departements;
	}
	
	public int getTotalStudentInstitute(){
		int noOfStudents = 0;
		List<Student> students;
		
		for(Departement dept: departements) {
			students = dept.getStudents();
			for(Student s: students) {
				noOfStudents++;
			}
		}
		
		return noOfStudents;
	}
	
}
