package janken.object;

public class ObjectJanken {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 審判
		Judge saito = new Judge();

		//player1
		Player murata = new Player("村田さん");

		Tactics murataTactics = new AskTactics();

		murata.setTactics(murataTactics);

		//player2
		Player yamada = new Player("山田さん");

		Tactics yamadaTactics = new RandomTactics();

		yamada.setTactics(yamadaTactics);

		saito.startJanken(murata, yamada);

	}

}
