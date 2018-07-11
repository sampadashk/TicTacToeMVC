package com.example.unsan.tictactoemvc.model;

import static com.example.unsan.tictactoemvc.model.Player.O;
import static com.example.unsan.tictactoemvc.model.Player.X;

public class Board {
    private Cell[][] cells=new Cell[3][3];
    private enum GameState {InProgress,Finished};
    private Player currentPlayer,winner;
    private GameState gameState;
    public Board()
    {
        restart();
    }
    public void restart()
    {
        clearCells();
        currentPlayer= X;
        gameState=GameState.InProgress;
        winner=null;

    }
    private void clearCells()
    {
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                cells[i][j]=new Cell();
            }
        }
    }
    public Player getWinner()
    {
        return winner;
    }
    private boolean isValid(int x,int y)
    {
        if(gameState==GameState.Finished)
        {
            return false;
        }
        else if(OutOfBound(x)||OutOfBound(y))
        {
            return false;
        }
        else if(isCellValueAlreadySet(x,y))
        {
            return false;
        }
        else
        {
            return true;
        }


    }
    boolean OutOfBound(int x)
    {
        if(x<0||x>2)
        {
            return true;
        }
        else
            return false;
    }
    boolean isCellValueAlreadySet(int x,int y)
    {
      return cells[x][y].getValue()!=null;
    }
    public Player mark(int row,int column)
    {
        Player playerThatMoved = null;
        if(isValid(row, column)) {
            cells[row][column].setValue(currentPlayer);
            playerThatMoved = currentPlayer;
            if (isWinningMoveByPlayer(currentPlayer, row, column)) {
                gameState = GameState.Finished;
                winner = currentPlayer;

            } else {
                // flip the current turn and continue
                flipCurrentTurn();


            }
        }
        return playerThatMoved;

    }
    private void flipCurrentTurn()
    {
       currentPlayer=currentPlayer== X?O:X;
    }
    private boolean isWinningMoveByPlayer(Player player, int currentRow, int currentCol) {

        return (cells[currentRow][0].getValue() == player         // 3-in-the-row
                && cells[currentRow][1].getValue() == player
                && cells[currentRow][2].getValue() == player
                || cells[0][currentCol].getValue() == player      // 3-in-the-column
                && cells[1][currentCol].getValue() == player
                && cells[2][currentCol].getValue() == player
                || currentRow == currentCol            // 3-in-the-diagonal
                && cells[0][0].getValue() == player
                && cells[1][1].getValue() == player
                && cells[2][2].getValue() == player
                || currentRow + currentCol == 2    // 3-in-the-opposite-diagonal
                && cells[0][2].getValue() == player
                && cells[1][1].getValue() == player
                && cells[2][0].getValue() == player);
    }






}
