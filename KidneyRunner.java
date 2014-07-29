import java.io.FileNotFoundException;
import java.util.ArrayList;


public class KidneyRunner {

	private ArrayList<ArrayList<KCIPerson>> split(ArrayList<KCIPerson> people) {
		// split into half donors, half recipients
		// (TODO)
		
		int halfwayPoint = people.size()/2;
		
		ArrayList<KCIPerson> donorsList = new ArrayList<KCIPerson>();
		ArrayList<KCIPerson> recipientsList = new ArrayList<KCIPerson>();
		
		for(int i = 0; i < people.size(); i++) {
			if(i < halfwayPoint) {
				recipientsList.add(people.get(i));
			}
			else {
				donorsList.add(people.get(i));
			}
		}
		
		ArrayList<ArrayList<KCIPerson>> lists = new ArrayList<ArrayList<KCIPerson>>();
		
		lists.add(donorsList);
		lists.add(recipientsList);
		
		return lists;
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
			
			for(int i = 0; i < donors.size(); i++) {
				donors.get(i).buildPreferences(recipients);
			}
			
			for(int i = 0; i < recipients.size(); i++) {
				recipients.get(i).buildPreferences(donors);
			}
			
			// run gale shapley here
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
