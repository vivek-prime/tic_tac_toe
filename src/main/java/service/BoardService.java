package service;

import exception.InvalidGridInputException;
import models.Board;

public interface BoardService {
    boolean getWinner(char symbol);

    void updateBoard(String userInput, char value);

    boolean checkInput(String userInput) throws InvalidGridInputException;

    void displayBoard();

    Board getBoard();

}
