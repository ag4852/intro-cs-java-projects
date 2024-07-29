/**
 * This class should run simulations to determine
 * whether or not the Odd-Even game is fair and if
 * not who has the advantage and what is a strategy
 * that will realize that advantage.
 * 
 * @author: Ada Glinski 
 * @UNI: ag4852
 * @date: 3/8/24
 */


public class Simulation{

    static double[][] p1Scores = new double[21][21];
    
    public static void main(String[] args){
        int numOfRounds = 1000000;
        for(int i1=0; i1<21; i1++){
            for(int i2=0; i2<21; i2++){
                double t1 = i1*0.05;
                double t2 = i2*0.05;
                Game g = new Game(t1,t2);
                g.play(numOfRounds); 
                //Calculates average winnings
                p1Scores[i1][i2] = g.getP1Score()/(numOfRounds*1.0); 
            }
        }
        findWinningStrategy("P1");
        findWinningStrategy("P2");
        //printScoreArray();
    }

    /*
    * Finds if there is a winning strategy for the given player.
    */
    public static void findWinningStrategy(String player){
        boolean winningStrategyFound = false;
        //Loops through array of scores
        for(int i1=0; i1<21; i1++){
            double minScore = 0;
            for(int i2=0; i2<21; i2++){
                double currentScore = p1Scores[i1][i2];
                if(player.equals("P2")){
                    //Player 2 score = Player 1 score * -1
                    currentScore = (p1Scores[i2][i1])*(-1.0);
                }
                if(currentScore < minScore)
                    minScore = currentScore;
            }
            if(minScore>=0){
                winningStrategyFound = true;
                System.out.println("Winning strategy found "+player+" = "+String.format("%4.2f", i1*0.05));
            }
            else
                System.out.println("When "+player+" threshold = "+String.format("%4.2f", i1*0.05)+", Min score = "+String.format("%4.2f", minScore));
            
        }
        if(!winningStrategyFound)
            System.out.println("There is no winning strategy for Player "+player);
    }

    public static void printScoreArray(){
        System.out.print(String.format("%9s", "t2 = "));
        for(int i=0; i<21; i++){
            System.out.print(String.format("%6.2f", i*0.05));
        }
        System.out.println();
        for(int i1=0; i1<21; i1++){
            System.out.print("t1 = "+String.format("%4.2f", i1*0.05));
            for(int i2=0; i2<21; i2++){
                System.out.print(String.format("%6.2f", p1Scores[i1][i2]));
            }
            System.out.println();
        }
    }

}