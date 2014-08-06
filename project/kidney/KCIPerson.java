package project.kidney;
import project.forms.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class KCIPerson {
	private static double SCORE_THRESHOLD = 3;

	private int id;
	
	private String bloodType;
	private int healthIndex;
	
	private Response formResponse;
	private boolean isRecipient; // if false, then they're a donor
	
	private Integer[] preferences;
	
	public KCIPerson(Response formResponse, int id) {
		this.formResponse = formResponse;
		this.bloodType = formResponse.getBloodType();
		this.healthIndex = scoreResponse(formResponse);
		this.id = id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getHealthIndex() {
		return this.healthIndex;
	}
	
	public String getBloodType() {
		return this.bloodType;
	}
	
	public Response getFormResponse() {
		return this.formResponse;
	}
	
	public int[] getPreferences() {
		int[] result = new int[this.preferences.length];
		for(int i = 0; i < this.preferences.length; i++) {
			result[i] = (int) this.preferences[i];
		}
		return result;
	}
	
	public int getId() {
		return this.id;
	}

	public int scoreResponse(Response formResponse) {
		Decider decider = new Decider("", "", formResponse.getFastFood(), formResponse.getVeg(), formResponse.getOilAndButter(), formResponse.getEggs(), formResponse.getDesserts());
		int result = 0;
		result += decider.fastFoodIndex(formResponse.getFastFood());
		result += decider.eggsIndex(formResponse.getEggs());
		result += decider.highFatDessertsIndex(formResponse.getDesserts());
		result += decider.oilAndButterIndex(formResponse.getOilAndButter());
		result += decider.vegeIndex(formResponse.getVeg());
		return result;
	}
	
	private int bloodCompatibility(String firstBloodType, String secondBloodType) {
		if (firstBloodType.equals(secondBloodType))
		{
			return 90;
		}
		else if ((firstBloodType.substring(firstBloodType.length()-1)).equals(secondBloodType.substring(secondBloodType.length()-1)))
		{
			return 45;
		}
		else if ((firstBloodType.substring(firstBloodType.length()-1).equals(secondBloodType.substring(secondBloodType.length()-1))))
		{
			return 90;
		}
		else if (!(firstBloodType.substring(firstBloodType.length()-1).equals(secondBloodType.substring(secondBloodType.length()-1))))
		{
			return 45;
		}
		else if (firstBloodType.substring(firstBloodType.length()-2, firstBloodType.length()-1).equals("AB") && firstBloodType.substring(firstBloodType.length()-1).equals(secondBloodType.substring(secondBloodType.length()-1)))
		{
			return 90;
		}
		else if (firstBloodType.substring(firstBloodType.length()-2, firstBloodType.length()-1).equals("AB") && !(firstBloodType.substring(firstBloodType.length()-1).equals(secondBloodType.substring(secondBloodType.length()-1))))
		{
			return 45;
		}
		else
		{
			return 10;
		}
	}
	
	public Double weightedPref(KCIPerson person) {
		int personHealthIndex = person.getHealthIndex();
		int kidneyCompatibility = bloodCompatibility(this.bloodType, person.getBloodType());
		Double weightedPreference = 0.6*kidneyCompatibility + personHealthIndex;
		
	//	System.out.println(String.format("%s's preference for %s is %f", this.getFormResponse().getName(), person.getFormResponse().getName(), weightedPreference));
		
		return weightedPreference;
	}
	
	public void setPreferences(Integer[] preferences) {
		this.preferences = preferences;
	}
	
	public Integer[] buildPreferences(ArrayList<KCIPerson> others) {
		
		ArrayList<KCIPerson> result = new ArrayList<KCIPerson>();
		
		ArrayList<Double> preferenceList = new ArrayList<Double>();
		
		/* Builds a set of preferences given a list of KCIPerson objects */
		for(int i = 0; i < others.size(); i++) {
			KCIPerson person = others.get(i);
			preferenceList.add(weightedPref(person));
		}
		
		// sort the list of preference numbers
		
		Collections.sort(preferenceList);
		Collections.reverse(preferenceList);
		
		// filter out those who are under the threshold
		
		Iterator<Double> iter = preferenceList.iterator();
		
		while(iter.hasNext()) {
			if(iter.next() < SCORE_THRESHOLD) {
				iter.remove();
			}
		}
		
		for(int i = 0; i < preferenceList.size(); i++) {
			
			Double preference = preferenceList.get(i);
			
			for(int j = 0; j < others.size(); j++) {
				double personPref = weightedPref(others.get(j));
				if(personPref == preference && result.indexOf(others.get(j)) < 0) {
					result.add(others.get(j));
					break;
				}
			}
		}
		
		// convert the ArrayList<KCIPerson> to an int[]
		
		ArrayList<Integer> ids = new ArrayList<Integer>();
		
		for(int i = 0; i < result.size(); i++) {
			ids.add(result.get(i).getId());
		}
		
		Integer[] prefIds = ids.toArray(new Integer[ids.size()]);
		
		return prefIds;
	}
}
