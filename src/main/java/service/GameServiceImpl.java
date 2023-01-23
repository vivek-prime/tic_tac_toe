package service;

import lombok.Data;
import models.Player;

import java.util.List;

@Data
public class GameServiceImpl implements GameService {
    private BoardService boardService;
    private List<Player> playersList;

    @Override
    public void registerGameService(BoardService boardService, List<Player> playersList) {
        this.boardService = boardService;
        this.playersList = playersList;
    }

    public boolean checkInput(String userInput) {
        return boardService.checkInput(userInput);
    }

    public void updateBoard(Player curPlayer, String userInput) {
        boardService.updateBoard(userInput, curPlayer.getSymbol().getValue());
    }

    public boolean checkWinner(Player curPlayer) {
        return boardService.checkWinner(curPlayer.getSymbol().getValue());
    }
}
