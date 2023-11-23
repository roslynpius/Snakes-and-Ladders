package com.bridgelabz.Snakes_And_Ladders;
import java.util.Random;

public class SnakesAndLadder {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game!");

        Player p1=new Player();
        System.out.println("Start Position:"+p1.position);

        while(p1.position<100)
        {
            System.out.println("Roll the Dice!");
            int diceValue=rollDice();
            
            if((p1.position+diceValue)<=100)
            {   p1.position+=diceValue;//updates player position

                if(p1.position!=100)
                    checkOption(p1,diceValue);
            }
                        
            System.out.print("Dice Value: "+diceValue+"   ");        
            System.out.println("Current Position: "+p1.position);
        }
        System.out.println("GAME OVER");
    }

    /**
     * Player rolls dice and the position is updated
     * 
     * @param p - Player Object.
     * @return diceValue - Value on the dice
     */
    public static int rollDice(){

        Random random = new Random();

        int diceValue= random.nextInt(6) +1;
        
        return diceValue;
    }

    public static void checkOption(Player p,int diceValue)
    {
        Random random = new Random();

        final int OPTION_NO_PLAY=0;
        final int OPTION_LADDER=1;
        final int OPTION_SNAKE=2;

        int randomValue = random.nextInt(3);//0- No play, 1-Ladder, 2- Snake

        switch(randomValue){

            case OPTION_NO_PLAY:
                if((p.position)>100)
                        p.position-=diceValue;
                System.out.print("CLEAR   ");
                break;
            
            case OPTION_LADDER:
                int d1=diceValue;
                if((p.position+d1)<=100)
                    p.position+=d1;
                System.out.print("LADDER   ");
                break;

            case OPTION_SNAKE:
                int d2=diceValue;
                if((p.position-d2)>0)
                    p.position-=d2;
                else
                    p.position=0;
                System.out.print("SNAKE   ");
                break;
            
            default:
                break;

        }
    }
    
}
