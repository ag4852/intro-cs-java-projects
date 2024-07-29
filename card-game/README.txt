Ada Glinski
ag4852

Outside Sources Used: Java ArrayList - GeeksForGeeks, 
Substring in Java - GeeksForGeeks,
Java Ternary Operator with Examples - GeeksForGeeks
Reading a String after an Integer - Dev.to

Card.java
This program creates the Card class which creates an encoded card with a suit (1-4) and rank (1-13)
and implements the Comparable interface. 
The following methods were implemented: 
    1. compareTo() which first compares rank, if they are the same, then compares suit.
    2. decodeSuit() which converts encoded integer into respective suit.
    3. toString() which decodes and returns the card. 
The private String rankNames was used to decode the rank of each card. 

Deck.java
This program creates the Deck class which creates a deck of standard playing cards
and has shuffle, deal, and toString functionality. 
The following methods were implemented: 
    1. shuffle() which loops through entire deck of cards, each time generating a 
       randomCardIndex to swap the current card with to shuffle the deck. 
    2. deal() which deals the top card and resets the top when the cards run out.
    3. toString() which returns the cards in the deck. 
    4. getCard() which returns the card at a given index. 

Game.java
This program creates the Game class which allows a Player to play video poker. 
At the start of the game, a new Player is created. 
Implementation of functionality
    1. Card exchange: Used ArrayList set method to replace card from 
                      Player input with a card from the top of the deck. 
    2. checkHand(): A method was created to check for each type of winning hand.
                    Returns the payout. When checking for a Straight, considered 
                    Ace as both 1 and 14. 
    3. playAgain: String based on Player input. A while loop was used to keep track of 
                  whether another round should be played, carrying over the data of the Player. 

Player.java
This program creates the Player class which keeps track of the bankroll 
and amount bet for each session. 
