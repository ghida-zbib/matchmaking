
public class Man extends Person {
	
	protected int nextChoice;
	boolean exhausted;
	
	public Man(String name, int id) {
		super(name, id);
		nextChoice = 0;
	}
}
