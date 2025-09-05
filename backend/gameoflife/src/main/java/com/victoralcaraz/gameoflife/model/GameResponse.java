/*
 * Returns the new board to frontend
 */

package com.victoralcaraz.gameoflife.model;

import lombok.Data;

@Data
public class GameResponse {
    private int [][] nextBoard;

    public GameResponse(int[][] nextBoard) {
        this.nextBoard = nextBoard;
    }
}
