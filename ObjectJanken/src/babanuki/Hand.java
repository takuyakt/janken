package babanuki;

import java.util.ArrayList;
import java.util.List;

public class Hand {

	private List<Card> hand_ = new ArrayList<Card>() ;

	public void addCard(Card card)
	{
		hand_.add(card);
	}

	/**
	 *
	 * @return
	 */
	public Card pickCard()
	{
		Card pickedCard = hand_.remove(0);
		return pickedCard ;
	}

	/**
	 *
	 */
	public void shuffle()
	{
		int number = hand_.size();
		int pos ;

		//シャッフルする。
		for(int count = 0 ; count < number * 2 ; count++)
		{
			pos = (int)(Math.random() * number );
			Card pickedCard = hand_.remove(pos);
			hand_.add(pickedCard);
		}
	}

	/**
	 *
	 * @return
	 */
	public int getNumberOfCards()
	{
		return hand_.size();
	}

	/**
	 * 同じカードを探す。
	 */

	public Card[] findSameNumberCard()
	{
		int numberOfCards = hand_.size();
		Card[] sameCards = null ;

		if (numberOfCards > 0)
		{
			int lastIndex = numberOfCards - 1 ;
			Card lastAddedCard = hand_.get(lastIndex);

			int lastAddedCardNum = lastAddedCard.getNumber();

			for (int index = 0 ; index < lastIndex ; index++)
			{
				Card card = hand_.get(index);
				if (card.getNumber() == lastAddedCardNum)
				{
					sameCards = new Card[2] ;
					sameCards[0] = hand_.remove(lastIndex) ;
					sameCards[1] = hand_.remove(index) ;

					break ;
				}
			}
		}
		return sameCards ;
	}

	public String toString()
	{
		StringBuffer string = new StringBuffer();

		int size  = hand_.size();

		if (size > 0 ){
			for (int i = 0 ; i < size ; i++)
			{
				string.append(hand_.get(i));
				string.append(" ");
			}
		}
		return string.toString() ;
	}

}
