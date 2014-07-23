
public class Person {
	protected Person currentFiance;
	protected String name;
	protected int[] prefsList; // indices of their preferences, in order, in the input arrays
	protected int nextChoice;
	protected int id;
	
	public Person(String name) {
		this.name = name;
		nextChoice = 0;
	}
}
