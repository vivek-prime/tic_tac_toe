package models;

import lombok.Getter;

@Getter
public enum GameState {
    WINNER, DRAW, ABORTED, STARTED;
}
