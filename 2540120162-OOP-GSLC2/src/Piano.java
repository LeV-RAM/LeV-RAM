
public class Piano extends Instrument implements Play{ // Child class
	
	public Piano(String name, double price) {
		super(name, price);
	}
	
	public void showDetails() {
		System.out.println("Name: " +name);
		System.out.println("Type: Piano");
		System.out.println("Price: Rp500.000,00");
	}

	public String playInstrument() {
		return "Cling Cling";
	}
}
