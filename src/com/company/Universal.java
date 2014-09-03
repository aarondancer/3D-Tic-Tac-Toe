package com.company;

import java.util.Random;

/**
 * Created by aarondancer on 9/1/14.
 */
public class Universal {
    public static int randInt(int min, int max) {
        Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
