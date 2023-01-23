package models;

import lombok.Getter;

import java.util.Arrays;

@Getter
public class Board {
    private int boardSize;
    private Character[][] board;

    public Board(int boardSize) {
        this.boardSize = boardSize;
        initializeBoard(boardSize);
    }

    private void initializeBoard(int boardSize) {
        board = new Character[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            Arrays.fill(board[i], '*');
        }
    }
}
