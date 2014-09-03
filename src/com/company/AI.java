package com.company;

import static com.company.Universal.randInt;

public class AI {

    public Grid makeMove(Grid grid){
        while (true) {
            int x = randInt(0, grid.x - 1),y = randInt(0, grid.y - 1),z = randInt(0, grid.z - 1);
            if (grid.setPiece(x,y,z, 2)){
                System.out.printf("AI played on level %d: (%d,%d)%n", z, x+1, y+1);
                break;
            }
        }
        return grid;
    }

}
