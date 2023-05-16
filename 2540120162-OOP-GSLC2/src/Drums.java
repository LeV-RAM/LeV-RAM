
public class Drums extends Instrument implements Play { // Child class
	
	public Drums(String name, double price) {
		super(name, price);
		
	}
	
	public void showDetails() {
		System.out.println("Name: " +name);
		System.out.println("Type: Drums");
		System.out.println("Price: Rp400.000,00");
	}
	
	public String playInstrument() {
		return "Ba Dum Tas....";
	}

}
