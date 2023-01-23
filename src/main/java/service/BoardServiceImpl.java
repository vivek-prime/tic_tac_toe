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
    public boolean checkWinner() {
        return false;
    }

    @Override
    public void updateBoard(String userInput, char value) {
        Grid grid = getGridFromStringInput(userInput);
        board.getBoard()[grid.getX()][grid.getY()] = value;
    }

    @Override
    public boolean checkInput(String userInput) {
        Grid grid = getGridFromStringInput(userInput);
        int x = grid.getX();
        int y = grid.getY();
        return (x >= 1 && x <= board.getBoardSize()) &&
                (y >= 1 && y <= board.getBoardSize()) &&
                board.getBoard()[x][y] == '*';
    }
}
