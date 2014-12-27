package janken.object;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AskTactics implements Tactics {

	@Override
	public int readTactics() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("\nジャンケンの手を入力してください。");
		System.out.println("0: グー");
		System.out.println("1: チョキ");
		System.out.println("2: パー\n");
		System.out.println("? ");

		int hand = 0;

		while(true)
		{
			try
			{
				String inputStr = br.readLine();

				hand = Integer.parseInt(inputStr);

				if(hand == Player.STONE || hand == Player.SCRISSORS || hand == Player.PAPER)
				{
					break;
				}else{
					System.out.println("入力が正しくありません。再度入力してください。");
					System.out.println("? ");
				}
			}catch(Exception ex){
				System.out.println("入力が正しくありません。再度入力してください。");
				System.out.println("? ");

			}
		}
	return hand ;
	}

}
