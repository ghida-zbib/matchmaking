import java.util.ArrayList;

public class Woman extends Person {
	ArrayList<Person> proposals = new ArrayList<Person>();
	
	public Woman(String name) {
		super(name);
		proposals = new ArrayList<Person>();
	}
}
