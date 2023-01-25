package service;

import exception.InvalidGridInputException;
import lombok.AllArgsConstructor;
import lombok.Data;
import models.GameResult;
import models.GameState;
import models.Player;

import java.util.List;

import static models.GameState.DRAW;
import static models.GameState.WINNER;

@Data
@AllArgsConstructor
public class GameServiceImpl implements GameService {
    private BoardService boardService;
    private List<Player> playersList;
    private GameState gameState;

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
                input = curPlayer.getGridCoOrdinates();
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