package comp1510;

/**
 * DogTest.
 * 
 * @author jay
 * @version 1.0
 */
public class DogTest {
	/**
	 * Drives the program.
	 * 
	 * @param args
	 *            command line argument
	 */
	public static void main(String[] args) {
		Labrador dog1 = new Labrador("Bill", "Brown");
		System.out.println(dog1.getName() + " says " + dog1.speak());
		Yorkshire dog2 = new Yorkshire("Sam");
		System.out.println(dog2.getName() + " says " + dog2.speak());
		System.out.println("Average weight for Labrador is " + dog1.avgBreedWeight());
		System.out.println("Average weight for Yorkshire is " + dog2.avgBreedWeight());
	}
}
