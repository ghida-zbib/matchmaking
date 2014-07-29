
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
	
	public static void main (String[] args) {
		Response response = new Response();
		response.setFastFood(8);
		response.setVeg(ResponseSet.NO_VEG);
		response.setEggs(ResponseSet.SOMETIMES_INT);
		response.setDesserts(ResponseSet.OFTEN_INT);
		response.setOilButter(ResponseSet.SOMETIMES_INT);
		
		System.out.println(scoreResponse(response));
	}
}
