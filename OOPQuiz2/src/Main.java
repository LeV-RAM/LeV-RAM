import java.util.Scanner;

class Person{
	public String name;
	public String born_date;
	
	public Person(String name, String born_date) {
		this.name = name;
		this.born_date = born_date;
	}
	
	public void sleep() {
		System.out.println("zzzzz");
	}
	
	public String toString() {
		return("My name is "+name+", I was born in "+born_date+".");
	}
}

class Mahasiswa extends Person{
	public String student_id;
	public int point;
	public Mahasiswa(String name, String born_date, String student_id, int point) {
		super(name, born_date);
		this.student_id = student_id;
		this.point = point;
	}
	
	public void helpingDosen() {
		point += 10;
		System.out.println("I helped a Teacher before and gain 10 points");
	}
	
	public String toString() {
		return(super.toString()+"I am a Student with id: "+student_id+" and "+point+" points.");
	}
	
}

class Dosen extends Person{
	public String code_dosen;
	public int point;
	public Dosen(String name, String born_date, String code_dosen, int point) {
		super(name, born_date);
		this.code_dosen = code_dosen;
		this.point = point;
	}
	
	public void selfDev() {
		System.out.println("I attended a self development program");
		point += 10;
	}
	
	public void teach() {
		System.out.println("I am teaching Math, Biology, and Physics!");
		point+= 20;
	}
	
	public void p2m() {
		System.out.println("This is P2M!");
		point += 5;
	}
	
	public void research() {
		System.out.println("I am researching on Machine Learning!");
		point += 50;
	}
	
	public void otherWorks() {
		System.out.println("I am a gamer!");
		point += 1;
	}
	
	public String toString() {
		return(super.toString()+"I am a Teacher with id: "+code_dosen+" and "+point+" points.");
	}
}
public class Main {
	Scanner scan = new Scanner(System.in);
	Person man1 = new Person("Marvel", "5 Maret 2003");
	Mahasiswa sis1 = new Mahasiswa("Marvel", "5 Maret 2003", "2540120162", 0);
	Dosen dos1 = new Dosen("Andreas", "1 Januari 1998", "123456789", 100);
	
	public Main() {
		int choice;
		do {
			System.out.println("Choose your Class!");
			System.out.println("1. Person");
			System.out.println("2. Mahasiswa");
			System.out.println("3. Dosen");
			System.out.println("4. Exit");
			choice = scan.nextInt();
			scan.nextLine();
			switch (choice) {
			case 1:
				System.out.println(man1.toString());
				man1.sleep();
				break;
			case 2:
				System.out.println(sis1.toString());
				sis1.helpingDosen();
				System.out.println(sis1.toString());
				break;
			case 3:
				System.out.println(dos1.toString());
				dos1.selfDev();
				dos1.teach();
				dos1.p2m();
				dos1.research();
				dos1.otherWorks();
				System.out.println("Total points: "+dos1.point+" points.");
				break;
			case 4:
				System.out.println("Thank you for using our service!");
				break;
			default:
				System.out.println("Wrong Choice!");
				break;

			}
			System.out.println();
		} while (choice != 4);
	}

	public static void main(String[] args) {
		new Main();
	}

}
