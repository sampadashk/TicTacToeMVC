package com.example.unsan.tictactoemvc.model;

public class Cell {
    public Player value;
    public void setValue(Player value)
    {
        this.value=value;
    }
    public Player getValue()
    {
        return value;
    }
}
