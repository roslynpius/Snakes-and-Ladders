package com.bridgelabz.Snakes_And_Ladders;
import java.util.Random;

public class SnakesAndLadder {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game!");

        Player p1=new Player();
        System.out.println("Start Position:"+p1.position);
        System.out.println("Roll the Dice!");
        int diceValue=rollDice(p1);

        System.out.print("Dice Value: "+diceValue+"   ");        
        System.out.println("Current Position: "+p1.position);
    }

    /**
     * Player rolls dice and the position is updated
     * 
     * @param p - Player Object.
     * @return diceValue - Value on the dice
     */
    public static int rollDice(Player p){

        Random random = new Random();

        int diceValue= random.nextInt(6) + 1;
        p.position+=diceValue;//updates player position

        return diceValue;
    }

    
    
}
