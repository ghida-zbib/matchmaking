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
	public int fastFoodIndex (int fastFood)
	{
		if (fastFood==0)
		{
			return 3;
		}
		else if ((fastFood>=1) && (fastFood<=3))
		{
			return 0;
		}
		else if ((fastFood>=4) && (fastFood<=6))
		{
			return -1;
		}
		else if ((fastFood>=7) && (fastFood<=9))
		{
			return -4;
		}
		else
		{
			return -7;
		}
	}
	public int vegeIndex (String vegetarianOrVegan)
	{
		if (vegetarianOrVegan.equals("Vegatarian") || vegetarianOrVegan.equals("vegatarian"))
		{
			return 8;
		}
		else if (vegetarianOrVegan.equals("Vegan") || vegetarianOrVegan.equals("vegan"))
		{
			return 9;
		}
		else
		{
			return 0;
		}
	}
	public int oilAndButterIndex (String oilAndButter)
	{
		if (oilAndButter.equals("Rarely") || oilAndButter.equals("rarely"))
		{
			return 3;
		}
		if (oilAndButter.equals("Sometimes") || oilAndButter.equals("sometimes"))
		{
			return 0;
		}
		if (oilAndButter.equals("Often") || oilAndButter.equals("often"))
		{
			return -3;
		}
		else
		{
			return -6;
		}
	}
	public int eggsIndex (int eggs)
	{
		if (eggs==0)
		{
			return 2;
		}
		else if ((eggs>=1) && (eggs<=4))
		{
			return 0;
		}
		else if ((eggs>=5) && (eggs<=8))
		{
			return -2;
		}
		else
		{
			return -4;
		}
	}
	
	public int highFatDessertsIndex (int highFatDesserts)
	{
		if (highFatDesserts==0)
		{
			return 0;
		}
		else if ((highFatDesserts>=1) && (highFatDesserts<=3))
		{
			return -2;
		}
		else if ((highFatDesserts>=4) && (highFatDesserts<=6))
		{
			return -4;
		}
		else
		{
			return -6;
		}
	}
}
