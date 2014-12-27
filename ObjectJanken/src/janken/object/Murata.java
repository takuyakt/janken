package janken.object;

public class Murata extends Player{

	/**
	 * コンストラクタ
	 * @param name
	 */
	public Murata(String name)
	{
		super(name);
	}


	public int showHand()
	{
		return STONE;
	}
}
