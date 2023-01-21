package models;

import lombok.Data;

@Data
public class Board {
    private int boardSize;
    private int board[][];

    public Board(int boardSize) {
        this.boardSize = boardSize;
        initializeBoard(boardSize);
    }

    private void initializeBoard(int boardSize) {
        for (int i = 0; i < boardSize; i++)
            board[i] = new int[boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < board[i].length; j++)
                board[i][j] = -1;
        }
    }

    public void displayBoard() {

    }

    public void checkWinner() {

    }
}
