package project.algorithm;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import project.test.Verifier;


public class GaleShapley {
	
	static Woman[] manualIncompleteWomenInput() {
		Woman woman1 = new Woman("Alpha", 1);
		Woman woman2 = new Woman("Beta", 2);
		Woman woman3 = new Woman("Gamma", 3);
		Woman woman4 = new Woman ("Delta", 4);
		Woman woman5 = new Woman ("Epsilon", 5);
		Woman woman6 = new Woman ("Omega", 6);
		
		int[] woman1Prefs = {5};
		int[] woman2Prefs = {6, 5};
		int[] woman3Prefs = {4, 6, 2};
		int[] woman4Prefs = {1};
		int[] woman5Prefs = {3};
		int[] woman6Prefs = {1, 6};
		
		woman1.setPrefsList(woman1Prefs);
		woman2.setPrefsList(woman2Prefs);
		woman3.setPrefsList(woman3Prefs);
		woman4.setPrefsList(woman4Prefs);
		woman5.setPrefsList(woman5Prefs);
		woman6.setPrefsList(woman6Prefs);
		
		Woman[] women = {woman1, woman2, woman3, woman4, woman5, woman6};
		
		for(Woman woman : women) {
			woman.initializeFiance();
		}
		
		return women;
	}
	
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
		
		for(Woman woman : women) {
			woman.initializeFiance();
		}
		
		return women;
	}
	
	static Man[] manualIncompleteMenInput() {
		Man man1 = new Man("A", 1);
		Man man2 = new Man("B", 2);
		Man man3 = new Man("C", 3);
		Man man4 = new Man ("D", 4);
		Man man5= new Man ("E", 5);
		Man man6= new Man ("F", 6);
		
		int[] man1Prefs = {3}; // these are the IDs of his preferences, in order
		int[] man2Prefs = {2, 6};
		int[] man3Prefs = {5};
		int[] man4Prefs = {1, 2};
		int[] man5Prefs = {5, 6, 1};
		int[] man6Prefs = {2, 4};
		
		man1.setPrefsList(man1Prefs);
		man2.setPrefsList(man2Prefs);
		man3.setPrefsList(man3Prefs);
		man4.setPrefsList(man4Prefs);
		man5.setPrefsList(man5Prefs);
		man6.setPrefsList(man6Prefs);
		
		man1.initializeFiance();
		man2.initializeFiance();
		man3.initializeFiance();
		man4.initializeFiance();
		man5.initializeFiance();
		man6.initializeFiance();
		
		Man[] men = {man1, man2, man3, man4, man5, man6};
		
		for(Man man : men) {
			man.initializeFiance();
		}
		
		return men;
	}
	
	static Man[] manualMenInput() {
		Man man1 = new Man("A", 1);
		Man man2 = new Man("B", 2);
		Man man3 = new Man("C", 3);
		Man man4 = new Man ("D", 4);
		Man man5 = new Man ("E", 5);
		Man man6 = new Man ("F", 6);
		
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
		
		Man[] men = {man1, man2, man3, man4, man5, man6};
		
		for(Man man : men) {
			man.initializeFiance();
		}
		
		return men;
	}
	
	public static void displayFromManual() {
		Man[] men = manualMenInput();
		Woman[] women = manualWomenInput();
		List<List<Person>> galeShapleyOutput = galeShapley(men, women, 6);
		for(int i = 0; i < galeShapleyOutput.size(); i++) {
			List<Person> matchRow = galeShapleyOutput.get(i);
			System.out.println(matchRow.get(0).name + " is matched with " + matchRow.get(1).name);
		}
	}
	
	public static void displayFromIncompleteManual() {
		List<List<Person>> galeShapleyOutput = galeShapley(manualIncompleteMenInput(), manualIncompleteWomenInput(), 6);
		for(int i = 0; i < galeShapleyOutput.size(); i++) {
			List<Person> matchRow = galeShapleyOutput.get(i);
			System.out.println(matchRow.get(0).name + " is matched with " + matchRow.get(1).name);
		}
	}
	
	public static List<List<List<Person>>> runFromFile() throws NumberFormatException, IOException {
		long startTime = System.nanoTime();
		File inputFile = new File("src/test/matchTests[5x5With2Tests.txt");
		FileReader inReader = new FileReader(inputFile);
		BufferedReader buffReader = new BufferedReader(inReader);
		
		Integer n = 0;
		Integer t = 0;
		
		List<List<List<Person>>> galeShapleyResults = new ArrayList<List<List<Person>>>();
		
		int lineNumber = 0;
		
		n = Integer.parseInt(buffReader.readLine());
		t = Integer.parseInt(buffReader.readLine());
		
		lineNumber++;
		lineNumber++;
		
		for(int q = 0; q < t; q++) { 
			
			List<Man> men = new ArrayList<Man>();
			List<Woman> women = new ArrayList<Woman>();
			
			System.out.println(String.format("We are now on test %d", q));
			
			String menString = buffReader.readLine();
			lineNumber++;
			String[] menStringArray = menString.split(" ");
			
			int menIdCounter = 1;
			
			for(int i = 0; i < menStringArray.length; i++) {
				Man stringMan = new Man(menStringArray[i], menIdCounter);
				stringMan.initializeFiance();
				men.add(stringMan);
				menIdCounter++;
			}
			
			String womenString = buffReader.readLine();
			lineNumber++;
			String[] womenStringArray = womenString.split(" ");
			
			int womenIdCounter = 1;
			
			for(int i = 0; i < womenStringArray.length; i++) {
				Woman stringWoman = new Woman(womenStringArray[i], womenIdCounter);
				stringWoman.initializeFiance();
				women.add(stringWoman);
				womenIdCounter++;
			}
			
			for(int i = 0; i < men.size(); i++) {
				String manPrefsString = buffReader.readLine();
				lineNumber++;
				String[] splitPrefs = manPrefsString.split(" ");
				
				List<Integer> prefsList = new ArrayList<Integer>();
				
				for(int j = 0; j < splitPrefs.length; j++) {
					prefsList.add(Integer.parseInt(splitPrefs[j]));
				}
				
				int[] prefs = new int[prefsList.size()];
				
				for(int j = 0; j < prefsList.size(); j++) {
					prefs[j] = prefsList.get(j);
				}
				
				men.get(i).setPrefsList(prefs);
			}
			
			for(int i = 0; i < women.size(); i++) {
				String womanPrefsString = buffReader.readLine();
				lineNumber++;
				String[] splitPrefs = womanPrefsString.split(" ");
				
				List<Integer> prefs = new ArrayList<Integer>();
				
				for(int j = 0; j < splitPrefs.length; j++) {
					prefs.add(Integer.parseInt(splitPrefs[j]));
				}
				
				int[] prefsList = new int[prefs.size()];
				
				for(int j = 0; j < prefs.size(); j++) {
					prefsList[j] = prefs.get(j);
				}
				
				women.get(i).setPrefsList(prefsList);
			}
		
			Man[] menArray = men.toArray(new Man[men.size()]);
			Woman[] womenArray = women.toArray(new Woman[women.size()]);
			
			galeShapleyResults.add(galeShapley(menArray, womenArray, n));
		}
		
		long endTime = System.nanoTime();
		System.out.println(String.format("Total test time for %d tests (%d x %d) took %f seconds", t, n, n, (endTime-startTime)/1000000000.0));
		
		inReader.close();
		
		return galeShapleyResults;
	}
	
	public static List<List<Person>> galeShapley(Man[] men, Woman[] women, int n) {		
		int engagedCount = 0;
		int exhaustedCount = 0;
		
		while(engagedCount + exhaustedCount < n) {
			
			System.out.println(String.format("engaged count: %d", engagedCount));
			System.out.println(String.format("exhausted count: %d", exhaustedCount));
			
			for(int i = 0; i < men.length; i++) {
				
				Man man = men[i];
						
				if(man.getCurrentFiance().getClass() == Nobody.class) {
					
					/* propose to the next choice */
					
					Woman nextChoiceWoman = null; // blank Woman object
					
					for(int j = 0; j < women.length; j++) {
						Woman woman = women[j];
						int nextChoiceId = man.getPrefsList()[man.nextChoice];
						if(woman.getId() == nextChoiceId) {
							nextChoiceWoman = women[j];
							break;
						}
					}
				
					nextChoiceWoman.proposals.add(man);
					assert man.nextChoice < n-1;
					if(man.nextChoice < man.getPrefsList().length-1) {
						man.nextChoice++;
					}
					else {
						man.exhausted = true;
						exhaustedCount++;
						man.setCurrentFiance(new Nobody());
					}
				}
				
			}
			
			for(int j = 0; j < women.length; j++) {
				Woman woman = women[j];
				
				ArrayList<Man> candidates = woman.proposals;
				
				if(woman.getCurrentFiance().getClass() != Nobody.class) {
					candidates.add((Man) woman.getCurrentFiance());
				}
				
				int mostPrefIndex = woman.getPrefsList().length;
				Person mostPref = null; // blank Person
				
				for(int k = 0; k < candidates.size(); k++ )
				{
					Man man = candidates.get(k);
					for(int l = 0; l < woman.getPrefsList().length; l++) {
						if(woman.getPrefsList()[l] == man.getId()) {
							if(l < mostPrefIndex) {
								mostPref = man;
								mostPrefIndex = l;
							}
						}
					}
				}
				
				if(mostPref != null) {
					if(woman.getCurrentFiance().getClass() == Nobody.class) {
						// accepting for the first time
						engagedCount++;
						woman.setCurrentFiance(mostPref);
						mostPref.setCurrentFiance(woman);
					}
					else if(woman.getCurrentFiance().getClass() != Nobody.class  && mostPref != woman.getCurrentFiance()) {
						// rejecting current fiance and accepting a new one
						woman.getCurrentFiance().setCurrentFiance(new Nobody());
						woman.setCurrentFiance(mostPref);
						mostPref.setCurrentFiance(woman);
					}
				}
				
			}
			
			for(int i = 0; i < women.length; i++) {
				women[i].proposals = new ArrayList<Man>();
			}
		}
		
		List<List<Person>> output = new ArrayList<List<Person>>();
		
		for(int i = 0; i < men.length; i++) {
			ArrayList<Person> matchRow = new ArrayList<Person>();
			
			matchRow.add(men[i]);
			matchRow.add(men[i].getCurrentFiance());
			
			output.add(matchRow);
		}
		
		
		return output;
	}
	
	public static void displayResults(List<List<Person>> galeShapleyResults) {
		for(int i = 0; i < galeShapleyResults.size(); i++) {
			System.out.println(galeShapleyResults.get(i).get(0).name + " is matched with " + galeShapleyResults.get(i).get(1).name);
		}
	}
	
	public static String generateFile(int n, int t) throws IOException {
		Runtime rt = Runtime.getRuntime();
		String command = String.format("./testgs %d %d", n, t);
		rt.exec(command);
		return String.format("matchTests[%dx%dWith%dTests.txt", n, n, t);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		/*
		List<List<Person>> galeShapleyOutput = galeShapley(manualIncompleteMenInput(), manualIncompleteWomenInput(), 6);
		if(Verifier.verify(galeShapleyOutput)) {
			System.out.println("Passed test - stable");
		}
		else {
			System.out.println("Failed test - unstable");
		} */
		// displayFromIncompleteManual();
		System.out.println(Verifier.verify(runFromFile().get(0)));
		System.out.println(Verifier.verify(runFromFile().get(1)));
	}
	
}