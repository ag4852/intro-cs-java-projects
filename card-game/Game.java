/**
 * This program creates the Game class
 * which allows a Player to play video poker. 
 * 
 * @author: Ada Glinski 
 * @UNI: ag4852
 * @date: 3/27/24
 */

import java.util.ArrayList;
import java.util.Collections; 
import java.util.Scanner;

public class Game {
	
    private Player p;
    private Deck cards;
    private ArrayList<Card> hand = new ArrayList<Card>();
    private double tokens;	
	
    public Game(String[] testHand){
		for(int i=0; i<testHand.length; i++){
            //Splits input string into suit (First character) and rank (The rest)
            hand.add(new Card(testHand[i].substring(0,1),
                              Integer.valueOf(testHand[i].substring(1))));
        }
    }
	
    public Game(){
        this.cards = new Deck();
        this.cards.shuffle();
        this.tokens = 50.0; 

        for(int i=0; i<5; i++){
            this.hand.add(this.cards.deal());
        }
    }
	
    public void play(){
        System.out.println("Welcome to Video Poker!");
        Player player = new Player();
        System.out.println("YOUR TOKENS: "+player.getBankroll());
        Scanner reader = new Scanner(System.in);

        String playAgain = "y";
        while(playAgain.equalsIgnoreCase("y")){
            cards.shuffle();
            int bet = -1;
            while(bet<1 || bet>5){
                System.out.print("How many tokens to bet this hand? (1 to 5): ");
                if(reader.hasNextInt())
                    bet = reader.nextInt();
                else
                    reader.next();
            }
            player.bets(bet);

            printHand();

            System.out.print("\nHow many cards (0-5) would you like to exchange? ");
            int exchangeCard = reader.nextInt();
        
            for(int j=0; j<exchangeCard; j++){
                System.out.print("Which card (1-5) would you like to exchange? ");
                int replaceCardNum = reader.nextInt()-1;
                hand.set(replaceCardNum, cards.deal());
            }

            printHand();
            int payout = checkHand()*player.getBet();

            System.out.println("\nPAYOUT: "+payout+" tokens");
            player.winnings(payout);
            System.out.println("You have "+player.getBankroll()+" tokens now");

            System.out.print("Would you like to play a round? (y/n):  ");
            reader.nextLine();
            playAgain = reader.nextLine();
        }
        System.out.println("Thank you for playing Video Poker!");
    }
    
    public void testPlay(){
        Collections.sort(hand); 
        for(Card i : hand)
            System.out.println(i);
        
        int tokens = checkHand();
        System.out.println(tokens);
    }
	
	public int checkHand(){
        if(checkRoyalFlush()){
            System.out.println("Royal Flush");
            return 250;
        }
        else if(checkStraightFlush()){
            System.out.println("Straight Flush");
            return 50;
        }
        else if(checkFourOfAKind()){
            System.out.println("Four Of a Kind");
            return 25;
        }
        else if(checkFullHouse()){
            System.out.println("Full House");
            return 6;
        }
        else if(checkFlush()){
            System.out.println("Flush");
            return 5;
        }
        else if(checkStraight()){
            System.out.println("Straight");
            return 4;
        }
        else if(checkThreeOfAKind()){
            System.out.println("Three Of a Kind");
            return 3;
        }
        else if(checkTwoPairs()){
            System.out.println("Two Pairs");
            return 2;
        }
        else if(checkOnePair()){
            System.out.println("One Pair");
            return 1;
        }
        else{
            System.out.println("No Pair");
            return -1;
        }
    }

    private boolean checkOnePair(){
        int pairs = 0;
        for(int i=0; i<=3; i++){
           if(hand.get(i).getRank() == hand.get(i+1).getRank())
                pairs++;
        }
        if(pairs==1)
            return true;
        return false;
    }

    private boolean checkTwoPairs(){
        int pairs = 0;
        for(int i=0; i<=3; i++){
           if(hand.get(i).getRank() == hand.get(i+1).getRank())
                pairs++;
        }
        if(pairs==2)
            return true;
        return false;
    }

    private boolean checkThreeOfAKind(){
        for(int i=0; i<=2; i++){
           if(hand.get(i).getRank() == hand.get(i+1).getRank() &&
              hand.get(i).getRank() == hand.get(i+2).getRank())
                return true;
        }
        return false;
    }

    private boolean checkStraight(){
        if(hand.get(0).getRank()== 2 && 
           hand.get(1).getRank()== 3 && 
           hand.get(2).getRank()== 4 && 
           hand.get(3).getRank()== 5 && 
           hand.get(4).getRank()== 14)
                return true;
            
        int currentRank = hand.get(0).getRank();
        for(int i=currentRank; i<=currentRank+4; i++){
            if(hand.get(i-currentRank).getRank() != i)
                return false;
        }
        return true;
    }

    private boolean checkFlush(){
        int currentSuit = hand.get(0).getSuit();
        for(Card c : hand){
            if(c.getSuit() != currentSuit)
                return false;
        }
        return true;  
    }

    private boolean checkFullHouse(){
        if(hand.get(0).getRank() == hand.get(1).getRank() &&
           hand.get(2).getRank() == hand.get(3).getRank() &&
           hand.get(2).getRank() == hand.get(4).getRank())
            return true;
        else if(hand.get(0).getRank() == hand.get(1).getRank() &&
               hand.get(0).getRank() == hand.get(2).getRank() &&
               hand.get(3).getRank() == hand.get(4).getRank())
                return true;
        return false;
    }

    private boolean checkFourOfAKind(){
        for(int i=0; i<=1; i++){
            int currentRank = hand.get(i).getRank();
            if(currentRank == hand.get(i+1).getRank() &&
               currentRank == hand.get(i+2).getRank() &&
               currentRank == hand.get(i+3).getRank())
                return true;
        }
        return false;
    }

    private boolean checkStraightFlush(){
        if(checkFlush() && checkStraight())
            return true;
        return false;
    }

    private boolean checkRoyalFlush(){
        if(hand.get(0).getRank()==10 && checkStraight() && checkFlush())
            return true;
        return false;
    }
	
    private void printHand(){
        System.out.println("\nYour hand: ");
        for(int i=0; i<hand.size(); i++){
            System.out.println((i+1)+":  "+hand.get(i).toString());
        }
    }

}
