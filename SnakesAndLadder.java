package com.bridgelabz.Snakes_And_Ladders;

public class SnakesAndLadder {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game!");

        Player p1=new Player();
        System.out.println("Start Position:"+p1.position);
        System.out.println("Roll the Dice!");
        rollDice(p1);
        
    }

    /**
     * Player rolls dice and the position is updated
     * 
     * @param p - Player Object.
     */
    public static void rollDice(Player p){
        int diceValue=p.rollDice();

        p.position+=diceValue;
        
        System.out.print("Dice Value: "+diceValue+"   ");        
        System.out.println("Current Position: "+p.position);
    }
    
}
