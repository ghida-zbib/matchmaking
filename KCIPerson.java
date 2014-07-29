import java.util.ArrayList;


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
	
	public void buildPreferences(ArrayList<KCIPerson> others) {
		/* Builds a set of preferences given a list of KCIPerson objects */
		for(int i = 0; i < others.size(); i++) {
			KCIPerson person = others.get(i);
			int personHealthIndex = person.getHealthIndex();
			// add ID to prefs based on health index
		}
	}
}
