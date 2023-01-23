package service;

import models.Board;
import models.Grid;

import static models.Grid.getGridFromStringInput;

public class BoardServiceImpl implements BoardService {
    private Board board;

    @Override
    public void registerBoard(Board board) {
        this.board = board;
    }

    @Override
    public boolean checkWinner(char symbol) {
        int count, count2;
        Character[][] board = this.board.getBoard();
        int boardSize = this.board.getBoardSize();

//        check row
        for (int i = 0; i < boardSize; i++) {
            count = 0;
            for (int j = 0; j < boardSize; j++) {
                if (board[i][j] == symbol)
                    count++;
            }
            if (count == boardSize)
                return true;
        }

//        check column
        for (int i = 0; i < boardSize; i++) {
            count = 0;
            for (int j = 0; j < boardSize; j++) {
                if (board[j][i] == symbol)
                    count++;
            }
            if (count == boardSize)
                return true;
        }

//        check diagonals
        count = 0;
        count2 = 0;
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                if (i == j && board[i][j] == symbol)
                    count++;
                if ((i + j == boardSize - 1) && board[i][j] == symbol)
                    count2++;
            }
        }
        return count == 3 || count2 == 3;
    }

    @Override
    public void updateBoard(String userInput, char value) {
        Grid grid = getGridFromStringInput(userInput);
        board.getBoard()[grid.getX()][grid.getY()] = value;
    }

    @Override
    public boolean checkInput(String userInput) {
        Grid grid;
        try {
            grid = getGridFromStringInput(userInput);
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
            return false;
        }
        int x = grid.getX();
        int y = grid.getY();
        return (x >= 0 && x < board.getBoardSize()) &&
                (y >= 0 && y < board.getBoardSize()) &&
                board.getBoard()[x][y] == '*';
    }

    @Override
    public void displayBoard() {
        Character[][] board = this.board.getBoard();
        int boardSize = this.board.getBoardSize();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " - ");
            }
            System.out.println();
        }
    }
}
