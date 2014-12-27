package babanuki;

import java.util.ArrayList;
import java.util.List;

public class Master {

	private List<Player> players_ = new ArrayList<Player>();

	public void preparegame(Hand cards)
	{
		System.out.println("[カードを配ります。]");

		cards.shuffle();
		int numberOfCards = cards.getNumberOfCards();
		int numberOfPlayers = players_.size();

		for (int index = 0 ; index < numberOfCards ; index++)
		{
			Card card = cards.pickCard();
			Player player = players_.get(index % numberOfPlayers);
			player.receiveCard(card);
		}
	}

	public void startGame()
	{
		System.out.println("\n[ばば抜きを開始します。]");
		
		for (int count = 0 ; players_.size() > 1; count++)
		{
			int playerIndex = count % players_.size();
			int nextPlayerIndex = (count + 1 ) % players_.size();

			//指名するプレイヤーの取得
			Player player = players_.get(playerIndex);
			//次のプレイヤーを取得
			Player nextPlayer = players_.get(nextPlayerIndex);

			System.out.println("\n"+ player + "さんの番です。");
			player.play(nextPlayer);
		}

		System.out.println("[ババ抜きを終了しました]");
	}

	public void declareWin(Player winner) {

		System.out.println(winner + "さんが上がりました");

		players_.remove(players_.indexOf(winner));

		if (players_.size() == 1)
		{
			Player loser = players_.get(0);
			System.out.println(loser + "さんの負けです!");
		}
	}

	public void registerPlayer(Player player)
	{
		players_.add(player);
	}
}
