public class Response {
	private String name;
	private String bloodType;
	private int fastFood;
	private int veg;
	private int oilButter;
	private int eggs;
	private int desserts;
	
	public String getBloodType() {
		return bloodType;
	}
	
	public int getFastFood() {
		return fastFood;
	}
	
	public int getVeg() {
		return veg;
	}
	
	public int getOilAndButter() {
		return oilButter;
	}
	
	public int getEggs() {
		return eggs;
	}
	
	public int getDesserts() {
		return desserts;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	
	public void setFastFood(int fastFood) {
		this.fastFood = fastFood;
	}
	
	public void setVeg(int veg) {
		this.veg = veg;
	}
	
	public void setOilButter(int oilButter) {
		this.oilButter = oilButter;
	}
	
	public void setEggs(int eggs) {
		this.eggs = eggs;
	}
	
	public void setDesserts(int desserts) {
		this.desserts = desserts;
	}

}