package models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Player {
    private String playerId;
    private Symbol symbol;
}
