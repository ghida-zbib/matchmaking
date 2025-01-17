package project.test;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import project.algorithm.Nobody;
import project.algorithm.Person;
import project.algorithm.Woman;

public class Verifier {
	
	private static int indexManPref(Person man, Woman woman) {
		/* indexes a man's preference towards a woman */
		for(int i = 0; i < man.getPrefsList().length; i++) {
			if(man.getPrefsList()[i] == woman.getId()) {
				return i;
			}
		}
		return -1;
	}
	
	private static int indexWomanPref(Person man, Woman woman) {
		/* indexes a woman's preference towards a man */
		for(int i = 0; i < woman.getPrefsList().length; i++) {
			if(woman.getPrefsList()[i] == woman.getId()){
				return i;
			}
		}
		return -1;
	}
	
	public static boolean verify(List<List<Person>> matches) {

		boolean isStable = true;

		/* create lists for the men and women */

		List<Person> men = new ArrayList<Person>();
		List<Woman> women = new ArrayList<Woman>();

		for(int i = 0; i < matches.size(); i++) {
			men.add(matches.get(i).get(0));
			if(matches.get(i).get(1).getClass() != Nobody.class) {
				women.add((Woman) matches.get(i).get(1));
			}
		}

		for(int i = 0; i < matches.size(); i++) {
			Person matchMan = matches.get(i).get(0);
			
			int womanIndex;
			
			if(matches.get(i).get(1).getClass() != Nobody.class) {
				Woman matchWoman = (Woman) matches.get(i).get(1);
	
				/* check the rank of the woman in the man's preference list */
	
				womanIndex = indexManPref(matchMan, matchWoman);
	
			}
			else {
				
				womanIndex = matchMan.getPrefsList().length;
				
			}
			/* for each woman above the woman in the list, check if the man is ranked higher
				in her list than her current match */

			for(int j = 0; j < womanIndex; j++) {
				int womanId = matchMan.getPrefsList()[j];
				for(int k = 0; k < women.size(); k++) {
					if(women.get(k).getId() == womanId) {
						Woman woman = women.get(k);

						int manIndex = indexWomanPref(matchMan, woman);
						int fianceIndex = indexWomanPref(woman.getCurrentFiance(), woman);

						/* if the index of the man is greater than the index of the fiance, we have a blocking pair */

						if(manIndex < fianceIndex && manIndex != -1 && fianceIndex != -1) {
							isStable = false;
						}
					}
				}
			}

		}
		return isStable;
	}
}
