package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Player {
    private String playerId;
    private Symbol symbol;
    private PlayerType playerType;

    public String getGridCoOrdinates() {
        return null;
    }
}
