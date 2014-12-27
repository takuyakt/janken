package janken.object;

public interface Tactics {

	/**
	 * 戦略を読み、ジャンケンの手を得る。
	 * グー・チョキ・パーをPlayerクラスに定義された以下の定数で返す。
	 * @return
	 */
	public int readTactics();

}
