import exception.InvalidGridInputException;
import models.*;
import service.BoardServiceImpl;
import service.DisplayResultService;
import service.GameService;
import service.GameServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameRunner {
    public static void main(String[] args) throws InvalidGridInputException {
        Scanner scanner = new Scanner(System.in);
//        create Players List
        List<Player> playerList = new ArrayList<>();
        playerList.add(new Player("P1", Symbol.ZERO, PlayerType.HUMAN));
        playerList.add(new Player("P2", Symbol.Cross, PlayerType.HUMAN));

        GameService gameService = GameServiceImpl.getInstance(new BoardServiceImpl(new Board(3)), playerList, GameState.STARTED, scanner);

        GameResult gameResult = gameService.startGame();
        DisplayResultService displayResultService = new DisplayResultService(gameResult);
        displayResultService.displayResult();
    }
}
