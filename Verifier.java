import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Verifier {
	public static boolean verify(List<List<Person>> matches) {

		boolean isStable = true;

		/* create lists for the men and women */

		List<Person> men = new ArrayList<Person>();
		List<Person> women = new ArrayList<Woman>();

		for(int i = 0; i < matches.size(); i++) {
			men.add(matches.get(i).get(0));
			women.add(matches.get(i).get(1));
		}

		for(int i = 0; i < matches.size(); i++) {
			Person matchMan = matches.get(i).get(0);
			Woman matchWoman = matches.get(i).get(1);

			// wrap the man's pref list in a List object for easy indexing

			List<int> manPrefs;
			manPrefs = Arrays.asList(man.prefsList);

			/* check the rank of the woman in the man's preference list */

			int womanIndex = manPrefs.indexOf(matchWoman.id);

			/* for each woman above the woman in the list, check if the man is ranked higher
				in her list than her current match */

			for(int j = 0; j < womanIndex; j++) {
				int womanId = manPrefs.get(j);
				for(int k = 0; k < women.size(); k++) {
					if(women.get(k).id == womanId) {
						Woman woman = women.get(k);

						List<int> womanPrefs;
						womanPrefs = Arrays.asList(woman.prefsList);

						int manIndex = womanPrefs.indexOf(matchMan.id);
						int fianceIndex = womanPrefs.indexOf(woman.currentFiance.id);

						/* if the index of the man is greater than the index of the fiance, we have a blocking pair */

						if(manIndex < fianceIndex) {
							isStable = false;
						}
					}
				}
			}

		}
		return isStable;
	}
}
