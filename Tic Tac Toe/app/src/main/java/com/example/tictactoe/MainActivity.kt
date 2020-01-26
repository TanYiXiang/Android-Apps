package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var playerOneTurn = true
    var roundCount = 0
    lateinit var gameText: TextView
    lateinit var resetButton: Button
    private lateinit var tileButtons: ArrayList<Button>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        gameText = findViewById(R.id.game_text)
        resetButton = findViewById(R.id.reset_button)
        tileButtons = arrayListOf()
        for (i in 0..8) {
            val idString = "button_$i"
            val buttonId = getResources().getIdentifier(idString, "id", packageName)
            tileButtons.add(findViewById(buttonId))
            tileButtons[i].setOnClickListener { gameTileClicked(it) }
        }

        resetButton.setOnClickListener { resetGame(tileButtons) }
    }


    /**
     * Handles tile markings and check for winning conditions.
     *
     * @param view The tile button tapped.
     */
    private fun gameTileClicked(view: View) {
        val button = view as Button
        if (view.text != "") {
            Toast.makeText(this, R.string.tileAlreadySelected, Toast.LENGTH_SHORT).show()
            return
        }

        //Set tile icons
        if (playerOneTurn) {
            view.text = "O"
            gameText.text = getString(R.string.playerTwoTurn)
        } else {
            button.text = "X"
            gameText.text = getString(R.string.playerOneTurn)
        }

        roundCount += 1

        //Check for winning combinations
        if (checkWin(tileButtons)) {
            if (playerOneTurn) {
                gameText.text = getString(R.string.playerOneWins)
            } else {
                gameText.text = getString(R.string.playerTwoWins)
            }
        } else if (roundCount == 9) {
            gameText.text = getString(R.string.playersDraw)
        } else {
            playerOneTurn = !playerOneTurn
        }

    }

    /**
     *  Detect win conditions on the board.
     *
     *  @param tileButtons The board tiles
     *  @return True if win condition detected, false otherwise.
     */
    private fun checkWin(tileButtons: ArrayList<Button>): Boolean {

        //Check horizontal tiles
        for (i in 0..8 step 3) {
            if ((tileButtons[i].text == tileButtons[i + 1].text) && (tileButtons[i].text == tileButtons[i + 2].text)
                && (tileButtons[i].text != "")
            ) {
                return true
            }
        }

        //Check vertical tiles
        for (i in 0..2) {
            if ((tileButtons[i].text == tileButtons[i + 3].text) && (tileButtons[i].text == tileButtons[i + 6].text)
                && (tileButtons[i].text != "")
            ) {
                return true
            }
        }

        //Check diagonal tiles
        if ((tileButtons[0].text == tileButtons[4].text) && (tileButtons[0].text == tileButtons[8].text) && (tileButtons[0].text != "")) {
            return true
        }

        if ((tileButtons[2].text == tileButtons[4].text) && (tileButtons[2].text == tileButtons[6].text) && (tileButtons[2].text != "")) {
            return true
        }

        return false
    }


    /**
     *  Reset the game board by clearing all the tiles.
     *
     *  @param tileButtons The board tiles
     */
    private fun resetGame(tileButtons: ArrayList<Button>) {
        for (buttons in tileButtons) {
            buttons.text = ""
        }
        roundCount = 0
        playerOneTurn = true
        gameText.text = getString(R.string.playerOneTurn)
        Toast.makeText(this, R.string.gameReset, Toast.LENGTH_SHORT).show()

    }


}
