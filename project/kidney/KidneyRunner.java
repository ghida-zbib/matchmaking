package project.kidney;

import project.algorithm.GaleShapley;
import project.algorithm.Man;
import project.algorithm.Person;
import project.forms.ResponseSet;
import project.algorithm.Woman;
import project.forms.Response;
import project.test.Verifier;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class KidneyRunner {
	
	private static int RECIPIENT_COUNT;

	public Man[] convertRecipients(ArrayList<KCIPerson> recipients) {
		Man[] men = new Man[recipients.size()];
		for(int i = 0; i < recipients.size(); i++) {
			KCIPerson recipient = recipients.get(i);
			Man man = new Man(recipient.getFormResponse().getName(), recipient.getId());
			man.setPrefsList(recipient.getPreferences());
			man.initializeFiance();
			men[i] = man;
		}
		return men;
	}
	
	public Woman[] convertDonors(ArrayList<KCIPerson> donors) {
		Woman[] women = new Woman[donors.size()];
		for(int i = 0; i < donors.size(); i++) {
			KCIPerson donor = donors.get(i);
			Woman woman = new Woman(donor.getFormResponse().getName(), donor.getId());
			woman.setPrefsList(donor.getPreferences());
			woman.initializeFiance();
			women[i] = woman;
		}
		return women;
	}
	
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
	
	public void runFromCSV(String filename) throws IOException {
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
			
			RECIPIENT_COUNT = recipients.size();
			
			for(int i = 0; i < donors.size(); i++) {
				KCIPerson donor = donors.get(i);
				donor.setId(donor.getId() - RECIPIENT_COUNT);
				donor.setPreferences(donor.buildPreferences(recipients));
			}
			
			for(int i = 0; i < recipients.size(); i++) {
				KCIPerson recipient = recipients.get(i);
				recipient.setPreferences(recipient.buildPreferences(donors));
			}
			
			Man[] men = convertRecipients(recipients);
			Woman[] women = convertDonors(donors);
			
			/* for(int i = 0; i < men.length; i++) {
				System.out.println(String.format("%s preference list: ", men[i].getName()));
				for(int j = 0; j < men[i].getPrefsList().length; j++) {
					System.out.print(((Integer) men[i].getPrefsList()[j]).toString() + " ");	
				}
				System.out.print("\n");
			}
			
			for(int i = 0; i < women.length; i++) {
				System.out.println(String.format("%s preference list: ", women[i].getName()));
				for(int j = 0; j < women[i].getPrefsList().length; j++) {
					System.out.print(((Integer) women[i].getPrefsList()[j]).toString() + " ");	
				}
				System.out.print("\n");
			} */
			
			List<List<Person>> output = GaleShapley.galeShapley(men, women, men.length);
			
			int unmatchedCount = 0;
			
			for(int i = 0; i < output.size(); i++) {
				List<Person> row = output.get(i);
				System.out.println(row.get(0).getName() + " is matched with " + row.get(1).getName());
				if(row.get(1).getName().equals("Nobody") || row.get(0).getName().equals("Nobody")) {
					unmatchedCount += 2;
					// TODO FIX OUTPUT TO HAVE TWO SIDES OF UNMATCHED RELATION
				}
			}
			System.out.println(String.format("Unmatched: %d", unmatchedCount));
			if(Verifier.verify(output)) {
				System.out.println("hurray!");
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		KidneyRunner kr = new KidneyRunner();
		try {
			kr.runFromCSV("/Users/dev/finalResults.csv");
		}
		catch(IOException e) {
			//...
		}
	}
}
