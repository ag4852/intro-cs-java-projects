/**
 * This program creates the Player class 
 * which keeps track of the bankroll 
 * and amount bet for each session. 
 * 
 * @author: Ada Glinski 
 * @UNI: ag4852
 * @date: 3/29/24
 */


public class Player {
		
    private int bankroll;
    private int bet;
		
    public Player(){		
        this.bankroll = 50;
    }
		
    public void bets(int amt){
        this.bet = amt;
    }

    public void winnings(int odds){
        this.bankroll += odds;
    }

    public int getBankroll(){
        return this.bankroll;
    }

    public int getBet(){
        return this.bet;
    }
}


