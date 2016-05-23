
public class Worker {

static private int miner = 10;
static private int lumberjack = 10;

	static public int getMiner()
	{
		return miner;
	}
	
	static public int setMiner(int Miner)
	{
		return miner = Miner;
	}
	
	static public int getLumber()
	{
		return lumberjack;
	}
	
	static public int setLumber(int Lumbers)
	{
		return lumberjack = Lumbers;
	}
	
	public static int goldRate()
	{
		return (int) Math.pow(miner, 1.75) + 7;
	}
	
	public static int woodRate()
	{
		return (int) Math.pow(lumberjack, 1.75) + 7;
	}
}