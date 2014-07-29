
public class KCIPerson {
	private static final Response response = null;
	private String bloodType;
	private int healthIndex;
	
	private Response formResponse;
	private boolean isRecipient; // if false, then they're a donor
	
	public KCIPerson(Response formResponse) {
		this.formResponse = formResponse;
		this.bloodType = formResponse.getBloodType();
		this.healthIndex = scoreResponse(formResponse);
	}

	public static int scoreResponse(Response formResponse) {
		Decider decider = new Decider("", "", formResponse.getFastFood(), formResponse.getVeg(), formResponse.getOilAndButter(), formResponse.getEggs(), formResponse.getDesserts());
		int result = 0;
		result += decider.fastFoodIndex(formResponse.getFastFood());
		result += decider.eggsIndex(formResponse.getEggs());
		result += decider.highFatDessertsIndex(formResponse.getDesserts());
		result += decider.oilAndButterIndex(formResponse.getOilAndButter());
		result += decider.vegeIndex(formResponse.getVeg());
		return result;
	}
	
	public static void main (String[] args) throws Exception {
		ResponseSet responseSet = new ResponseSet("src/scitech.csv");
		
		for(int i = 0; i < responseSet.getResponses().size(); i++) {
			Response formResponse = responseSet.getResponses().get(i);
			System.out.println(scoreResponse(formResponse));
		}
	
	}
}
