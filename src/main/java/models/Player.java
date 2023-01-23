package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public abstract class Player {
    private String playerId;
    private Symbol symbol;
}
