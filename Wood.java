
public class Wood extends Worker{

static private int wood = 50;
	
	static public int getWood()
	{
		return wood;
	}
	
	public static int setWood(int input)
	{
		return wood = input;
	}
	
	public static int farmWood()
	{
		return Worker.woodRate();
	}
}
