import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GaleShapley {
	
	static Woman[] manualWomenInput() {
		Woman woman1 = new Woman("Alpha", 1);
		Woman woman2 = new Woman("Beta", 2);
		Woman woman3 = new Woman("Gamma", 3);
		Woman woman4 = new Woman ("Delta", 4);
		Woman woman5 = new Woman ("Epsilon", 5);
		Woman woman6 = new Woman ("Omega", 6);
		
		int[] woman1Prefs = {5, 4, 1, 2, 3, 6};
		int[] woman2Prefs = {6, 5, 2, 4, 3, 1};
		int[] woman3Prefs = {4, 6, 2, 1, 5, 3};
		int[] woman4Prefs = {1, 2, 3, 6, 5, 4};
		int[] woman5Prefs = {3, 4, 5, 6, 2, 1};
		int[] woman6Prefs = {1, 6, 4, 3, 2, 5};
		
		woman1.setPrefsList(woman1Prefs);
		woman2.setPrefsList(woman2Prefs);
		woman3.setPrefsList(woman3Prefs);
		woman4.setPrefsList(woman4Prefs);
		woman5.setPrefsList(woman5Prefs);
		woman6.setPrefsList(woman6Prefs);
		
		Woman[] women = {woman1, woman2, woman3, woman4, woman5, woman6};
		return women;
	}
	
	static Person[] manualMenInput() {
		Person man1 = new Person("A", 1);
		Person man2 = new Person("B", 2);
		Person man3 = new Person("C", 3);
		Person man4 = new Person ("D", 4);
		Person man5= new Person ("E", 5);
		Person man6= new Person ("F", 6);
		
		int[] man1Prefs = {3, 4, 2, 5, 1, 6}; // these are the IDs of his preferences, in order
		int[] man2Prefs = {2, 6, 3, 4, 5, 1};
		int[] man3Prefs = {5, 2, 1, 4, 3, 6};
		int[] man4Prefs = {1, 2, 3, 4, 5, 6};
		int[] man5Prefs = {5, 6, 1, 2, 3, 4};
		int[] man6Prefs = {2, 4, 1, 5, 6, 3};
		
		man1.setPrefsList(man1Prefs);
		man2.setPrefsList(man2Prefs);
		man3.setPrefsList(man3Prefs);
		man4.setPrefsList(man4Prefs);
		man5.setPrefsList(man5Prefs);
		man6.setPrefsList(man6Prefs);
		
		Person[] men = {man1, man2, man3, man4, man5, man6};
		return men;
	}
	
	public static void displayFromManual() {
		Person[] men = manualMenInput();
		Woman[] women = manualWomenInput();
		List<List<Person>> galeShapleyOutput = galeShapley(men, women, 6);
		for(int i = 0; i < galeShapleyOutput.size(); i++) {
			List<Person> matchRow = galeShapleyOutput.get(i);
			System.out.println(matchRow.get(0).name + " is matched with " + matchRow.get(1).name);
		}
	}
	
	public static List<List<Person>> runFromFile() throws FileNotFoundException {
		File inputFile = new File("src/matchTests.txt");
		FileReader inReader = new FileReader(inputFile);
		BufferedReader buffReader = new BufferedReader(inReader);
		
		Integer n = 0;
		Integer t = 0;
		
		List<Person> men = new ArrayList<Person>();
		List<Woman> women = new ArrayList<Woman>();
		
		try {
			n = Integer.parseInt(buffReader.readLine());
			t = Integer.parseInt(buffReader.readLine());
			
			String menString = buffReader.readLine();
			String[] menStringArray = menString.split(" ");
			
			int menIdCounter = 1;
			
			for(int i = 0; i < menStringArray.length; i++) {
				Person stringMan = new Person(menStringArray[i], menIdCounter);
				men.add(stringMan);
				menIdCounter++;
			}
			
			String womenString = buffReader.readLine();
			String[] womenStringArray = womenString.split(" ");
			
			int womenIdCounter = 1;
			
			for(int i = 0; i < womenStringArray.length; i++) {
				Woman stringWoman = new Woman(womenStringArray[i], womenIdCounter);
				women.add(stringWoman);
				womenIdCounter++;
			}
			
			for(int i = 0; i < men.size(); i++) {
				String manPrefsString = buffReader.readLine();
				String[] splitPrefs = manPrefsString.split(" ");
				
				List<Integer> prefsList = new ArrayList<Integer>();
				
				for(int j = 0; j < splitPrefs.length; j++) {
					prefsList.add(Integer.parseInt(splitPrefs[j]));
				}
				
				int[] prefs = new int[prefsList.size()];
				
				for(int j = 0; j < prefsList.size(); j++) {
					prefs[j] = prefsList.get(j);
				}
				
				men.get(i).prefsList = prefs;
			}
			
			for(int i = 0; i < women.size(); i++) {
				String womanPrefsString = buffReader.readLine();
				String[] splitPrefs = womanPrefsString.split(" ");
				
				List<Integer> prefs = new ArrayList<Integer>();
				
				for(int j = 0; j < splitPrefs.length; j++) {
					prefs.add(Integer.parseInt(splitPrefs[j]));
				}
				
				int[] prefsList = new int[prefs.size()];
				
				for(int j = 0; j < prefs.size(); j++) {
					prefsList[j] = prefs.get(j);
				}
				
				women.get(i).prefsList = prefsList;
			}
			
			inReader.close();
		} catch(IOException e) {
			
		}
		finally {
			
			Person[] menArray = men.toArray(new Person[men.size()]);
			Woman[] womenArray = women.toArray(new Woman[women.size()]);
			
			return galeShapley(menArray, womenArray, n);
		}
	}
	
	public static List<List<Person>> galeShapley(Person[] men, Woman[] women, int n) {
		int engagedCount = 0;
		
		while(engagedCount < n) {
			System.out.println(engagedCount);
			for(int i = 0; i < men.length; i++) {
				
				Person man = men[i];
						
				if(man.currentFiance == null) {
					
					/* propose to the next choice */
					
					Woman nextChoiceWoman = null; // blank Woman object
					
					for(int j = 0; j < women.length; j++) {
						if(women[j].id == man.prefsList[man.nextChoice]) {
							nextChoiceWoman = women[j];
						}
					}
				
					nextChoiceWoman.proposals.add(man);
					assert(man.nextChoice < n-1);
					man.nextChoice++;
				}
				
			}
			
			for(int j = 0; j < women.length; j++) {
				Woman woman = women[j];
				
				ArrayList<Person> candidates = woman.proposals;
				if(woman.currentFiance != null) {
					candidates.add(woman.currentFiance);
				}
				
				int mostPrefIndex = woman.prefsList.length;
				Person mostPref = null; // blank Person
				
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
				
				if(woman.currentFiance == null && mostPref != null) {
					// accepting for the first time
					engagedCount++;
					woman.currentFiance = mostPref;
					mostPref.currentFiance = woman;
				}
				else if(woman.currentFiance != null && mostPref != woman.currentFiance) {
					// rejecting current fiance and accepting a new one
					woman.currentFiance.currentFiance = null;
					woman.currentFiance = mostPref;
					mostPref.currentFiance = woman;
				}
				
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
	
	public static void main(String[] args) {
		try {
			List<List<Person>> fileGaleShapley = runFromFile();
			if(Verifier.verify(fileGaleShapley)) {
				System.out.println("Yay");
			}
			else {
				System.out.println("Unstable");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}