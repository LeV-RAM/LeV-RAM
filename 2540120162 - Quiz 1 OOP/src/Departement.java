import java.util.List;

public class Departement {
	String name;
	private List<Student> students;
	
	Departement(String name, List<Student> students){
		this.name = name;
		this.students = students;
	}
	
	public List<Student> getStudents(){
		return students;
	}
	
//	public void setStudents(List<Student> students){
//		this.students = students;
//	}
}
