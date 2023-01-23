package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Grid {
    private int x;
    private int y;

    public static Grid getGridFromStringInput(String userInput) {
        String[] userInputArray = userInput.split(",");
        int x = Integer.parseInt(userInputArray[0]);
        int y = Integer.parseInt(userInputArray[1]);
        return new Grid(x, y);
    }
}
