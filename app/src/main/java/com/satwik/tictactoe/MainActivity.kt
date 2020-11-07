package com.satwik.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener{
    var player=true
    var times=0
    var boardState=Array(3){IntArray(3)}
    lateinit var board: Array <Array<Button>>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title=""
        board= arrayOf(
                arrayOf(bv1,bv2,bv3),
                arrayOf(bv4,bv5,bv6),
                arrayOf(bv7,bv8,bv9))
        for (i in board)
        {
            for( button in i)
                button.setOnClickListener(this)
        }

        initialiseboardState()
        reset.setOnClickListener {
            player=true
            times=0
            initialiseboardState()
        }
    }

    private fun initialiseboardState() {
        toggleText("X's turn first")
        for (i in 0..2)
        {
            for(j in 0..2)
            {
                boardState[i][j]=-1
                board[i][j].text=""
                board[i][j].isEnabled=true
            }

        }
    }
    private fun deinitialiseboardState() {
        for (i in 0..2)
        {
            for(j in 0..2)
            {
                boardState[i][j]=-1
                board[i][j].text=""
                board[i][j].isEnabled=false
            }

        }
    }
// android:background="@android:color/black"
    override fun onClick(view: View) {
        when(view.id)
        {
         R.id.bv1->{
             updateValue(row=0,col=0, player)
         }
        R.id.bv2->{
            updateValue(row=0,col=1, player)
        }
        R.id.bv3->{
            updateValue(row=0,col=2, player)

        }
        R.id.bv4->{
            updateValue(row=1,col=0, player)

        }
        R.id.bv5->{
            updateValue(row=1,col=1, player)

        }
        R.id.bv6->{
            updateValue(row=1,col=2, player)

        }
        R.id.bv7->{
            updateValue(row=2,col=0, player)

        }
        R.id.bv8->{
            updateValue(row=2,col=1, player)

        }
        R.id.bv9-> {
            updateValue(row = 2, col = 2, player)

        }

        }
     player=!player
     times++;
     val is_winner=isWinner()
    if(is_winner==1)
    {
        var str_val=if(player) "O has Won the game !!" else "X has Won the game !!"
        toggleText(str_val+" Tap to Reset")
        deinitialiseboardState()
    }
    else if(times==9) {
        tv.setText("Game Draw,Don't do drug kids!!")
        deinitialiseboardState()
    }
    else
    {
        var str_val=if(player) "X's turn !!" else "O's turn !!"
        toggleText(str_val)
    }

    }

    private fun isWinner(): Any {
        for( i in 0..2)
        {
            if(boardState[i][0]>-1 && boardState[i][0]==boardState[i][1] && boardState[i][1]==boardState[i][2]  )
                return 1;
        }
        for( i in 0..2)
        {
            if(boardState[0][i]>-1 && boardState[0][i]==boardState[1][i] && boardState[1][i]==boardState[2][i] )
                return 1;
        }

       if(boardState[0][0]>-1 && boardState[0][0]==boardState[1][1] && boardState[1][1]==boardState[2][2])
         return 1
     else if(boardState[0][2]>-1 && boardState[0][2]==boardState[1][1] && boardState[1][1]==boardState[2][0])
         return 1
      else
         return 0
    }

    private fun toggleText(str_val:String) {
        tv.setText(str_val)
    }

    private fun updateValue(row: Int, col: Int, player: Boolean)
    {
       var which_player=if(player) "X" else "O"
        var value_for_board_state=if(player) 1 else 0
        board[row][col].apply {
            isEnabled=false
            setText(which_player) }
        boardState[row][col]=value_for_board_state
    }

}
//
//if(boardState[0][0]>-1 && boardState[0][0]==boardState[0][1] && boardState[0][1]==boardState[0][2]  )
//return 1
//else if(boardState[1][0]>-1 && boardState[1][0]==boardState[1][1] && boardState[1][1]==boardState[1][2])
//return 1
//else if(boardState[2][0]>-1 && boardState[2][0]==boardState[2][1] && boardState[2][1]==boardState[2][2])
//return 1
//
//else if(boardState[0][0]>-1 && boardState[0][0]==boardState[1][0] && boardState[1][0]==boardState[2][0])
//return 1
//else if(boardState[0][1]>-1 && boardState[0][1]==boardState[1][1] && boardState[1][1]==boardState[2][1])
//return 1
//else if(boardState[0][2]>-1 && boardState[0][2]==boardState[1][2] && boardState[1][2]==boardState[2][2])
//return 1
//else