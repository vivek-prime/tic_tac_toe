package service;

import models.Board;

public interface BoardService {
    boolean getWinner(char symbol);

    void updateBoard(String userInput, char value);

    boolean checkInput(String userInput);

    void displayBoard();

    Board getBoard();

}
