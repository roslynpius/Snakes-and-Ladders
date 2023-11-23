package com.bridgelabz.Snakes_And_Ladders;
import java.util.Random;

public class Player {
    int position;

    Player() {
        position = 0;
    }
    public int rollDice(){
        Random random = new Random();

        int randomValue = random.nextInt(6) + 1;
        return randomValue;
    }
}
