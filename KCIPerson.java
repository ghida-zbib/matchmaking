
public class KCIPerson {
	private String bloodType;
	private double healthIndex;
	
	private Response formResponse;
	private boolean isRecipient; // if false, then they're a donor
	
	public KCIPerson(Response formResponse) {
		this.formResponse = formResponse;
		this.bloodType = formResponse.getBloodType();
		this.healthIndex = scoreResponse(formResponse);
	}

	public double scoreResponse(Response formResponse) {
		return 0.0;
	}
}
