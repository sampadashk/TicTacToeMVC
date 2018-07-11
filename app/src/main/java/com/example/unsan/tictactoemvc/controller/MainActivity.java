package com.example.unsan.tictactoemvc.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.unsan.tictactoemvc.R;
import com.example.unsan.tictactoemvc.model.Board;
import com.example.unsan.tictactoemvc.model.Player;

public class MainActivity extends AppCompatActivity {
    TextView winnerPlayerLabel;
    ViewGroup buttonGrid;
    View winnerPlayerViewGroup;
    Board board;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        winnerPlayerLabel = (TextView) findViewById(R.id.winnerPlayerLabel);
        buttonGrid = (ViewGroup) findViewById(R.id.buttonGrid);
        winnerPlayerViewGroup = findViewById(R.id.winnerPlayerViewGroup);
        board=new Board();

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_tictactoe, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_reset:
                reset();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void reset() {
        winnerPlayerViewGroup.setVisibility(View.GONE);
        winnerPlayerLabel.setText("");

        board.restart();

        for( int i = 0; i < buttonGrid.getChildCount(); i++ ) {
            ((Button) buttonGrid.getChildAt(i)).setText("");
        }
    }
    public void onCellClicked(View v) {
        Button button=(Button)v;
        String coord= (String) button.getTag();
        int rowSelected=Integer.valueOf(coord.substring(0,1));
        int columnSelected=Integer.valueOf(coord.substring(1,2));
        Log.d("selected",rowSelected+""+columnSelected);
        Player playerThatMoved=board.mark(rowSelected,columnSelected);
        if(playerThatMoved != null) {
            button.setText(playerThatMoved.toString());
            if (board.getWinner() != null) {
                winnerPlayerLabel.setText(playerThatMoved.toString());
                winnerPlayerViewGroup.setVisibility(View.VISIBLE);
            }
        }

    }


}
