package models;

import lombok.Data;

@Data
public class User extends Player {
    public User(int playerId) {
        super(playerId);
    }

    @Override
    public void makeMove() {

    }
}
