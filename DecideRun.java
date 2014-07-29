/*  import java.awt.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DecideRun {
	static String firstBloodType; //Recipient Blood type
	static String secondBloodType; //Donor Blood Type
	static int fastFood; //amount of fast food eaten
	static String vegetarianOrVegan; //Vegan or vegetarian?
	static String oilAndButter; //amount of oil
	static int eggs; //how many eggs per week
	static int highFatDesserts; //how many fat desserts per week
	static int kidneyCompatability=0; //FINAL RETURNED INT, HIGHER NUMBER=MORE COMPATABLE
    //Combines to find the compatability of two different blood types/diets into an int
	public static void main (String args[]) throws FileNotFoundException
	{
		Scanner scanner=new Scanner (new File ("SciTech 2014 Donor Form (Responses) - Form Responses 1.csv"));
		scanner.useDelimiter(",");
		ArrayList<ArrayList<String>> responses = new ArrayList<ArrayList<String>>();
		ArrayList<String> currentResponse = new ArrayList<String>();
		
		while (scanner.hasNext())
		{
			if(currentResponse.size() < 8) {
				currentResponse.add(scanner.next());
			}
			else {
				responses.add(currentResponse);
				currentResponse= new ArrayList<String>();
			}
		}
		for (int i=0;i<responses.size();i++)
		{
			System.out.println(responses);
		}
		//22 in donor, 22 in recipient
		    	Decider myDecider= new Decider("O+","O+",14,"vegan","Often",21,31);
		
		scanner.close();	
	}
} */