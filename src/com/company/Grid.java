package com.company;

import static java.lang.System.out;

public class Grid {

    int x = 5, y = 5, z=4, didWin = 0, reqLength = 4;

    int[][][] grid = new int[x][y][z];

    int[] lastPMove = new int[4];

    public void printGrid(){
        out.println();
        for (int i = z - 1; i >= 0; i--)
        {
            for (int l = -1; l < x; l++) out.print((l == -1) ? (i + "\t__") : String.format("|_%d_", l));
            out.println("|");
            for (int j = 0; j < y; j++)
            {
                out.printf("\t%d_", j);
                for (int k = 0; k < x; k++) out.printf("|_%d_", grid[k][j][i]);
                out.println("|");
            }
            out.println('\n');
        }
    }

    public boolean setPiece(int x, int y, int z, int player){
        if (grid[x][y][z] == 0){
            grid[x][y][z] = player;
            lastPMove[0] = x; lastPMove[1] = y;
            lastPMove[2] = z; lastPMove[3] = player;
            if (checkWin() != 0) didWin = 1;
            return true;
        }
        else if(player == 1) out.println("\n!!!!!-----ERROR: Spot already taken-----!!!!!");
        printGrid();
        return false;
    }

    public int checkWin(){

        //Check Z-Axis Win
        int k = (lastPMove[2] - reqLength + 1) < 0 ? 0 : lastPMove[2] - reqLength + 1;  //Set lowest possible starting point
        int k2 = (z - reqLength - 1) < 0 ? 0 : (z - reqLength - 1); //Set highest possible starting point

        for (;k <= k2; k++){ //Iterate between the lowest and highest possible starting points
            int[] temp = new int[reqLength]; //Create a new array to house the # of stones required
            int t = k, p = 0, last, count = 0; //t = k for new iteration, p for setting index of temp, last for storing the variable before for checking, count of equal variables checked
            while (t < (k + reqLength)) { //Set temp variables
                temp[p] = grid[lastPMove[0]][lastPMove[1]][t];
                t++; p++;
            }
            last = temp[0]; //set last to first temp for checking
            for (int b = 1; b < reqLength; b++){ //compare last variable and current
                if (temp[b] != 0 && temp[b] == last) count++;
                last = temp[b];
            }
            if (count == reqLength - 1) return lastPMove[3]; //if the count is
        }

        //Check Y-Axis Win
        k = (lastPMove[1] - reqLength + 1) < 0 ? 0 : lastPMove[1] - reqLength + 1;
        k2 = (y - reqLength - 1) < 0 ? 0 : (y - reqLength - 1);

        for (;k <= k2; k++){
            int[] temp = new int[reqLength];
            int t = k, p = 0, last, count = 0;
            while (t < (k + reqLength)) {
                temp[p] = grid[lastPMove[0]][t][lastPMove[2]];
                t++; p++;
            }
            last = temp[0];
            for (int b = 1; b < reqLength; b++){
                if (temp[b] != 0 && temp[b] == last) count++;
                last = temp[b];
            }
            if (count == reqLength - 1) return lastPMove[3];
        }

        //Check X-Axis Win
        k = (lastPMove[0] - reqLength + 1) < 0 ? 0 : lastPMove[0] - reqLength + 1;
        k2 = (x - reqLength - 1) < 0 ? 0 : (x - reqLength - 1);

        for (;k <= k2; k++){
            int[] temp = new int[reqLength];
            int t = k, p = 0, last, count = 0;
            while (t < (k + reqLength)) {
                temp[p] = grid[t][lastPMove[1]][lastPMove[2]];
                t++; p++;
            }
            last = temp[0];
            for (int b = 1; b < reqLength; b++){
                if (temp[b] != 0 && temp[b] == last) count++;
                last = temp[b];
            }
            if (count == reqLength - 1) return lastPMove[3];
        }

        //Check left to right diagonal win


        //Check right to left diagonal win

        return 0;
    }
}