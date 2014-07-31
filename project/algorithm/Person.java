package project.algorithm;


public abstract class Person {
	private Person currentFiance;
	protected String name;
	private int[] prefsList; // indices of their preferences, in order, in the input arrays
	private int id;
	
	public Person(String name, int id) {
		this.name = name;
		this.id = id;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void initializeFiance() {
		this.currentFiance = new Nobody();
	}
	
	public Person getCurrentFiance() {
		return this.currentFiance;
	}
	
	public void setCurrentFiance(Person fiance) {
		this.currentFiance = fiance;
	}
	
	public int[] getPrefsList() {
		return this.prefsList;
	}
	
	public void setPrefsList(int[] prefs) {
		this.prefsList = prefs;
	}

	public String getName() {
		return this.name;
	}
}
