
public abstract class Person {
	protected Person currentFiance;
	protected String name;
	protected int[] prefsList; // indices of their preferences, in order, in the input arrays
	protected int id;
	
	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public void initializeFiance() {
		this.currentFiance = new Nobody();
	}
	
	public void setPrefsList(int[] prefs) {
		this.prefsList = prefs;
	}
}
