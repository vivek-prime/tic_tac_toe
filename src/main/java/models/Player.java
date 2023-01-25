package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Scanner;

import static utils.AppConstants.USER_INPUT_STRING;

@Getter
@AllArgsConstructor
public class Player {
    private String playerId;
    private Symbol symbol;
    private PlayerType playerType;

    public String getGridCoOrdinates() {
        Scanner sc = new Scanner(System.in);
        System.out.println(USER_INPUT_STRING);
        return sc.nextLine();
    }
}
