
public class KCIPerson {
	private String bloodType;
	private int healthIndex;
	
	private Response formResponse;
	private boolean isRecipient; // if false, then they're a donor
	
	public KCIPerson(Response formResponse) {
		this.formResponse = formResponse;
		this.bloodType = formResponse.getBloodType();
		this.healthIndex = scoreResponse(formResponse);
	}

	public int scoreResponse(Response formResponse) {
		Decider decider = new Decider("", "", formResponse.getFastFood(), formResponse.getVeg(), formResponse.getOilAndButter(), formResponse.getEggs(), formResponse.getDesserts());
		
	}
}
