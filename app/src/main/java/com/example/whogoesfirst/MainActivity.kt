package com.example.whogoesfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

private const val TAG = "TEAM_CHOICE_ACTIVITY"

class MainActivity : AppCompatActivity() {

    // one button, two edit text fields, show team chosen result field
    private lateinit var team1Text: EditText
    private lateinit var team2Text: EditText
    private lateinit var resultTextView: TextView
    private lateinit var chooseTeamButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize variables to component ids
        team1Text = findViewById(R.id.enter_team_1_name)
        team2Text = findViewById(R.id.enter_team_2_name)
        resultTextView = findViewById(R.id.show_team_chosen)
        chooseTeamButton = findViewById(R.id.choose_team_button)

        // set up click listener for the button
        chooseTeamButton.setOnClickListener {
            validateTeamsNames()
        }

    }
    private fun validateTeamsNames() {
        // get text from team name fields and log that info for debugging
        val team1 = team1Text.text.toString()
        Log.d(TAG, "First team name is $team1")
        val team2 = team2Text.text.toString()
        Log.d(TAG, "Second team name is $team2")
        if (team1.isBlank() or team2.isBlank()) {
            // logging if statement values to see why Toast is not displaying despite team fields being empty
            Log.d(TAG, "Value of check on team 1 blankness is ${team1.isBlank()}")
            Log.d(TAG, "Value of check on team 2 blankness is ${team2.isBlank()}")
            Toast.makeText(this, getString(R.string.team_blank_message), Toast.LENGTH_LONG).show()
            resultTextView.text = ""
        } else {
            // if both teams are not blank, then call the pickRandomTeam function
            pickRandomTeam()
        }
    }

    private fun pickRandomTeam() {
        val team1 = team1Text.text.toString()
        val team2 = team2Text.text.toString()
        // using the listOf .random() function
        val teamPicked = listOf(team1, team2).random()
        resultTextView.text = getString(R.string.team_chosen_text, teamPicked)
        }


}