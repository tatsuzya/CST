package comp1510;

/**
 * Yorkshire.
 * 
 * @author jay
 * @version 1.0
 */
public class Yorkshire extends Dog {
	static int breedWeight = 50;

	public Yorkshire(String name) {
		super(name);
	}

	public String speak() {
		return "woof";
	}

	public int avgBreedWeight() {
		return breedWeight;
	}

}
