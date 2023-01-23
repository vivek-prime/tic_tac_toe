package strategy;

import models.Player;
import models.PlayerType;
import models.Symbol;

public class EasyComputerStrategy extends Player implements ComputerMoveStrategy {
    public EasyComputerStrategy(String playerId, Symbol symbol, PlayerType playerType) {
        super(playerId, symbol, playerType);
    }

    @Override
    public String getGridCoOrdinates() {
        return null;
    }
}
