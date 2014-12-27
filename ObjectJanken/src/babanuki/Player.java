package babanuki;

public class Player {

	private Master master_;
	private Table table_;
	private Hand myhand_ = new Hand();
	private String name_ ;

	public Player(String name , Master master, Table table)
	{
		this.name_ = name;
		this.master_ = master;
		this.table_ = table;
	}

	public void play(Player nextPlayer)
	{
		Hand nexthand = nextPlayer.showHand();

		Card pickedCard = nexthand.pickCard();

		System.out.println(this + ":" + nextPlayer+ "さんから" + pickedCard + "を引きました。");

		dealCard(pickedCard);

		if ( myhand_.getNumberOfCards() == 0)
		{
			master_.declareWin(this);
		}else{
			System.out.println(this + "残りの手札は" + myhand_ + "です。");
		}


	}

	private void dealCard(Card pickedCard) {

		myhand_.addCard(pickedCard);

		Card[] sameCards =myhand_.findSameNumberCard();

		if (sameCards != null)
		{
			System.out.println(this + ":");
			table_.disposeCard(sameCards);
		}

	}

	private Hand showHand() {

		if (myhand_.getNumberOfCards() == 1)
		{
			master_.declareWin(this);
		}

		myhand_.shuffle();

		return myhand_;
	}

	public void receiveCard(Card card)
	{
		dealCard(card);
	}

	public String toString()
	{
		return name_ ;
	}

}
