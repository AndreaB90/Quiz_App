package com.example.quizapp;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.quizapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    // The score variable
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Gets the layout to inflate and binds the views with their id
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Hides the EditText keyboard when open the Activity
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        binding.submitButton.setOnClickListener(view -> checkAnswers());

        binding.resetButton.setOnClickListener(view -> resetAnswers());
    }

    // Checks if the right answers have been selected and count the total score
    private void checkAnswers() {
        score = 0;
        if (binding.q1Answer44.isChecked()) score++;

        if (binding.q2EditText.getText().toString().toLowerCase().equals(getString(R.string.canberra)))
            score++;

        if (binding.q3Answer5.isChecked()) score++;

        if (!binding.q4AnswerPoland.isChecked() && binding.q4AnswerAlbania.isChecked()
                && binding.q4AnswerRussia.isChecked()) score++;

        if (binding.q5Answer14.isChecked()) score++;

        if (binding.q6AnswerSouthSudan.isChecked()) score++;

        if (!binding.q7AnswerCanada.isChecked() && !binding.q7AnswerItaly.isChecked()
                && binding.q7AnswerUk.isChecked() && binding.q7AnswerNorway.isChecked()) score++;

        if (binding.q8Answer54.isChecked()) score++;

        if (binding.q9EditText.getText().toString().toLowerCase().equals(getString(R.string.india)))
            score++;

        if (binding.q10Answer3.isChecked()) score++;


        // Shows the score on the totalScore TextView and it shows a Toast message based on the score achieved
        binding.totalScore.setText(getString(R.string.score_string, score));
        if (score == 10) {
            Toast.makeText(this, getString(R.string.toast1, score), Toast.LENGTH_SHORT).show();
        } else if (score > 6 && score < 10) {
            Toast.makeText(this, getString(R.string.toast2, score), Toast.LENGTH_SHORT).show();
        } else if (score > 3 && score < 7) {
            Toast.makeText(this, getString(R.string.toast3, score), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getString(R.string.toast4, score), Toast.LENGTH_SHORT).show();
        }
    }

    // Resets all the answers
    private void resetAnswers() {
        score = 0;
        binding.q1RadioGroup.clearCheck();
        binding.q2EditText.getText().clear();
        binding.q3RadioGroup.clearCheck();
        binding.q4AnswerPoland.setChecked(false);
        binding.q4AnswerAlbania.setChecked(false);
        binding.q4AnswerRussia.setChecked(false);
        binding.q5RadioGroup.clearCheck();
        binding.q6RadioGroup.clearCheck();
        binding.q7AnswerCanada.setChecked(false);
        binding.q7AnswerUk.setChecked(false);
        binding.q7AnswerItaly.setChecked(false);
        binding.q7AnswerNorway.setChecked(false);
        binding.q8RadioGroup.clearCheck();
        binding.q9EditText.getText().clear();
        binding.q10RadioGroup.clearCheck();

        // Shows the score on the totalScore TextView and it shows a Toast message to play again
        binding.totalScore.setText(getString(R.string.score_string, score));
        Toast.makeText(this, R.string.play_again, Toast.LENGTH_SHORT).show();
    }

}