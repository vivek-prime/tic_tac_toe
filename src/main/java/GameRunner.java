import models.Board;
import models.Player;
import models.Symbol;
import service.BoardService;
import service.BoardServiceImpl;
import service.GameService;
import service.GameServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static utils.AppConstants.USER_INPUT_STRING;

public class GameRunner {
    public static void main(String[] args) {
//        create Players List
        List<Player> playerList = new ArrayList<>();
        playerList.add(Player.builder().playerId("P1").symbol(Symbol.ZERO).build());
        playerList.add(Player.builder().playerId("P2").symbol(Symbol.Cross).build());

//        create board
        int boardSize = 3;
        Board board = new Board(boardSize);

        BoardService boardService = new BoardServiceImpl();
        boardService.registerBoard(board);

        GameService gameService = new GameServiceImpl();
        gameService.registerGameService(boardService, playerList);

        int MAX_TURNS = boardSize * boardSize;
        int turn = 0;
        Player curPlayer;
        String userInput;
        Scanner sc = new Scanner(System.in);
        boolean winnerFlag = false;

        while (MAX_TURNS >= 0) {
            curPlayer = playerList.get(turn);
            while (true) {
                System.out.println(USER_INPUT_STRING);
                userInput = sc.nextLine();
                if (!gameService.checkInput(userInput))
                    break;
            }
            gameService.updateBoard(curPlayer, userInput);
            winnerFlag = gameService.checkWinner();
            if (winnerFlag) {
                System.out.println(curPlayer.getPlayerId() + " wins");
                break;
            }
            turn = (turn + 1) % 2;
            MAX_TURNS--;
        }
        if (!winnerFlag)
            System.out.println("Ended in a Draw");
    }
}
