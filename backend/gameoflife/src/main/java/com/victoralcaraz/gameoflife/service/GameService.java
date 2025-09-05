/*
 * Logic for the Game of Life
 */

package com.victoralcaraz.gameoflife.service;

import org.springframework.stereotype.Service;

@Service
public class GameService {
    private int getAliveNeighbors(int[][] board, int row, int col) {
        int aliveNeighbors = 0;
        int totalRows = board.length;
        int totalCols = board[0].length;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;

                int newRow = row + i;
                int newCol = col + j;

                if (newRow >= 0 && newRow < totalRows && newCol >= 0 && newCol < totalCols) {
                    aliveNeighbors += board[newRow][newCol];
                }
            }
        }

        return aliveNeighbors;
    }

    public int[][] getNextGeneration(int[][] board){
        int rows = board.length;
        int cols = board[0].length;
        int[][] newBoard = new int[rows][cols];

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                int aliveNeighbors = getAliveNeighbors(board, i, j);

                if (board[i][j] == 1){
                    if(aliveNeighbors >= 2 && aliveNeighbors <= 3) newBoard[i][j] = 1;
                    else newBoard[i][j] = 0;
                }
                if (board[i][j] == 0){
                    if(aliveNeighbors == 3) newBoard[i][j] = 1;
                    else newBoard[i][j] = 0;
                }
            }
        }

        return newBoard;
    }
}
