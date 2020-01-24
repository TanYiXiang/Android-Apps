package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var playerOneTurn = true
    var playerTwoTurn = false
    lateinit var gameText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameText = findViewById(R.id.game_text)
        for (i in 0..8) {
            val idString = "button_$i"
            val buttonId = getResources().getIdentifier(idString, "id", packageName)
            findViewById<Button>(buttonId).setOnClickListener { buttonClicked(it) }
        }
    }

    private fun buttonClicked(view: View) {

       val button = view as Button

        if (playerOneTurn) {
            view.text = "O"
            playerOneTurn = false
            playerTwoTurn = true
            gameText.text = getString(R.string.playerTwoTurn)
        } else {
            button.text = "X"
            playerOneTurn = true
            playerTwoTurn = false
            gameText.text = getString(R.string.playerOneTurn)
        }

    }


}
