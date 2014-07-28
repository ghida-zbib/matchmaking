import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ResponseSet {
	
	private ArrayList<Response> responses;
	
	private static final int NO_VEG = 0;
	private static final int VEGETARIAN = 1;
	private static final int VEGAN = 2;
	
	public ResponseSet(String filename) throws Exception {
		Scanner scanner = new Scanner (new File ("Placeholder for name"));
		scanner.useDelimiter(",");
		ArrayList<ArrayList<String>> responses = new ArrayList<ArrayList<String>>();
		ArrayList<String> currentResponse=new ArrayList<String>();
	
		while (scanner.hasNext())
			{
				if(currentResponse.size() < 8) {
					currentResponse.add(scanner.next());
				}
				else {
					responses.add(currentResponse);
					currentResponse = new ArrayList<String>();
				}
			}

			for(int i = 0; i < responses.size(); i++) {
				ArrayList<String> myResponse = responses.get(i);
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
			}
		
			scanner.close();	
	}
}