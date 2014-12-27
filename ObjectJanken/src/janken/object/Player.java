package janken.object;

public class Player {

	public static final int STONE = 0 ;
	public static final int SCRISSORS = 1 ;
	public static final int PAPER = 2 ;

	private String name_;
	private int winCount_ ;

	private Tactics tactics_ ;

	public Player(String name)
	{
		name_ = name ;
	}

	void setTactics(Tactics tactics)
	{
		tactics_ = tactics ;
	}


	public int showHand()
	{
		int player1Hand = tactics_.readTactics();

		return player1Hand ;


	}

	public void notifyResult(boolean result)
	{
		if(result)
		{
		winCount_++;
		}
		//System.out.println("\nプレイヤー"+name_+"が勝ちました。\n");
	}

	public int getWinCount()
	{
		return winCount_;
	}

	public String getName()
	{
		return name_;
	}


}
