import exception.InvalidGridInputException;
import models.*;
import service.BoardServiceImpl;
import service.DisplayResultService;
import service.GameService;
import service.GameServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class GameRunner {
    public static void main(String[] args) throws InvalidGridInputException {
//        create Players List
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("P1", Symbol.ZERO, PlayerType.HUMAN));
        playerList.add(new Player("P2", Symbol.Cross, PlayerType.HUMAN));

        GameService gameService = new GameServiceImpl(new BoardServiceImpl(new Board(3)), playerList,
                GameState.STARTED);

        GameResult gameResult = gameService.startGame();
        DisplayResultService displayResultService = new DisplayResultService(gameResult);
        displayResultService.displayResult();
    }
}
