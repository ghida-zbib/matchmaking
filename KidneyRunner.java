import java.io.FileNotFoundException;
import java.util.ArrayList;


public class KidneyRunner {

	private ArrayList<ArrayList<KCIPerson>> split(ArrayList<KCIPerson> people) {
		// split into half donors, half recipients
		// (TODO)
		return new ArrayList<ArrayList<KCIPerson>>();
	}
	
	public void runFromCSV(String filename) {
		int highestId = 1;
		ArrayList<KCIPerson> people = new ArrayList<KCIPerson>();
		
		try {
			ResponseSet rs = new ResponseSet(filename);
			for(int i = 0; i < rs.getResponses().size(); i++) {
				Response response = rs.getResponses().get(i);
				KCIPerson kci = new KCIPerson(response, highestId);
				people.add(kci);
				highestId++;
			}
			
			ArrayList<ArrayList<KCIPerson>> splitLists = split(people);
			
			ArrayList<KCIPerson> donors = splitLists.get(0);
			ArrayList<KCIPerson> recipients = splitLists.get(1);
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
