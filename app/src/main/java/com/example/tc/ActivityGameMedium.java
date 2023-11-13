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


public class ActivityGameMedium extends AppCompatActivity {

    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModalMedium> quizModalMediumArrayList;
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
        quizModalMediumArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestionM(quizModalMediumArrayList);
        currentPos = random.nextInt(quizModalMediumArrayList.size());
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
        String correctAnswer = quizModalMediumArrayList.get(currentPos).getAnswer().trim();

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
                option1Btn.setText(quizModalMediumArrayList.get(currentPos).getOption1());
                option2Btn.setText(quizModalMediumArrayList.get(currentPos).getOption2());
                option3Btn.setText(quizModalMediumArrayList.get(currentPos).getOption3());
                option4Btn.setText(quizModalMediumArrayList.get(currentPos).getOption4());

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
        currentPos = random.nextInt(quizModalMediumArrayList.size());
        setDataToViews(currentPos);
    }

    private void showBottomSheet() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(ActivityGameMedium.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet, (LinearLayout) findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button backToMenuBtn = bottomSheetView.findViewById(R.id.idBtnRestartKuis);
        Button exitBtn = bottomSheetView.findViewById(R.id.idBtnExit);
        scoreTV.setText("Skor anda adalah \n" + currentScore + "/10");
        backToMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizModalMediumArrayList.size());
                setDataToViews(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityGameMedium.this, MainActivity.class);
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
            questionTV.setText(quizModalMediumArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalMediumArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModalMediumArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModalMediumArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalMediumArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizQuestionM(ArrayList<QuizModalMedium> quizModalMediumArrayList) {
        quizModalMediumArrayList.add(new QuizModalMedium("Jenis pajak yang pembebanannya dapat dilimpahkan kepada kepada pihak lain adalah", "Pajak langsung", "Pajak tidak langsung","Pajak objektif", "Pajak subjektif", "Pajak tidak langsung"));
        quizModalMediumArrayList.add(new QuizModalMedium("Pajak yang dikenakan kepada orang pribadi atau badan atas penghasilan yang diterima atau diperoleh dalam suatu tahun pajak dinamakan dengan ", "Pajak pertambahan nilai", "Pajak penghasilan ","Pajak penjualan atas Barang Mewah", "Pajak bumi dan Bangunan", "Pajak penghasilan"));
        quizModalMediumArrayList.add(new QuizModalMedium("Pajak kendaran bermotor merupakan jenis pajak ", "Pajak pusat", "Pajak kabupaten","Pajak kota", "Pajak provinsi ", "Pajak provinsi"));
        quizModalMediumArrayList.add(new QuizModalMedium("I) Warga Negara yang memiliki penghasilan melebihi PTKP \n" +
                "II) Tidak mendapatkan imbalan secara langsung \n" +
                "III) Bersifat tidak wajib \n" +
                "IV) Dipungut oleh Negara berdasarkan Undang-undang\n" +
                "V) Digunakan untuk kepentingan pribadi\n", "I, II, dan III", "II, III, dan IV ","I, II, dan IV ", "III. IV, dan V ", "I, II, dan IV"));
        quizModalMediumArrayList.add(new QuizModalMedium("Pengertian dari APBN adalah ", "Suatu indikator yang digunakan untuk membiayai pembangunan negara", "Suatu daftar yang terperinci dalam penerimaan dan pengeluaran negara dalam jangka waktu tertentu","Suatu daftar yang terperinci yang digunakan oleh pemerintah untuk membiayai pengeluaran pemerintah", "Suatu daftar yang terperinci dalam penerimaan dan pengeluaran negara dalam jangka waktu tertentu", "Suatu daftar yang terperinci dalam penerimaan dan pengeluaran negara dalam jangka waktu tertentu"));
        quizModalMediumArrayList.add(new QuizModalMedium("7. Berikut hal-hal yang berhubungan dengan APBN : \n" +
                "1.\tGaji pegawai \n" +
                "2.\tPajak penghasilan \n" +
                "3.\tSubsidi daerah otonom \n" +
                "4.\tBunga dan cicilan utang\n" +
                "5.\tPajak ekspor \n" +
                "6.\tMinyak bumi dan gas alam \n" +
                "Yang merupakan sebagai sumber dari penerimaan Negara adalah \n", "1,2 dan 3", "2,3 dan 4","2, 5 dan 6", "4,5 dan 6", "2,5 dan 6"));
        quizModalMediumArrayList.add(new QuizModalMedium("Penerimaan yang tidak termasuk ke dalam penerimaan bukan pajak adalah ", "Pajak bumi dan bangunan", "Pajak pertambahan nilai","Bea materai", "Laba BUMN ", "Laba BUMN "));

    }


}