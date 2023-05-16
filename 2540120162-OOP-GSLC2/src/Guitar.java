
public class Guitar extends Instrument implements Play { // Child class
	
	public Guitar(String name, double price) {
		super(name, price);
	}
	
	public void showDetails() {
		System.out.println("Name: " +name);
		System.out.println("Type: Guitar");
		System.out.println("Price: Rp300.000,00");
	}

	public String playInstrument() {
		return "String String";
	}
}
