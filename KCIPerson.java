import java.util.ArrayList;
import java.util.Collections;


public class KCIPerson {
	private int id;
	
	private static final Response response = null;
	private String bloodType;
	private int healthIndex;
	
	private Response formResponse;
	private boolean isRecipient; // if false, then they're a donor
	
	private int[] preferences;
	
	public KCIPerson(Response formResponse) {
		this.formResponse = formResponse;
		this.bloodType = formResponse.getBloodType();
		this.healthIndex = scoreResponse(formResponse);
	}
	
	public int getHealthIndex() {
		return this.healthIndex;
	}
	
	public String getBloodType() {
		return this.bloodType;
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
		if (firstBloodType==secondBloodType)
		{
			return 90;
		}
		else if ((firstBloodType.substring(firstBloodType.length()-1))==(secondBloodType.substring(secondBloodType.length()-1)))
		{
			return 45;
		}
		else if ((firstBloodType.substring(firstBloodType.length()-1)==(secondBloodType.substring(secondBloodType.length()-1))))
		{
			return 90;
		}
		else if ((firstBloodType.substring(firstBloodType.length()-1)!=(secondBloodType.substring(secondBloodType.length()-1))))
		{
			return 45;
		}
		else if (firstBloodType.substring(firstBloodType.length()-2, firstBloodType.length()-1)==("AB") && firstBloodType.substring(firstBloodType.length()-1)==(secondBloodType.substring(secondBloodType.length()-1)))
		{
			return 90;
		}
		else if (firstBloodType.substring(firstBloodType.length()-2, firstBloodType.length()-1)==("AB") && firstBloodType.substring(firstBloodType.length()-1)!=(secondBloodType.substring(secondBloodType.length()-1)))
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
		Double weightedPreference = 0.6*kidneyCompatibility + 0.4*personHealthIndex;
		
		return weightedPreference;
	}
	
	public ArrayList<KCIPerson> buildPreferences(ArrayList<KCIPerson> others) {
		
		ArrayList<KCIPerson> result = new ArrayList<KCIPerson>();
		
		ArrayList<Double> preferenceList = new ArrayList<Double>();
		
		/* Builds a set of preferences given a list of KCIPerson objects */
		for(int i = 0; i < others.size(); i++) {
			KCIPerson person = others.get(i);
			preferenceList.add(weightedPref(person));
		}
		
		// sort the list of preference numbers
		
		Collections.sort(preferenceList);
		
		for(int i = 0; i < preferenceList.size(); i++) {
			
			Double preference = preferenceList.get(i);
			
			for(int j = 0; j < others.size(); j++) {
				if(weightedPref(others.get(j)) == preference) {
					result.add(others.get(j));
				}
			}
		}
		
		return result;
	}
}
