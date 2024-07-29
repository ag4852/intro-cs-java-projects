Ada Glinski
ag4852

Outside Sources Used: 

Part I
Game.java
This program allows a user to play a session against a computer. 
Instructions for using the software:
     1. The user should input what player they would like to be ('even' or 'odd').
     2. The first game will begin. The user should input either 1 or 2. 
     3. The computer will play and the result of the game will be displayed.
     Then, the user should input whether they would like to continue or not ('Y' or 'N').
     4. When the session ends, the results will be displayed. 

Implementation: 
The following instance variables were used to keep track of the 
human player:
     boolean isHumanPlayerOdd 
     int humanTokens

For each game, the human choice and computer choice
was summed and stored in the variable sumOfChoices. 
An if statement was used to check if the human player won. 
This occurred with 2 cases:
     1. isHumanPlayerOdd = true and sumOfChoices is odd
     2. isHumanPlayerOdd = false and sumOfChoices is even
Based on the winner, sumOfChoices was added/subtracted to humanTokens 
and the opposite done to ComputerPlayer's tokenBalance through
the updateScore method.  

Finally, a while loop with the boolean keepPlaying was used to determine whether the session
should continue or not. If the user inputs 'N', keepPlaying becomes false. 

The winner was determined by whoever had a score > 0. Scores were displayed
using humanTokens and ComputerPlayer's getScore method. 

ComputerPlayer.java
This class was used to keep track of the ComputerPlayer's threshold and tokenBalance. 
The following methods were implemented: 
     1. getScore() which returned tokenBalance. 
     2. updateScore(int tokens) which adds the input parameter to tokenBalance.
     3. move() which returned the computer move based on its threshold value. 

Part II 
Game.java
This program plays computer against computer, with an int parameter indicating
the number of games to be played, with Player 1 as the odd player, and Player 2 as the even player.

Implementation:
A for loop was used to keep track of the number of games in the session.  
ComputerPlayers p1 (Odd) and p2 (Even) were created. 
The move() method was used to determine their choice during each game. 
An if statement was used to check if sumOfComputerScores was odd,
indicating that Player 1 won. If not, Player 2 won. 
updateScore(sumOfComputerScores) was used to update the tokenBalance of each ComputerPlayer,
with the loser having the negation of sumOfComputerScores as the input parameter. 

Simulation.java
This program determined whether or not the game was fair, by checking for each combination 
of threshold values for each computer player, if there was a strategy that guaranteed a positive 
average outcome regardless of the other player's strategy. 

t1 = i1*0.05 = Threshold value for Player 1
t2 = i2*0.05 = Threshold value for Player 2
Nested for loops i1 and i2 range from 0-20, 
so that t1 and t2 range from 0.00 to 1.00 in 0.05 intervals.  

For each threshold value combination, numOfRounds games are played, and 
the average score for Player 1 is calculated by dividing the total score by the numOfRounds. 

A visual result of the nested for loop is shown below. 
It is the average score for Player 1 for each threshold combination (t1, t2). 

Each row represents a constant value of Player 1's threshold t1,  
which is played against every value of Player 2's threshold t2.
Each column represents a constant value of Player 2's threshold t2, 
which is played against every value of Player 1's threshold t1. 

The minimum score is found by finding the minimum score 
of each row (For Player 1) or column (For Player 2).

Note: The average score for Player 2 was not kept track of because it is
simply the negation of Player 1's score. 

The game is unfair, if regardless of the other player's strategy, the minimum score > 0. 
In this case, Player 1 has an advantage when their threshold value = 0.60, because 
no matter what threshold value Player 2 takes, there is a positive average 
outcome.  When t1 = 0.60, the average winning of every column > 0. 

There is no such advantage for Player 2. 

Therefore, it is better to be the odd player. The winning strategy is to be the odd player and use the threshold 0.60. 

Sample result of average scores for Player 1 for every threshold combination (t1, t2): 
     t2 =  0.00  0.05  0.10  0.15  0.20  0.25  0.30  0.35  0.40  0.45  0.50  0.55  0.60  0.65  0.70  0.75  0.80  0.85  0.90  0.95  1.00
t1 = 0.00 -4.00 -3.65 -3.30 -2.95 -2.60 -2.25 -1.90 -1.55 -1.20 -0.85 -0.50 -0.15  0.20  0.55  0.91  1.25  1.60  1.95  2.30  2.65  3.00
t1 = 0.05 -3.65 -3.33 -3.01 -2.70 -2.37 -2.06 -1.73 -1.40 -1.09 -0.77 -0.45 -0.13  0.19  0.51  0.83  1.15  1.47  1.79  2.12  2.43  2.75
t1 = 0.10 -3.30 -3.01 -2.72 -2.43 -2.14 -1.85 -1.56 -1.27 -0.98 -0.69 -0.39 -0.11  0.18  0.47  0.76  1.05  1.34  1.63  1.92  2.21  2.50
t1 = 0.15 -2.95 -2.69 -2.43 -2.18 -1.91 -1.65 -1.39 -1.12 -0.87 -0.62 -0.35 -0.09  0.17  0.43  0.69  0.95  1.21  1.47  1.73  1.99  2.25
t1 = 0.20 -2.60 -2.37 -2.14 -1.91 -1.68 -1.46 -1.22 -0.99 -0.76 -0.53 -0.31 -0.07  0.16  0.39  0.62  0.85  1.08  1.31  1.54  1.77  2.00
t1 = 0.25 -2.25 -2.05 -1.84 -1.65 -1.45 -1.25 -1.05 -0.85 -0.65 -0.45 -0.25 -0.05  0.15  0.35  0.54  0.75  0.95  1.15  1.35  1.55  1.75
t1 = 0.30 -1.90 -1.73 -1.56 -1.39 -1.22 -1.05 -0.87 -0.71 -0.54 -0.37 -0.20 -0.02  0.14  0.30  0.48  0.65  0.82  0.99  1.16  1.33  1.50
t1 = 0.35 -1.55 -1.41 -1.27 -1.13 -0.99 -0.85 -0.70 -0.56 -0.43 -0.29 -0.15 -0.01  0.13  0.27  0.41  0.55  0.69  0.83  0.97  1.11  1.25
t1 = 0.40 -1.20 -1.09 -0.98 -0.87 -0.76 -0.65 -0.54 -0.43 -0.32 -0.21 -0.10  0.01  0.12  0.23  0.34  0.45  0.56  0.67  0.78  0.89  1.00
t1 = 0.45 -0.85 -0.78 -0.69 -0.61 -0.53 -0.45 -0.37 -0.29 -0.21 -0.14 -0.05  0.03  0.11  0.19  0.27  0.35  0.43  0.51  0.59  0.67  0.75
t1 = 0.50 -0.50 -0.45 -0.40 -0.35 -0.30 -0.25 -0.20 -0.15 -0.10 -0.05  0.00  0.05  0.10  0.15  0.20  0.25  0.30  0.35  0.40  0.45  0.50
t1 = 0.55 -0.15 -0.13 -0.11 -0.09 -0.07 -0.05 -0.03 -0.01  0.01  0.03  0.05  0.07  0.09  0.11  0.13  0.15  0.17  0.19  0.21  0.22  0.25
t1 = 0.60  0.20  0.19  0.18  0.17  0.16  0.15  0.14  0.13  0.12  0.12  0.10  0.08  0.08  0.07  0.06  0.05  0.04  0.03  0.02  0.01  0.00
t1 = 0.65  0.54  0.51  0.47  0.43  0.39  0.35  0.31  0.27  0.23  0.19  0.15  0.11  0.07  0.03 -0.01 -0.05 -0.09 -0.13 -0.17 -0.21 -0.25
t1 = 0.70  0.90  0.83  0.76  0.69  0.62  0.55  0.48  0.41  0.33  0.27  0.20  0.13  0.06 -0.01 -0.08 -0.14 -0.22 -0.29 -0.36 -0.43 -0.50
t1 = 0.75  1.25  1.14  1.05  0.95  0.85  0.75  0.65  0.55  0.45  0.35  0.25  0.15  0.05 -0.05 -0.15 -0.25 -0.35 -0.46 -0.55 -0.65 -0.75
t1 = 0.80  1.60  1.47  1.34  1.21  1.08  0.95  0.82  0.69  0.55  0.43  0.30  0.17  0.04 -0.09 -0.22 -0.35 -0.48 -0.61 -0.74 -0.87 -1.00
t1 = 0.85  1.95  1.79  1.63  1.47  1.31  1.15  0.99  0.83  0.67  0.51  0.35  0.19  0.03 -0.13 -0.29 -0.45 -0.61 -0.77 -0.93 -1.09 -1.25
t1 = 0.90  2.30  2.11  1.92  1.73  1.54  1.35  1.16  0.97  0.78  0.59  0.40  0.21  0.02 -0.17 -0.36 -0.55 -0.74 -0.93 -1.12 -1.31 -1.50
t1 = 0.95  2.65  2.43  2.21  1.98  1.77  1.55  1.33  1.11  0.90  0.67  0.45  0.23  0.01 -0.21 -0.43 -0.65 -0.87 -1.09 -1.31 -1.53 -1.75
t1 = 1.00  3.00  2.75  2.50  2.25  2.00  1.75  1.50  1.25  1.00  0.75  0.49  0.25 -0.00 -0.25 -0.50 -0.75 -1.00 -1.25 -1.50 -1.75 -2.00