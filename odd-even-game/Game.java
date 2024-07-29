/**
 * This class represents the Odd-Even game
 * 
 * @author: Ada Glinski 
 * @UNI: ag4852
 * @date: 3/8/24
 */

import java.util.Scanner;

public class Game{
    
    boolean isHumanPlayerOdd;
    int humanTokens;
    ComputerPlayer cplayer = new ComputerPlayer();
    ComputerPlayer p1; 
    ComputerPlayer p2;
    
    public Game(){
        humanTokens = 0;
    }
    
    //Sets the initial thresholds for two computer players 
    public Game (double t1, double t2){
        p1 = new ComputerPlayer(t1);
        p2 = new ComputerPlayer(t2);
    }
    
    /* 
    * Plays one complete interactive session
    * of odd-even until the user wishes to quit. 
    */
    public void playSession(){
        System.out.println("\n Welcome to the odd even game! ");
        System.out.println("******************************");
        Scanner input = new Scanner(System.in);
        System.out.print("Would you like to be the 'odd' or 'even' player? ");
        String answer = input.nextLine();
        if(answer.equalsIgnoreCase("odd"))
            isHumanPlayerOdd = true;
        else
            isHumanPlayerOdd = false;

        boolean keepPlaying = true;
        while(keepPlaying){
            System.out.print("Would you like to declare 1 or 2? ");
            int humanChoice = input.nextInt();
            int computerChoice = cplayer.move();
            int sumOfChoices = humanChoice+computerChoice;

            /*
            * The winner of the game will add the sum of tokens and
            * the loser will have the sum of tokens subtracted. 
            */
            //When human is the winner
            if((sumOfChoices%2==0 && !isHumanPlayerOdd) ||
                (sumOfChoices%2==1 && isHumanPlayerOdd)){
                humanTokens += sumOfChoices;
                cplayer.updateScore(sumOfChoices*-1);
                System.out.println("You played "+humanChoice+", computer played "
                +computerChoice+". You win "+sumOfChoices+" tokens! ");
            }
            //When computer is the winner
            else{
                humanTokens -= sumOfChoices;
                cplayer.updateScore(sumOfChoices);
                System.out.println("You played "+humanChoice+", computer played "
                +computerChoice+". You lost "+sumOfChoices+" tokens! ");
            }

            System.out.print("Would you like to keep playing? (Y or N) ");
            input.nextLine();
            String strKeepPlaying = input.nextLine();
            if(strKeepPlaying.equalsIgnoreCase("N"))
                keepPlaying = false;
        }

        if(humanTokens>0)
            System.out.println("You win!");
        else
            System.out.println("You lost.");
        System.out.println("You have "+humanTokens+" tokens. "+ 
        "The computer has "+cplayer.getScore()+" tokens.");
        System.out.println("******************************");
    }
    
    /*
    * Plays computer against computer, with int parameter indicating
    * the number of games to be played. 
    * Player 1 is the odd player, player 2 is the even player.
    */
    public void play(int games){
        for(int i=0; i<games; i++){
            int s1 = p1.move();
            int s2 = p2.move();
            int sumOfComputerScores = s1+s2;
            //When Player 1 wins
            if(sumOfComputerScores%2==1){
                p1.updateScore(sumOfComputerScores);
                p2.updateScore(sumOfComputerScores*-1);
            }
            //When Player 2 wins
            else{
                p1.updateScore(sumOfComputerScores*-1);
                p2.updateScore(sumOfComputerScores);
            }
        }
    }

    //Returns Player 1 current score
    public int getP1Score(){
        return p1.getScore();
    }

    //Returns Player 2 current score
    public int getP2Score(){
        return p2.getScore();
    }  
    
}