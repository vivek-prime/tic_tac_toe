package service;

import exception.InvalidGridInputException;
import lombok.Data;
import models.GameResult;
import models.GameState;
import models.Player;

import java.util.List;
import java.util.Scanner;

import static models.GameState.DRAW;
import static models.GameState.WINNER;

@Data
public class GameServiceImpl implements GameService {
    private BoardService boardService;
    private List<Player> playersList;
    private GameState gameState;
    private static GameService instance = null;
    private Scanner scanner;

    private GameServiceImpl(BoardService boardService, List<Player> playersList, GameState gameState, Scanner scanner) {
        this.boardService = boardService;
        this.playersList = playersList;
        this.gameState = gameState;
        this.scanner = scanner;
    }

    public static GameService getInstance(BoardService boardService, List<Player> playersList, GameState gameState, Scanner scanner) {
        if (instance == null) {
            synchronized (GameServiceImpl.class) {
                if (instance == null) {
                    instance = new GameServiceImpl(boardService, playersList, gameState, scanner);
                }
            }
        }
        return instance;
    }

    @Override
    public GameResult startGame() {
        int boardSize = boardService.getBoard().getBoardSize();
        Player curPlayer = null;

        int maxTurns = boardSize * boardSize;
        int turn = 0;
        String input;

        while (gameState == GameState.STARTED && maxTurns > 0) {
            boardService.displayBoard();
            curPlayer = playersList.get(turn);
            while (true) {
                input = curPlayer.getGridCoOrdinates(scanner);
                try {
                    if (boardService.checkInput(input))
                        break;
                } catch (InvalidGridInputException e) {
                    System.out.println(e);
                }
            }
            boardService.updateBoard(input, curPlayer.getSymbol().getValue());
            gameState = boardService.getWinner(curPlayer.getSymbol().getValue()) ? WINNER : gameState;
            turn = (turn + 1) % 2;
            maxTurns--;
        }
        boardService.displayBoard();
        gameState = gameState != WINNER ? DRAW : gameState;
        return new GameResult(gameState, curPlayer);
    }
}