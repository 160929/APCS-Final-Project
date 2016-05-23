
public class Buildings {

	private int goldCost;
	private int woodCost;
	private int capacity;
	private String name;
	
	public int getgoldCost()
	{
		return goldCost;
	}
	
	public int getwoodCost()
	{
		return woodCost;
	}
	
	public int getcapacity()
	{
		return capacity;
	}
	
	public String getname()
	{
		return name;
	}
	
	public Buildings(){
		goldCost = 0;
		woodCost = 0;
		capacity = 0;
		name = "No name";
	} 
	
	public Buildings(int money, int wood, int size, String InputName)
	{
		goldCost = money;
		woodCost = wood;
		capacity = size;
		name = InputName;
	}
	
}
