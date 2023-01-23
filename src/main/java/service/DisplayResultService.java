package service;

import lombok.AllArgsConstructor;
import lombok.Data;
import models.GameResult;

@Data
@AllArgsConstructor
public class DisplayResultService implements DisplayResult {
    private GameResult gameResult;

    public void displayResult() {
        switch ((gameResult.getGameState())) {
            case WINNER:
                System.out.println(gameResult.getPlayer().getPlayerId() + " is Winner");
                break;
            case DRAW:
                System.out.println("Game Drew");
                break;
            case ABORTED:
                System.out.println("Game Aborted");
                break;
        }
    }

}
