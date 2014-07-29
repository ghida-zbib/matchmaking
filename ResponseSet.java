import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ResponseSet {
	
	private ArrayList<Response> responses;
	
	public static final Integer NO_VEG = 0;
	public static final Integer VEGETARIAN = 1;
	public static final Integer VEGAN = 2;
	
	public static final String RARELY_STRING = "Rarely";
	public static final String SOMETIMES_STRING = "Sometimes";
	public static final String OFTEN_STRING = "Often";
	public static final String MOSTLY_STRING = "Most of the time";
	
	public static final Integer RARELY_INT = 0;
	public static final Integer SOMETIMES_INT = 1;
	public static final Integer OFTEN_INT = 2;
	public static final Integer MOSTLY_INT = 3;
	
	public static final HashMap<String, Integer> conditionsToInts = new HashMap<String, Integer>();
	
	public ResponseSet(String filename) throws Exception {
		
		conditionsToInts.put(RARELY_STRING, RARELY_INT);
		conditionsToInts.put(SOMETIMES_STRING, SOMETIMES_INT);
		conditionsToInts.put(OFTEN_STRING, OFTEN_INT);
		conditionsToInts.put(MOSTLY_STRING, MOSTLY_INT);
		
		Scanner scanner = new Scanner (new File ("Placeholder for name"));
		scanner.useDelimiter(",");
		ArrayList<ArrayList<String>> responseStrings = new ArrayList<ArrayList<String>>();
		ArrayList<String> currentResponse=new ArrayList<String>();
	
		while (scanner.hasNext())
			{
				if(currentResponse.size() < 8) {
					currentResponse.add(scanner.next());
				}
				else {
					responseStrings.add(currentResponse);
					currentResponse = new ArrayList<String>();
				}
			}

			for(int i = 0; i < responses.size(); i++) {
				ArrayList<String> myResponse = responseStrings.get(i);
				Response response = new Response();
				response.setFastFood(Integer.parseInt(myResponse.get(0)));
				
				String vegString = myResponse.get(1);
				if(vegString.equals("None of the above")) {
					response.setVeg(NO_VEG);
				}
				else if(vegString.equals("Vegetarian")) {
					response.setVeg(VEGETARIAN);
				}
				else if(vegString.equals("Vegan")) {
					response.setVeg(VEGAN);
				}
				else {
					throw new Exception("Invalid veg type");
				}
				
				String oilButterString = myResponse.get(2);
				response.setOilButter(conditionsToInts.get(oilButterString));
				
				String eggsString = myResponse.get(3);
				response.setEggs(conditionsToInts.get(eggsString));
				
				String dessertsString = myResponse.get(4);
				response.setDesserts(conditionsToInts.get(dessertsString));
				
				String bloodTypeString = myResponse.get(5);
				response.setBloodType(bloodTypeString);
				
				/* TODO: randomize the Unknown blood types */
				
				String name = myResponse.get(6);
				response.setName(name);
				
				responses.add(response);
			}
		
			scanner.close();	
	}
}