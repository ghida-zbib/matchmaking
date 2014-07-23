
public class Person {
	protected Person currentFiance;
	protected String name;
	protected int[] prefsList; // indices of their preferences, in order, in the input arrays
	protected int nextChoice;
	protected int id;
	
	public Person(String name, int id) {
		this.name = name;
		this.id = id;
		nextChoice = 0;
	}
	
	public void setPrefsList(int[] prefsList) {
		this.prefsList = prefsList;
	}
}
