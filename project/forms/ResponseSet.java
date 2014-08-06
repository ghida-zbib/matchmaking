package project.forms;
import project.forms.Response;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ResponseSet {
	
	private ArrayList<Response> responses;
	
	public static final String NO_VEG_STRING = "None";
	public static final String VEGETARIAN_STRING = "Vegetarian";
	public static final String VEGAN_STRING = "Vegan";
	
	public static final Integer NO_VEG = 0;
	public static final Integer VEGETARIAN = 1;
	public static final Integer VEGAN = 2;
	
	public static final String RARELY_STRING = "Rarely";
	public static final String SOMETIMES_STRING = "Sometimes";
	public static final String OFTEN_STRING = "Often";
	public static final String MOSTLY_STRING = "Most";
	
	public static final Integer RARELY_INT = 0;
	public static final Integer SOMETIMES_INT = 1;
	public static final Integer OFTEN_INT = 2;
	public static final Integer MOSTLY_INT = 3;
	
	public static final HashMap<String, Integer> conditionsToInts = new HashMap<String, Integer>();
	public static final HashMap<String, Integer> vegsToInts = new HashMap<String, Integer>();
	
	public ArrayList<Response> getResponses() {
		return responses;
	}
	
	public ResponseSet(String filename) throws IOException{
		
		responses = new ArrayList<Response>();
		
		conditionsToInts.put(RARELY_STRING, RARELY_INT);
		conditionsToInts.put(SOMETIMES_STRING, SOMETIMES_INT);
		conditionsToInts.put(OFTEN_STRING, OFTEN_INT);
		conditionsToInts.put(MOSTLY_STRING, MOSTLY_INT);
		
		vegsToInts.put(NO_VEG_STRING, NO_VEG);
		vegsToInts.put(VEGETARIAN_STRING, VEGETARIAN);
		vegsToInts.put(VEGAN_STRING, VEGAN);
		
		FileReader inReader = new FileReader(filename);
		BufferedReader buffReader = new BufferedReader(inReader);
		
		ArrayList<ArrayList<String>> responseStrings = new ArrayList<ArrayList<String>>();
		
		
		String currentResponseLine;
		
		while((currentResponseLine = buffReader.readLine()) != null) {
			String[] currentResponseArray = currentResponseLine.split(",");
			ArrayList<String> currentResponse=new ArrayList<String>();
			for(int i = 0; i < currentResponseArray.length; i++) {
				currentResponse.add(currentResponseArray[i]);
			}
			responseStrings.add(currentResponse);
		}
		
		for(int i = 0; i < responseStrings.size(); i++) {
			ArrayList<String> myResponse = responseStrings.get(i);
			Response response = new Response();
			
			String fastFoodString = myResponse.get(1);
			Integer fastFood = -1;
			
			if(fastFoodString.indexOf("-") == -1) {
				fastFood = Integer.parseInt(fastFoodString.replace("+", ""));
			}
			else {
				fastFood = Integer.parseInt(fastFoodString.substring(0, 1));
			}
			
			response.setFastFood(fastFood);
			
			String vegString = myResponse.get(2);
			response.setVeg(vegsToInts.get(vegString));
			
			String oilButterString = myResponse.get(3);
			response.setOilButter(conditionsToInts.get(oilButterString));
			
			String eggsString = myResponse.get(4);
			response.setEggs(conditionsToInts.get(eggsString));
			
			String dessertsString = myResponse.get(5);
			response.setDesserts(conditionsToInts.get(dessertsString));
			
			String bloodTypeString = myResponse.get(6);
			response.setBloodType(bloodTypeString);
			
			String name = myResponse.get(7);
			response.setName(name);
			
			responses.add(response);
		}
	
		buffReader.close();
		inReader.close();	
	
	}
}