import java.util.ArrayList;


public class GaleShapley {
	
	public static void main(String[] args) {
		
		Person man1 = new Person("Joe");
		Person man2 = new Person("Mark");
		Person man3 = new Person("Amit");
		
		Woman woman1 = new Woman("Alpha");
		Woman woman2 = new Woman("Beta");
		Woman woman3 = new Woman("Gamma");
	
	}
	
	public static Person[][] galeShapley(Person[] men, Woman[] women, int n) {
		int engagedCount = 0;
		
		while(engagedCount < n) {
			for(int i = 0; i < men.length; i++) {
				
				Person man = men[i];
						
				if(man.currentFiance == null) {
					/* propose to the next choice */
					
					Woman nextChoiceWoman = new Woman("");
					
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
				candidates.add(woman.currentFiance);
				
				int mostPrefIndex = woman.prefsList.length;
				Person mostPref = new Person("");
				
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
		
		Person[][] output = {};
		
		for(int i = 0; i < men.length; i++) {
			output[i][0] = men[i];
			output[i][1] = men[i].currentFiance;
		}
		
		return output;
	}
}
