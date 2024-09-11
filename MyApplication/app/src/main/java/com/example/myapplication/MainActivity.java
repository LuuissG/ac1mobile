package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private RadioGroup radioGroup3;
    private Button btnSubmit;
    private Button btnRestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioGroup1 = findViewById(R.id.radio_group1);
        radioGroup2 = findViewById(R.id.radio_group2);
        radioGroup3 = findViewById(R.id.radio_group3);

        btnSubmit = findViewById(R.id.btn_submit);
        btnRestart = findViewById(R.id.btn_restart);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswers();
                btnSubmit.setEnabled(false);
            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartQuiz();
                btnSubmit.setEnabled(true);
            }
        });
    }

    private void checkAnswers() {
        boolean isQuestion1Correct = checkRadioGroup(radioGroup1, R.id.rb_option1_4); // Oceano Pacífico
        boolean isQuestion2Correct = checkRadioGroup(radioGroup2, R.id.rb_option2_2); // Ouro
        boolean isQuestion3Correct = checkRadioGroup(radioGroup3, R.id.rb_option3_2); // A Queda da Bastilha

        showToast(isQuestion1Correct, "Qual o maior oceano do mundo?", "Oceano Pacífico");
        showToast(isQuestion2Correct, "Qual é o elemento químico representado pelo símbolo 'Au'?", "Ouro");
        showToast(isQuestion3Correct, "Qual foi o evento que marcou o início da Revolução Francesa em 1789?", "A Queda da Bastilha");
    }

    private boolean checkRadioGroup(RadioGroup radioGroup, int correctAnswerId) {
        int selectedId = radioGroup.getCheckedRadioButtonId();
        return selectedId == correctAnswerId;
    }

    private void showToast(boolean isCorrect, String question, String correctAnswer) {
        String message = isCorrect ? "Resposta correta!" : "Resposta errada. A resposta correta é " + correctAnswer;
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void restartQuiz() {
        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        radioGroup3.clearCheck();
    }
}

