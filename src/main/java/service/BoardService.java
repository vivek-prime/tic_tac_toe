package service;

import models.Board;

public interface BoardService {
    void registerBoard(Board board);

    boolean checkWinner();

    void updateBoard(String userInput, char value);

    boolean checkInput(String userInput);
}
