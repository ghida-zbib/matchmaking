package project.algorithm;
import java.util.ArrayList;

public class Woman extends Person {
	ArrayList<Man> proposals = new ArrayList<Man>();
	
	public Woman(String name, int id) {
		super(name, id);
		proposals = new ArrayList<Man>();
	}
}
