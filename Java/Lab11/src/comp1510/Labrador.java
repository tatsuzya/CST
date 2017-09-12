package comp1510;

/**
 * Labrador.
 * 
 * @author jay
 * @version 1.0
 */
public class Labrador extends Dog {

	private String color;
	private static int breedWeight = 75;

	public Labrador(String name, String color) {
		super(name);
		this.color = color;
	}

	public String speak() {
		return "WOOF";
	}

	public int avgBreedWeight() {
		return breedWeight;
	}

}
