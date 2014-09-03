package com.company;

import static java.lang.System.out;

import java.util.Scanner;

public class Main {

    static Grid grid = new Grid();
    static AI ai = new AI();
    static int difficulty = 0;

    public static void main(String[] args) {
        out.print("Welcome to 3D Tic Tac Toe!\n\nWhat difficulty would you like? (1-3): ");
        Scanner io = new Scanner(System.in);
        difficulty=io.nextInt();
        if (difficulty == 2) ai = new MediumAI();
        else if (difficulty == 3) ai = new HardAI();
        out.println("\nInitializing The Grid...\n");
        grid.printGrid();
        while (grid.didWin == 0) {
            int xt, yt, zt;
            out.print("Enter which level you'd like to place your piece on: ");
            zt = io.nextInt();
            out.print("Enter which row you'd like to place your piece on: ");
            yt = io.nextInt();
            out.print("Enter which column you'd like to place your piece on: ");
            xt = io.nextInt();
            if (grid.setPiece(xt, yt, zt, 1)) grid = ai.makeMove(grid);
        }
        out.println("\nPlayer " + grid.didWin + " Wins!!!!!!!!!!!!!!!!!!!!!");
    }

}