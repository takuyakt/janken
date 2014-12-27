package janken.object;

public class Judge {

	public void startJanken(Player player1 , Player player2)
	{
		//プログラム開始
		System.out.println("[ジャンケン開始]\n");

		for (int cnt = 0 ; cnt < 3 ; cnt++)
		{
			System.out.println("["+(cnt+1)+"]回戦目");


			Player winner = judgeJanken(player1,player2);

			if(winner != null)
			{
				System.out.println("\n"+winner.getName()+"が勝ちました！\n");
				//勝ちを伝える。
				winner.notifyResult(true);
			}else{
				System.out.println("\n引き分けです！\n");
			}
		}

		System.out.println("[ジャンケン終了]\n");

		Player finalWinner = judgeFinalWinner(player1,player2);

		//結果の表示

		System.out.println(player1.getWinCount()+" 対  "+player2.getWinCount()+" で ");

		if(finalWinner !=null)
		{
			System.out.println(finalWinner.getName()+"の勝ちです！\n");
		}else{
			System.out.println("引き分けです！\n");
		}
	}

	/**
	 * 最終的な勝者を判定する。
	 * @param player1
	 * @param player2
	 * @return 勝ったプレイヤー。引き分けの場合はnull
	 */
	private Player judgeFinalWinner(Player player1, Player player2) {

		Player winner = null ;

		int player1WinCount = player1.getWinCount();
		int player2WinCount = player2.getWinCount();

		if (player1WinCount > player2WinCount)
		{
			winner = player1;
		}else if (player1WinCount < player2WinCount){
			winner = player2;
		}

		return winner ;
	}

	/**
	 * ジャンケンの手を表示する。
	 * @param playerHand
	 */
	private void printHand(int playerHand) {

		switch(playerHand)
		{
			case Player.STONE:
				System.out.println("グー");
				break;

			case Player.SCRISSORS:
				System.out.println("チョキ");
				break;

			case Player.PAPER:
				System.out.println("パー");
				break;

			default:
				break;
		}

	}

	/**
	 * ジャンケンポンと声をかける。
	 * プレイヤーの手を見て、どちらが勝ちか判定する。
	 * @param player1
	 * @param player2
	 * @return
	 */
	private Player judgeJanken(Player player1, Player player2) {
		Player winner = null ;

		int player1hand = player1.showHand();
		int player2hand = player2.showHand();

		printHand(player1hand);
		System.out.println(" vs. ");
		printHand(player2hand);
		System.out.println("\n");

		//プレイヤー１が勝つ場合、
		if((player1hand == Player.STONE && player2hand == Player.SCRISSORS)||
			(player1hand == Player.SCRISSORS && player2hand == Player.PAPER)||
			(player1hand == Player.PAPER && player2hand == Player.STONE))
		{
			winner = player1;
		}else if ((player1hand == Player.STONE && player2hand == Player.PAPER)||
				(player1hand == Player.SCRISSORS && player2hand == Player.STONE)||
				(player1hand == Player.PAPER && player2hand == Player.SCRISSORS))
		{
			winner = player2;
		}

		return winner;
	}
}
