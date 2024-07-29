/**
 * This program creates the Deck class
 * which creates a deck of standard playing cards
 * and has shuffle, deal, and toString functionality. 
 * 
 * @author: Ada Glinski 
 * @UNI: ag4852
 * @date: 3/14/24
 */

public class Deck {
	
    private Card[] cards;
    private int top; //Index of the top of the deck
	
    //Creates organized standard playing card deck. 
    public Deck(){
        cards = new Card[52];
        int cardIndex = 0;
        //Loops through suits, then rank. 
        for(int s=1; s<=4; s++){
            for(int r=1; r<=13; r++){
                cards[cardIndex] = new Card(s,r);
                cardIndex++;
            }
        }
        this.top = 0;
    }
	
    public void shuffle(){
        /*Loops through entire deck of cards, each time generating a randomCardIndex
        to swap the current card with*/
        for(int i=0; i<cards.length; i++){
            //Finds a random number between i and 51
            int randomCardIndex = (int)(Math.random()*cards.length-i)+i;
            //Swaps random card with current card
            Card temp = cards[i];
            cards[i] = cards[randomCardIndex];
            cards[randomCardIndex] = temp;
        }
        this.top = 0;
    }
    
    public Card deal(){
        //Resets top when the cards run out.
        if(this.top > cards.length-1)
            this.top = 0;
        return cards[this.top++];
    }
	
    public String toString(){
        String s = "";
        for(int i=0; i<cards.length; i++){
           s += cards[i].toString() + "\n";
        }
        return s;
    }

    //Returns card at given index. 
    public Card getCard(int cardIndex){
        return this.cards[cardIndex];
    }

}
