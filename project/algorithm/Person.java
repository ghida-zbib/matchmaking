package project.algorithm;


public abstract class Person {
	public Person currentFiance;
	protected String name;
	public int[] prefsList; // indices of their preferences, in order, in the input arrays
	public int id;
	
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

	public String getName() {
		return this.name;
	}
}
