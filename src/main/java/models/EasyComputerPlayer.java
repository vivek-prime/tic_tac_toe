package models;

import lombok.Data;

@Data
public class EasyComputerPlayer extends Player {
    public EasyComputerPlayer(int playerId) {
        super(playerId);
    }

    @Override
    public void makeMove() {

    }
}
