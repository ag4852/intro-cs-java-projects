/**
 * This class represents a computer
 * player in the Odd-Even game
 * 
 * @author: Ada Glinski 
 * @UNI: ag4852
 * @date: 3/8/24
 */


public class ComputerPlayer{
    private double t;
    private int tokenBalance;
    
    public ComputerPlayer(){
        t=0.5;
        tokenBalance=0;
    }
    
    public ComputerPlayer(double threshold){
        this.t = threshold;
        tokenBalance = 0;
    }
    
    //Generates computer move based on threshold value t
    public int move(){
        if(Math.random() > t)
            return 2;
        else    
            return 1;
    }
    
    public int getScore(){
        return tokenBalance;
    }
    
    //Keeps track of computer tokens
    public void updateScore(int tokens){
        tokenBalance += tokens;
    }
    
    
}