package models;

import lombok.Getter;

@Getter
public enum Symbol {
    ZERO('0'), Cross('X');
    private char value;

    Symbol(char value) {
        this.value = value;
    }
}
