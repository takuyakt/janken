package janken.object;

public class RandomTactics implements Tactics {

	@Override
	public int readTactics() {

		int hand = 0 ;
		double ramdomNum = Math.random() * 3 ;
		if(ramdomNum < 1){
			hand = Player.STONE ;

		}else if(ramdomNum < 2){
			hand = Player.SCRISSORS ;

		}else if(ramdomNum < 3){
			hand = Player.PAPER ;

		}
		return hand;
	}



}
