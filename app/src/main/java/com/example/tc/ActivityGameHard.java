package com.example.tc;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import android.media.MediaPlayer;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Random;

public class ActivityGameHard extends AppCompatActivity {

    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModalHard> quizModalHardArrayList;
    private ImageView happyImageView;
    private ImageView sadImageView;
    private String selectedAnswer;
    Random random;
    int currentScore = 0, questionAttempted = 1, currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_easy);

        happyImageView = findViewById(R.id.happyImageView);
        sadImageView = findViewById(R.id.sadImageView);
        questionTV=findViewById(R.id.idTVQuestion);
        questionNumberTV=findViewById(R.id.idTVQuestionAttempted);
        option1Btn=findViewById(R.id.idBtnOption1);
        option2Btn=findViewById(R.id.idBtnOption2);
        option3Btn=findViewById(R.id.idBtnOption3);
        option4Btn=findViewById(R.id.idBtnOption4);
        quizModalHardArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModalHardArrayList);
        currentPos = random.nextInt(quizModalHardArrayList.size());
        setDataToViews(currentPos);
        option1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswer = option1Btn.getText().toString().trim();
                checkAnswer(selectedAnswer);
            }
        });

        option2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswer = option2Btn.getText().toString().trim();
                checkAnswer(selectedAnswer);
            }
        });

        option3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswer = option3Btn.getText().toString().trim();
                checkAnswer(selectedAnswer);
            }
        });

        option4Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAnswer = option4Btn.getText().toString().trim();
                checkAnswer(selectedAnswer);
            }
        });

    }

    private void checkAnswer(String selectedAnswer) {
        String correctAnswer = quizModalHardArrayList.get(currentPos).getAnswer().trim();

        // Compare the selected answer with the correct answer

        if (selectedAnswer.equalsIgnoreCase(correctAnswer)) {
            // Correct answer
            currentScore++;
            if (option1Btn.getText().toString().trim().equalsIgnoreCase(selectedAnswer)) {
                option1Btn.setBackgroundResource(R.drawable.green);
            } else if (option2Btn.getText().toString().trim().equalsIgnoreCase(selectedAnswer)) {
                option2Btn.setBackgroundResource(R.drawable.green);
            } else if (option3Btn.getText().toString().trim().equalsIgnoreCase(selectedAnswer)) {
                option3Btn.setBackgroundResource(R.drawable.green);
            } else if (option4Btn.getText().toString().trim().equalsIgnoreCase(selectedAnswer)) {
                option4Btn.setBackgroundResource(R.drawable.green);
            }
            // Disable option buttons temporarily
            disableOptionButtons();

            happyImageView.setVisibility(View.VISIBLE);
            sadImageView.setVisibility(View.GONE);

            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correctanswer);
            mediaPlayer.start();


        } else {
            // Wrong answer
            showWrongAnswer(selectedAnswer, correctAnswer);

            sadImageView.setVisibility(View.VISIBLE);
            happyImageView.setVisibility(View.GONE);

            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.incorrectanswer);
            mediaPlayer.start();
        }

        // Disable option buttons temporarily
        disableOptionButtons();

        // Delay the execution of showing the next question
        option1Btn.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Reset the option button backgrounds
                option1Btn.setBackgroundResource(R.drawable.option_button_background);
                option2Btn.setBackgroundResource(R.drawable.option_button_background);
                option3Btn.setBackgroundResource(R.drawable.option_button_background);
                option4Btn.setBackgroundResource(R.drawable.option_button_background);
                happyImageView.setVisibility(View.GONE);
                sadImageView.setVisibility(View.GONE);


                // Enable option buttons
                enableOptionButtons();



                // Show the next question
                showNextQuestion();
            }
        }, 2000); // Adjust the delay time as needed
    }


    private void showWrongAnswer(String selectedAnswer, String correctAnswer) {
        // Display red background for the selected option
        if (option1Btn.getText().toString().trim().equalsIgnoreCase(selectedAnswer)) {
            option1Btn.setBackgroundResource(R.drawable.red);
        } else if (option2Btn.getText().toString().trim().equalsIgnoreCase(selectedAnswer)) {
            option2Btn.setBackgroundResource(R.drawable.red);
        } else if (option3Btn.getText().toString().trim().equalsIgnoreCase(selectedAnswer)) {
            option3Btn.setBackgroundResource(R.drawable.red);
        } else if (option4Btn.getText().toString().trim().equalsIgnoreCase(selectedAnswer)) {
            option4Btn.setBackgroundResource(R.drawable.red);
        }

        // Display green background for the correct answer
        if (option1Btn.getText().toString().trim().equalsIgnoreCase(correctAnswer)) {
            option1Btn.setBackgroundResource(R.drawable.green);
            option1Btn.setText(correctAnswer);
        } else if (option2Btn.getText().toString().trim().equalsIgnoreCase(correctAnswer)) {
            option2Btn.setBackgroundResource(R.drawable.green);
            option2Btn.setText(correctAnswer);
        } else if (option3Btn.getText().toString().trim().equalsIgnoreCase(correctAnswer)) {
            option3Btn.setBackgroundResource(R.drawable.green);
            option3Btn.setText(correctAnswer);
        } else if (option4Btn.getText().toString().trim().equalsIgnoreCase(correctAnswer)) {
            option4Btn.setBackgroundResource(R.drawable.green);
            option4Btn.setText(correctAnswer);
        }

        // Disable option buttons temporarily
        disableOptionButtons();

        // Show the selected answer and correct answer
        //Toast.makeText(this, "Selected Answer: " + selectedAnswer + "\nCorrect Answer: " + correctAnswer, Toast.LENGTH_SHORT).show();

        // Delay the execution of showing the next question
        option1Btn.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Reset the option button backgrounds
                option1Btn.setBackgroundResource(R.drawable.option_button_background);
                option2Btn.setBackgroundResource(R.drawable.option_button_background);
                option3Btn.setBackgroundResource(R.drawable.option_button_background);
                option4Btn.setBackgroundResource(R.drawable.option_button_background);

                // Reset the option button text
                option1Btn.setText(quizModalHardArrayList.get(currentPos).getOption1());
                option2Btn.setText(quizModalHardArrayList.get(currentPos).getOption2());
                option3Btn.setText(quizModalHardArrayList.get(currentPos).getOption3());
                option4Btn.setText(quizModalHardArrayList.get(currentPos).getOption4());

                // Enable option buttons
                enableOptionButtons();

                // Show the next question
                showNextQuestion();
            }
        }, 2000); // Adjust the delay time as needed
    }



    private void disableOptionButtons() {
        option1Btn.setEnabled(false);
        option2Btn.setEnabled(false);
        option3Btn.setEnabled(false);
        option4Btn.setEnabled(false);
    }

    private void enableOptionButtons() {
        option1Btn.setEnabled(true);
        option2Btn.setEnabled(true);
        option3Btn.setEnabled(true);
        option4Btn.setEnabled(true);
    }

    private void showNextQuestion() {
        enableOptionButtons();

        questionAttempted++;
        currentPos = random.nextInt(quizModalHardArrayList.size());
        setDataToViews(currentPos);
    }

    private void showBottomSheet() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ActivityGameHard.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet, (LinearLayout) findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button backToMenuBtn = bottomSheetView.findViewById(R.id.idBtnRestartKuis);
        Button exitBtn = bottomSheetView.findViewById(R.id.idBtnExit);
        scoreTV.setText("Skor anda adalah \n" + currentScore + "/10");
        backToMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizModalHardArrayList.size());
                setDataToViews(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityGameHard.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // Clear the activity stack
                startActivity(intent);
                finish(); // Finish the current activity
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToViews (int currentPos){
        questionNumberTV.setText("Question Attempted: " +questionAttempted+ "/10");
        if(questionAttempted == 11){
            showBottomSheet();
        }else {
            questionTV.setText(quizModalHardArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalHardArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModalHardArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModalHardArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalHardArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizQuestion(ArrayList<QuizModalHard> quizModalHardArrayList) {
        quizModalHardArrayList.add(new QuizModalHard("APBN merupakan implementasi dari salah satu fungsi pajak, yaitu", "Fungsi mengatur", "Fungsi anggaran","Fungsi stabilitas", "Fungsi pemerataan", "Fungsi anggaran"));
        quizModalHardArrayList.add(new QuizModalHard("Pajak penghasilan umumnya menggunakan 2 sistem pemungutan pajak, yaitu", "Self assessment system dan withholding system", "Official assessment system dan withholding system","Official assessment system dan self assessment system", "Semua jawaban salah", "Self assessment system dan withholding system"));
        quizModalHardArrayList.add(new QuizModalHard("Sistem pemungutan withholding system umumnya lebih banyak diterapkan pada ", "Pajak penghasilan", "Pajak pertambahan nilai dan pajak penjualan atas barang mewah","Pajak bumi dan bangunan", "Bea materai", "Pajak pertambahan nilai dan pajak penjualan atas barang mewah"));
        quizModalHardArrayList.add(new QuizModalHard("Pajak bumi dan bangunan umumnya menggunakan satu sistem pemungutan pajak, yaitu ", "Self assessment system", "Withholding system","Official assessment system", "Semua jawaban benar", "Official assessment system"));
        quizModalHardArrayList.add(new QuizModalHard("Bea materai merupakan pajak dengan tarif", "Tarif pajak proporsional", "Tarif pajak progresif","Tarif pajak degresif", "Tarif pajak tetap", "Tarif pajak tetap"));
        quizModalHardArrayList.add(new QuizModalHard("Tarif pajak tetap diterapkan pada pajak ", "Pajak penghasilan", "Pajak pertambahan nilai dan pajak penjualan atas barang mewah","Pajak bumi dan bangunan", "Bea materai", "Bea materai"));
    }


}