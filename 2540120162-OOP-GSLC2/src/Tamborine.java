
public class Tamborine extends Instrument implements Play { // Child class
	
	public Tamborine(String name, double price) {
		super(name, price);
		
	}
	
	public void showDetails() {
		System.out.println("Name: " +name);
		System.out.println("Type: Tamborine");
		System.out.println("Price: Rp100.000,00");
	}

	public String playInstrument() {
		return "Clap Clap";
	}

}
