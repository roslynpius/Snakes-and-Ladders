package com.bridgelabz.Snakes_And_Ladders;
import java.util.Random;

/**
 * The SnakesAndLadder class represents the main logic of the Snake and Ladder game.
 * It includes the initialization of players, simulation of the game, and methods for rolling the dice, checking options,
 * and updating player positions based on dice rolls.
 */
public class SnakesAndLadder {
    public static void main(String[] args) {
        System.out.println("Welcome to Snake and Ladder Game!");

        Player p1=new Player();
        Player p2=new Player();
        int diceRoll1=0,diceRoll2=0;

        System.out.println("Start Position Player 1:"+p1.position);
        System.out.println("Start Position Player 2:"+p2.position);
        System.out.println();

        while(p1.position<100 && p2.position<100)
        {
            System.out.println();

            System.out.print(" Player 1:        ");
            diceRoll1++;
            playerPlay(p1);
            if(p1.position==100)
                break;

            System.out.print(" Player 2:        ");
            diceRoll2++;
            playerPlay(p2);
            
        }

        System.out.println("GAME OVER");
        int diceRoll;
        if(p1.position==100){
            System.out.println("Player 1 WINS!!");
            diceRoll=diceRoll1;
        }
        else{
            System.out.println("Player 2 WINS!!");
            diceRoll=diceRoll2;
        }
        System.out.println("No. of Dice Rolls: "+diceRoll);
    }

    /**
     * @desc: Player rolls dice and the position is updated 
     * @param: p - Player Object.
     * @return: diceValue - Value on the dice
     */
    public static int rollDice(){

        Random random = new Random();

        int diceValue= random.nextInt(6) +1;
        
        return diceValue;
    }

    /**
     * @desc: Player checks option     * 
     * @param: p - Player Object.
     *          diceValue- Value on the dice
     * @return Returns 1 if player lands on ladder otherwise 0
     */
    public static int checkOption(Player p,int diceValue)
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
                return 1;

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
        return 0;
    }

    /**
     * @desc: Player checks option
     * @param: p - Player Object
     */
    public static void playerPlay(Player p) {
        int diceValue=rollDice();
        int isLadder=0;
            
            if((p.position+diceValue)<=100)
            {   p.position+=diceValue;//updates player position

                if(p.position!=100)
                    isLadder=checkOption(p,diceValue);
            }
                        
            System.out.print("Dice Value: "+diceValue+"   ");        
            System.out.println("Current Position: "+p.position);
            
            if(isLadder==1)
            {
                playerPlay(p);
            }
    }
    
}
