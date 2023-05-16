import java.util.ArrayList;
import java.util.Scanner;

/* Abstract vs Interface
 * A class can only inheret (extend) one abstract class, but can inheret (implement) multiple interfaces
 * An abstract class has method implementations, while an interface has methods which can only be implemented by classes which inherets the interface
 * An abstract class has contructors to be declared, while an interface cannot
 * An abstract class is used when there are classes with similar structures and implementations, while an interface is utilized for polymorphism (methods can be used for several classes)
 */

public class Main { // This is a program to add, show, play, and purchase music intrusments
	Scanner scan = new Scanner(System.in);
	ArrayList<Instrument> catalog = new ArrayList<Instrument>(); // Lists of instruments
	double money = 1000000; // Money owned to limit purchases, you can change the amount manually if wanted
	public Main() {
		int menu;
		
		do {
			System.out.println("MUSIC INSTRUMENT SHOP");
			System.out.printf("Currency: Rp%.2f\n", money);
			System.out.println("1. Add Instrument");
			System.out.println("2. Show Catalog");
			System.out.println("3. Buy Instrument");
			System.out.println("4. Exit");
			menu = scan.nextInt();
			scan.nextLine();
			switch (menu) {
			case 1:
				addInst(); // Adding instruments to the catalog
				break;
			case 2:
				showInst(); // Show all instruments on the catalog, with the ability to play any of them
				break;
			case 3:
				buyInst(); // Purchase instruments from the catalog
				break;
			case 4:
				System.out.println("Thank you for using our services!");
				break;
			}
		} while (menu != 4);
		
	}
	
	public void addInst() { // Prices are determined beforehand (Assumed prices)
		Instrument inst = null;
		String instName;
		String instType;
		System.out.print("Input instrument name: ");
		instName = scan.nextLine();
		do {
			System.out.print("Input instrument type [Piano | Guitar | Drums | Flute | Violin]: "); // There are 5 types of instruments (5 classes) which is part of the Instrument class (parent)
			instType = scan.nextLine();
		} while (!(instType.equals("Piano") || instType.equals("Guitar") || instType.equals("Drums") || instType.equals("Flute") || instType.equals("Violin")));
		
		if(instType.equals("Piano")) {
			inst = new Piano(instName, 500000);
		}else if(instType.equals("Guitar")) {
			inst = new Guitar(instName, 300000);
		}else if(instType.equals("Drums")) {
			inst = new Drums(instName, 400000);
		}else if(instType.equals("Flute")) {
			inst = new Flute(instName, 200000);
		}else if(instType.equals("Violin")) {
			inst = new Tamborine(instName, 100000);
		}
		
		catalog.add(inst);
		System.out.println("Instrument added!");
		scan.nextLine();
	}
	
	public void showInst() { // Shows all available instruments
		if(catalog.size() == 0) {
			System.out.println("Sold Out");
			scan.nextLine();
			return;
		}
		
		int q;
		String q2;
		do {
			System.out.println("\nInstrument Catalog");
			for (int i = 0; i < catalog.size(); i++) {
				System.out.println((i + 1) + ". " + catalog.get(i).name);
			}
			System.out.print("Select instrument from catalog [Type '0' to return]: ");
			q = scan.nextInt(); scan.nextLine();
			if(q == 0) {
				return;
			}
			catalog.get(q - 1).showDetails(); // Show the selected instrument details
			
			System.out.print("Play Instrument? [Yes/No] "); // Play the sound of the selected instrument
			q2 = scan.nextLine();	
			
			switch (q2) {
				case "Yes":
					String empty;
					System.out.println("Please type 'STOP' if done playing!");
					do {
						System.out.println(((Play) catalog.get(q - 1)).playInstrument()); // Interface and Abstract concept
						empty = scan.nextLine();
					} while (!empty.equals("STOP"));
					break;
				case "No":
					break;
			}
		} while (q != 0);
	}
	
	public void buyInst() { // Buy an instrument from the catalog
		if(catalog.size() == 0) {
			System.out.println("Sold Out");
			scan.nextLine();
			return;
		}
		
		int q;
		System.out.println("Instrument Catalog");
		for (int i = 0; i < catalog.size(); i++) {
			System.out.println((i + 1) + ". " + catalog.get(i).name);
		}
		System.out.print("Select instrument from catalog: ");
		q = scan.nextInt(); scan.nextLine();
		
		if(catalog.get(q - 1).price > money) { // Purchase cancelled if not enough currency
			System.out.println("Not Enough Money!");
		}else {
			money -= catalog.get(q - 1).price;
			System.out.println("Instrument purchased!");
			System.out.printf("Paid: Rp%.2f\n", catalog.get(q - 1).price);
			System.out.printf("Change: Rp%.2f\n", money);
			catalog.remove(q - 1);
		}
		
		scan.nextLine();
	}

	public static void main(String[] args) {
		new Main();
	}

}
