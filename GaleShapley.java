import java.util.ArrayList;
import java.util.List;


public class GaleShapley {
	
	public static void main(String[] args) {
		
		Person man1 = new Person("Joe", 1);
		Person man2 = new Person("Mark", 2);
		Person man3 = new Person("Amit", 3);
		
		int[] man1Prefs = {3, 2, 1}; // these are the IDs of his preferences, in order
		int[] man2Prefs = {2, 3, 1};
		int[] man3Prefs = {2, 1, 3};
		
		man1.setPrefsList(man1Prefs);
		man2.setPrefsList(man2Prefs);
		man3.setPrefsList(man3Prefs);
		
		Woman woman1 = new Woman("Alpha", 1);
		Woman woman2 = new Woman("Beta", 2);
		Woman woman3 = new Woman("Gamma", 3);
		
		int[] woman1Prefs = {1, 2, 3};
		int[] woman2Prefs = {2, 3, 1};
		int[] woman3Prefs = {2, 1, 3};
		
		woman1.setPrefsList(woman1Prefs);
		woman2.setPrefsList(woman2Prefs);
		woman3.setPrefsList(woman3Prefs);
		
		Person[] men = {man1, man2, man3};
		Woman[] women = {woman1, woman2, woman3};
		
		List<List<Person>> galeShapleyOutput = galeShapley(men, women, 3);
		for(int i = 0; i < galeShapleyOutput.size(); i++) {
			List<Person> matchRow = galeShapleyOutput.get(i);
			System.out.println(matchRow.get(0).name + " is matched with " + matchRow.get(1).name);
		}
	}
	
	public static List<List<Person>> galeShapley(Person[] men, Woman[] women, int n) {
		int engagedCount = 0;
		
		while(engagedCount < n) {
			for(int i = 0; i < men.length; i++) {
				
				Person man = men[i];
						
				if(man.currentFiance == null) {
					/* propose to the next choice */
					
					Woman nextChoiceWoman = new Woman("", -1); // blank Woman object
					
					for(int j = 0; j < women.length; j++) {
						if(women[j].id == man.prefsList[man.nextChoice]) {
							nextChoiceWoman = women[j];
						}
					}
				
					nextChoiceWoman.proposals.add(man);
				}
				
			}
			
			for(int j = 0; j < women.length; j++) {
				Woman woman = women[j];
				
				ArrayList<Person> candidates = woman.proposals;
				if(woman.currentFiance != null) {
					candidates.add(woman.currentFiance);
				}
				
				int mostPrefIndex = woman.prefsList.length;
				Person mostPref = new Person("", -1); // blank Person
				
				for(int k = 0; k < candidates.size(); k++ )
				{
					Person man = candidates.get(k);
					for(int l = 0; l < woman.prefsList.length; l++) {
						if(woman.prefsList[l] == man.id) {
							if(l < mostPrefIndex) {
								mostPref = man;
								mostPrefIndex = l;
							}
						}
					}
				}
				
				if(woman.currentFiance == null) {
					engagedCount++;
				}
				
				woman.currentFiance = mostPref;
				mostPref.currentFiance = woman;
				
			}
			
			for(int i = 0; i < women.length; i++) {
				women[i].proposals = new ArrayList<Person>();
			}
		}
		
		List<List<Person>> output = new ArrayList<List<Person>>();
		
		for(int i = 0; i < men.length; i++) {
			ArrayList<Person> matchRow = new ArrayList<Person>();
			output.add(matchRow);
			
			matchRow.add(men[i]);
			matchRow.add(men[i].currentFiance);
		}
	
		
		return output;
	}
}
