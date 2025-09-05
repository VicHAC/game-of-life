/*
 * Receive the board from the frontend
 */

package com.victoralcaraz.gameoflife.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameRequest {
    private int[][] board;
}