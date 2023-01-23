package strategy;

import models.Player;
import models.PlayerType;
import models.Symbol;

public class HardComputerStrategy extends Player implements ComputerMoveStrategy {
    public HardComputerStrategy(String playerId, Symbol symbol, PlayerType playerType) {
        super(playerId, symbol, playerType);
    }

    @Override
    public String getGridCoOrdinates() {
        return null;
    }
}
