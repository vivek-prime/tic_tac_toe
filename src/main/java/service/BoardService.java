package service;

import models.Board;

public interface BoardService {
    void registerBoard(Board board);

    boolean checkWinner(char symbol);

    void updateBoard(String userInput, char value);

    boolean checkInput(String userInput);

    void displayBoard();
}
