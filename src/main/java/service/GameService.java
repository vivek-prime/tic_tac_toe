package service;

import models.Player;

import java.util.List;

public interface GameService {
    void registerGameService(BoardService boardService, List<Player> playersList);

    boolean checkInput(String userInput);

    void updateBoard(Player curPlayer, String userInput);

    boolean checkWinner();
}
