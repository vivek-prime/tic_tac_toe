package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import models.GameResult;
import models.GameState;
import models.Player;

import java.util.List;
import java.util.Scanner;

import static models.GameState.DRAW;
import static models.GameState.WINNER;
import static utils.AppConstants.USER_INPUT_STRING;

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
        Scanner sc = new Scanner(System.in);
        String input = "";

        while (gameState == GameState.STARTED && maxTurns > 0) {
            boardService.displayBoard();
            curPlayer = playersList.get(turn);
            switch (curPlayer.getPlayerType()) {
                case HUMAN:
                    while (true) {
                        System.out.println(USER_INPUT_STRING + curPlayer.getPlayerId());
                        input = sc.nextLine();
                        if (boardService.checkInput(input))
                            break;
                    }
                    break;
                case COMPUTER:
                    input = curPlayer.getGridCoOrdinates();
                    break;
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