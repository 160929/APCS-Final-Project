import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import java.util.Timer;

public class GraphicalUserInterface extends JFrame
									implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton buy, mine, chop, instructions, cheat;
	private JTextField GoldText, WoodText, MinerText, LumberText, CapacityText;
	JTextArea statsOut = new JTextArea(30, 35);
	String MiningText = "";
	String ChoppingText = "";
	int WoodCounter, GoldCounter;
	
		public GraphicalUserInterface()
		{
			super("Civilization 6");
			Container c = getContentPane();
			c.setLayout(new FlowLayout());
			
			
			buy = new JButton("buy");
			buy.addActionListener(this);
			buy.setActionCommand("buying");
			c.add(buy);
			
			
			mine = new JButton("mine");
			mine.addActionListener(this);
			mine.setActionCommand("mining");
			c.add(mine);
			
			chop = new JButton("chop");
			chop.addActionListener(this);
			chop.setActionCommand("chopping");
			c.add(chop); 
			
			instructions = new JButton("instructions");
			instructions.addActionListener(this);
			instructions.setActionCommand("instructions");
			c.add(instructions); 
			
			cheat = new JButton("cheat");
			cheat.addActionListener(this);
			cheat.setActionCommand("cheating");
			c.add(cheat);
			
			c.add(statsOut);
			
			c.add(new JLabel("    Gold:"));
			GoldText = new JTextField(12);
			GoldText.setEditable(false);
			GoldText.addActionListener(this);
			c.add(GoldText);
			GoldText.setText("" + Money.getGold());
			
			c.add(new JLabel("Wood:"));
			WoodText = new JTextField(12);
			WoodText.setEditable(false);
			WoodText.addActionListener(this);
			c.add(WoodText);
			WoodText.setText("" + Wood.getWood());
			
			c.add(new JLabel("Miners:"));
			MinerText = new JTextField(12);
			MinerText.setEditable(false);
			MinerText.addActionListener(this);
			c.add(MinerText);
			MinerText.setText("" + Worker.getMiner());
			
			c.add(new JLabel("Lumberjacks:"));
			LumberText = new JTextField(12);
			LumberText.setEditable(false);
			LumberText.addActionListener(this);
			c.add(LumberText);
			LumberText.setText("" + Worker.getLumber());
			
			c.add(new JLabel("Capacity Left:"));
			CapacityText = new JTextField(12);
			CapacityText.setEditable(false);
			CapacityText.addActionListener(this);
			c.add(CapacityText);
			CapacityText.setText("" + Capacity.getCapacity());
			
		}
		
		
public void actionPerformed(ActionEvent e)
{
	
	if(e.getActionCommand() == "buying")
	{
		GoldText.setText("" + Money.getGold());
		WoodText.setText("" + Wood.getWood());
		MinerText.setText("" + Worker.getMiner());
		LumberText.setText("" + Worker.getLumber());
		CapacityText.setText("" + Capacity.getCapacity());
		String buyText = "";
		for (int i=0; i<28; i++)
		{
			buyText += ItemBuy.building[i].getname() 
					+ "Gold: " +ItemBuy.building[i].getgoldCost()
					+ " Wood: " +ItemBuy.building[i].getwoodCost()
					+ " Capacity: " +ItemBuy.building[i].getcapacity()
					+ "\n";
		}
		statsOut.setText(buyText);
		
		int buying = Integer.parseInt( JOptionPane.showInputDialog("What do you wish to buy?"));
		if(buying > 0 && buying <29)
		{
			if (Money.getGold() >= ItemBuy.building[buying-1].getgoldCost() 
			 && Wood.getWood() >= ItemBuy.building[buying-1].getwoodCost())
			{	
			Money.setGold(Money.getGold() - ItemBuy.building[buying-1].getgoldCost());
			GoldText.setText("" + Money.getGold());
			Wood.setWood(Wood.getWood() - ItemBuy.building[buying-1].getwoodCost());
			WoodText.setText("" + Wood.getWood());
			Capacity.setCapacity(Capacity.getCapacity() + ItemBuy.building[buying-1].getcapacity());
			CapacityText.setText("" + Capacity.getCapacity());
			
			if (buying == 27 && Capacity.getCapacity() == -1)
			{
				JOptionPane.showMessageDialog(null, "You don't have enough space! Buy more buildings.", "Alert", JOptionPane.ERROR_MESSAGE);
				Capacity.setCapacity(Capacity.getCapacity()+1);
				CapacityText.setText("" + Capacity.getCapacity());
				Wood.setWood(Wood.getWood() + 100);
				WoodText.setText("" + Wood.getWood());
				
			}
			
			if (buying == 28 && Capacity.getCapacity() == -1)
			{
				JOptionPane.showMessageDialog(null, "You don't have enough space! Buy more buildings.", "Alert", JOptionPane.ERROR_MESSAGE);
				Capacity.setCapacity(Capacity.getCapacity()+1);
				CapacityText.setText("" + Capacity.getCapacity());
				Money.setGold(Money.getGold() + 100);
				GoldText.setText("" + Money.getGold());
			}
			
			else if(buying == 27 && Capacity.getCapacity() > -1)
			{
				Worker.setMiner(Worker.getMiner() +1);
				MinerText.setText("" + Worker.getMiner());
			}
			
			else if (buying == 28 && Capacity.getCapacity() > -1)
			{
				Worker.setLumber(Worker.getLumber() +1);
				LumberText.setText("" + Worker.getLumber());
			}
			
			}
			
			else
			{
				JOptionPane.showMessageDialog(null, "You don't have enough resources!", "Alert", JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Must be an integer between 1 and 28", "Alert", JOptionPane.ERROR_MESSAGE);
		}
			
	}
	
	else if (e.getActionCommand() == "selling")
	{
		statsOut.setText("Your capacity is: " + Capacity.getCapacity() + "\n");
		GoldText.setText("" + Money.getGold());
		WoodText.setText("" + Wood.getWood());
		MinerText.setText("" + Worker.getMiner());
		LumberText.setText("" + Worker.getLumber());
		CapacityText.setText("" + Capacity.getCapacity());
	}
	
	else if (e.getActionCommand() == "mining")
	{
		statsOut.setText("You now mine " + Money.farmGold() + " gold every day");
		GoldText.setText("" + Money.getGold());
		WoodText.setText("" + Wood.getWood());
		MinerText.setText("" + Worker.getMiner());
		LumberText.setText("" + Worker.getLumber());
		CapacityText.setText("" + Capacity.getCapacity());
		
		if (JOptionPane.showConfirmDialog(null, "Do you want to mine?", "Mine",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ 
			
			final Timer MiningTimer = new Timer();
			MiningTimer.schedule(new TimerTask() {
			    public void run() {
			    GoldCounter++;
			    MiningText = MiningText + "----";
			   	statsOut.setText(MiningText);
			   	Money.setGold(Money.getGold() + Money.farmGold());
			   	GoldText.setText("" + Money.getGold());
			   	
			   	if (GoldCounter > 11)
			   	{
			   		MiningTimer.cancel();
			   		JOptionPane.showMessageDialog(null, "You now have " + Money.getGold() + " gold");
			   		GoldCounter = 0;
			   		MiningText = "";
			   	}
			    }
			}, 0, 1360);
        }
		else;
          
	}
	
	else if (e.getActionCommand() == "chopping")
	{
		statsOut.setText("You now chop " + Wood.farmWood() + " wood every day");
		GoldText.setText("" + Money.getGold());
		WoodText.setText("" + Wood.getWood());
		MinerText.setText("" + Worker.getMiner());
		LumberText.setText("" + Worker.getLumber());
		CapacityText.setText("" + Capacity.getCapacity());
		
		if (JOptionPane.showConfirmDialog(null, "Do you want to chop?", "Chop",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ 
			
			final Timer WoodTimer = new Timer();
			WoodTimer.schedule(new TimerTask() {
			    public void run() {
			    WoodCounter++;
			    ChoppingText = ChoppingText + "----";
			   	statsOut.setText(ChoppingText);
			   	Wood.setWood(Wood.getWood() + Wood.farmWood());
			    WoodText.setText("" + Wood.getWood());
			   	
			   	if (WoodCounter > 11)
			   	{
			   		WoodTimer.cancel();
			   		JOptionPane.showMessageDialog(null, "You now have " + Wood.getWood() + " wood");
			   		WoodCounter = 0;
			   		ChoppingText = "";
			   	}
			    }
			}, 0, 1360);
			
        }
		else;
	}
	else if (e.getActionCommand() == "instructions")
	{
		statsOut.setText("Hi! Welcome to Luc Dowell's Game, Miners and Choppers. \n"
						+ "In this game, your objective is to mine the most gold and chop \n"
						+ "the most wood as you can, while expanding your population!\n \n"
						+ "Buildings provide more capacity.\n"
						+ "Miners and lumberjacks provide more resources! \n"
						+ "Good Luck!");
	}
	else if(e.getActionCommand() == "cheating")
	{
		if (JOptionPane.showConfirmDialog(null, "Do you want to cheat?", "Cheat",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){ 
				statsOut.setText("You think cheating would be this easy?");
				for(int i=0; i<99999; i++)
				{
					loop();
				}
				
	}
	}
	
		return;

}


public void loop()
{
	while(true)
	{
	JOptionPane.showOptionDialog(null, "Cheating is bad!", "Cheating!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
	}
}
			
public static void main(String[] args)
{
	GraphicalUserInterface window = new GraphicalUserInterface();
	window.setBounds(100, 100, 470, 650);
	window.setDefaultCloseOperation(EXIT_ON_CLOSE);
	window.setResizable(false);
	window.setVisible(true);
}
}