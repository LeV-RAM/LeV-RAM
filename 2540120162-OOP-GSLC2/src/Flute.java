
public class Flute extends Instrument implements Play { // Child class
	
	public Flute(String name, double price) {
		super(name, price);
		
	}
	
	public void showDetails() {
		System.out.println("Name: " +name);
		System.out.println("Type: Flute");
		System.out.println("Price: Rp200.000,00");
	}
	
	public String playInstrument() {
		return "*Wistle Noises Playing*";
	}

}
