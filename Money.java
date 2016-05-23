
public class Money extends Worker{

	static private int gold = 50;
	
	public static int getGold()
	{
		return gold;
	}
	
	public static int setGold(int goldInput)
	{
		return gold = goldInput;
	}
	
	public static int farmGold()
	{
		return Worker.goldRate();
	}
}
