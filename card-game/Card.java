/**
 * This program creates the Card class
 * which creates a card with a suit and rank
 * and implements the Comparable interface. 
 * 
 * @author: Ada Glinski 
 * @UNI: ag4852
 * @date: 3/14/24
 */

public class Card implements Comparable<Card>{
	
    private int suit; //Use integers 1-4 to encode the suit
    private int rank; //Use integers 1-13 to encode the rank
    private static final String[] rankNames = {"","",
        "Two", 
        "Three", 
        "Four",
        "Five",
        "Six",
        "Seven",
        "Eight",
        "Nine",
        "Ten",
        "Jack", //11
        "Queen", //12
        "King", //13
        "Ace" //14
    };
	
    public Card(int s, int r){
        //Makes a card with suit s and rank r
        this.suit = s; 
        this.rank = (r==1) ? 14 : r;
    }

    public Card(String s, int r){
        switch(s){
            case "c": 
                this.suit = 1;
                break;
            case "d":
                this.suit = 2;
                break;
            case "h":
                this.suit = 3;
                break;
            case "s":
                this.suit = 4;
                break;
        }
        this.rank = (r==1) ? 14 : r;
    }
	
    public int compareTo(Card c){
        //First compares rank, if they are the same, then compares suit.
        if(this.rank - c.getRank() != 0){
            return this.rank - c.getRank();
        }
        else{
            return this.suit - c.getSuit();
        }
    }
	
    public int getSuit(){
        return suit;
    }

    public int getRank(){
        return rank;
    }

    public String toString(){
        return rankNames[this.rank]+" of "+decodeSuit(this.suit);
    }
    
    //Converts encoded integer into respective suit.
    public String decodeSuit(int s){
        String decodedSuit = "";
        switch(s) {
            case 1:
                decodedSuit = "Clubs";
                break;
            case 2:
                decodedSuit = "Diamonds";
                break;
            case 3: 
                decodedSuit = "Hearts";
                break;
            case 4:
                decodedSuit = "Spades";
                break;
        }
        return decodedSuit;
    }

}
