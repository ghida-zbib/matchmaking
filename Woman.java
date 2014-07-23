import java.util.ArrayList;

public class Woman extends Person {
	ArrayList<Person> proposals = new ArrayList<Person>();
	
	public Woman(String name, int id) {
		super(name, id);
		proposals = new ArrayList<Person>();
	}
}
