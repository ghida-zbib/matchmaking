public class Decider {
	//define global variables
	static String firstBloodType; //Recipient Blood type
	static String secondBloodType; //Donor Blood Type
	static int fastFood; //amount of fast food eaten
	static String vegetarianOrVegan; //Vegan or vegetarian?
	static String oilAndButter; //amount of oil
	static int eggs; //how many eggs per week
	static int highFatDesserts; //how many fat desserts per week
	
	static int kidneyCompatability=0; //FINAL RETURNED INT, HIGHER NUMBER=MORE COMPATABLE
	
	//((((IMPORTANT)))) CONSTRUCTOR TAKES INPUTS IN ORDER
	public Decider (String DonorBlood, String RecipientBlood, int amountFastFood, String vegOrVeg, String oAndB, int huevos, int fatDesserts)
	{
		firstBloodType=DonorBlood;
		secondBloodType=RecipientBlood;
		fastFood=amountFastFood;
		vegetarianOrVegan=vegOrVeg;
		oilAndButter=oAndB;
		eggs=huevos;
		highFatDesserts=fatDesserts;
	}
	
	//find compatability based on blood type
	public void stringToBlood (String firstBloodType, String secondBloodType)
	{
		if (firstBloodType==secondBloodType)
		{
			kidneyCompatability+=90;
		}
		else if ((firstBloodType.substring(firstBloodType.length()-1))==(secondBloodType.substring(secondBloodType.length()-1)))
		{
			kidneyCompatability+=45;
		}
		else if ((firstBloodType.substring(firstBloodType.length()-1)==(secondBloodType.substring(secondBloodType.length()-1))))
		{
			kidneyCompatability+=90;
		}
		else if ((firstBloodType.substring(firstBloodType.length()-1)!=(secondBloodType.substring(secondBloodType.length()-1))))
		{
			kidneyCompatability+=45;
		}
		else if (firstBloodType.substring(firstBloodType.length()-2, firstBloodType.length()-1)==("AB") && firstBloodType.substring(firstBloodType.length()-1)==(secondBloodType.substring(secondBloodType.length()-1)))
		{
			kidneyCompatability+=90;
		}
		else if (firstBloodType.substring(firstBloodType.length()-2, firstBloodType.length()-1)==("AB") && firstBloodType.substring(firstBloodType.length()-1)!=(secondBloodType.substring(secondBloodType.length()-1)))
		{
			kidneyCompatability+=45;
		}
		else
		{
			kidneyCompatability+=0;
		}
	}
	//find dietary health of donor
	public void fastFood (int fastFood)
	{
		if (fastFood==0)
		{
			kidneyCompatability+=3;
		}
		else if ((fastFood>=1) && (fastFood<=3))
		{
			kidneyCompatability+=0;
		}
		else if ((fastFood>=4) && (fastFood<=6))
		{
			kidneyCompatability+=(-1);
		}
		else if ((fastFood>=7) && (fastFood<=9))
		{
			kidneyCompatability+=(-4);
		}
		else
		{
			kidneyCompatability+=(-7);
		}
	}
	public void vegetarianOrVegan (String vegetarianOrVegan)
	{
		if (vegetarianOrVegan==("Vegatarian") || vegetarianOrVegan==("vegatarian"))
		{
			kidneyCompatability+=8;
		}
		else if (vegetarianOrVegan==("Vegan") || vegetarianOrVegan==("vegan"))
		{
			kidneyCompatability+=9;
		}
		else
		{
			kidneyCompatability+=0;
		}
	}
	public static void oilAndButter (String oilAndButter)
	{
		if (oilAndButter==("Rarely") || oilAndButter==("rarely"))
		{
			kidneyCompatability+=3;
		}
		if (oilAndButter==("Sometimes") || oilAndButter==("sometimes"))
		{
			kidneyCompatability+=0;
		}
		if (oilAndButter==("Often") || oilAndButter==("often"))
		{
			kidneyCompatability-=(-3);
		}
		else
		{
			kidneyCompatability+=(-6);
		}
	}
	public void eggs (int eggs)
	{
		if (eggs==0)
		{
			kidneyCompatability+=2;
		}
		else if ((eggs>=1) && (eggs<=4))
		{
			kidneyCompatability+=0;
		}
		else if ((eggs>=5) && (eggs<=8))
		{
			kidneyCompatability+=(-2);
		}
		else
		{
			kidneyCompatability+=(-4);
		}
	}
	public void highFatDesserts (int highFatDesserts)
	{
		if (highFatDesserts==0)
		{
			kidneyCompatability+=0;
		}
		else if ((highFatDesserts>=1) && (highFatDesserts<=3))
		{
			kidneyCompatability+=(-2);
		}
		else if ((highFatDesserts>=4) && (highFatDesserts<=6))
		{
			kidneyCompatability+=(-4);
		}
		else if ((highFatDesserts>=1) && (highFatDesserts<=3))
		{
			kidneyCompatability+=(-2);
		}
	}	
	
	//Combines to find the compatability of two different blood types/diets into an int
	public static void main (String args[])
	{
		Decider myDecider = new Decider("O+","O+",14,"vegan","Often",21,31);
		myDecider.stringToBlood(firstBloodType, secondBloodType);
		System.out.println(kidneyCompatability);
		myDecider.fastFood(fastFood);
		System.out.println(kidneyCompatability);
		myDecider.vegetarianOrVegan(vegetarianOrVegan);
		System.out.println(kidneyCompatability);
		myDecider.oilAndButter(oilAndButter);
		System.out.println(kidneyCompatability);
		myDecider.eggs(eggs);
		System.out.println(kidneyCompatability);
		myDecider.highFatDesserts(highFatDesserts);
		System.out.println(kidneyCompatability);
	}
}
