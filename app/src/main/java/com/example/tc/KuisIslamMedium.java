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

public class KuisIslamMedium extends AppCompatActivity {
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
        setContentView(R.layout.kuis_islam_easy);

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

        if (selectedAnswer.equalsIgnoreCase(correctAnswer)) {
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
            disableOptionButtons();

            happyImageView.setVisibility(View.VISIBLE);
            sadImageView.setVisibility(View.GONE);

            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.correctanswer);
            mediaPlayer.start();

        } else {
            showWrongAnswer(selectedAnswer, correctAnswer);

            sadImageView.setVisibility(View.VISIBLE);
            happyImageView.setVisibility(View.GONE);

            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.incorrectanswer);
            mediaPlayer.start();
        }

        disableOptionButtons();

        option1Btn.postDelayed(new Runnable() {
            @Override
            public void run() {
                option1Btn.setBackgroundResource(R.drawable.option_button_background);
                option2Btn.setBackgroundResource(R.drawable.option_button_background);
                option3Btn.setBackgroundResource(R.drawable.option_button_background);
                option4Btn.setBackgroundResource(R.drawable.option_button_background);
                happyImageView.setVisibility(View.GONE);
                sadImageView.setVisibility(View.GONE);

                enableOptionButtons();

                showNextQuestion();
            }
        }, 2000);
    }


    private void showWrongAnswer(String selectedAnswer, String correctAnswer) {
        if (option1Btn.getText().toString().trim().equalsIgnoreCase(selectedAnswer)) {
            option1Btn.setBackgroundResource(R.drawable.red);
        } else if (option2Btn.getText().toString().trim().equalsIgnoreCase(selectedAnswer)) {
            option2Btn.setBackgroundResource(R.drawable.red);
        } else if (option3Btn.getText().toString().trim().equalsIgnoreCase(selectedAnswer)) {
            option3Btn.setBackgroundResource(R.drawable.red);
        } else if (option4Btn.getText().toString().trim().equalsIgnoreCase(selectedAnswer)) {
            option4Btn.setBackgroundResource(R.drawable.red);
        }

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

        disableOptionButtons();

        option1Btn.postDelayed(new Runnable() {
            @Override
            public void run() {
                option1Btn.setBackgroundResource(R.drawable.option_button_background);
                option2Btn.setBackgroundResource(R.drawable.option_button_background);
                option3Btn.setBackgroundResource(R.drawable.option_button_background);
                option4Btn.setBackgroundResource(R.drawable.option_button_background);

                option1Btn.setText(quizModalMediumArrayList.get(currentPos).getOption1());
                option2Btn.setText(quizModalMediumArrayList.get(currentPos).getOption2());
                option3Btn.setText(quizModalMediumArrayList.get(currentPos).getOption3());
                option4Btn.setText(quizModalMediumArrayList.get(currentPos).getOption4());

                enableOptionButtons();

                showNextQuestion();
            }
        }, 2000);
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
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(KuisIslamMedium.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet, (LinearLayout) findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button backToMenuBtn = bottomSheetView.findViewById(R.id.idBtnRestartKuis);
        Button exitBtn = bottomSheetView.findViewById(R.id.idBtnExit);
        scoreTV.setText("Skor anda adalah \n" + currentScore + "/35");
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
                Intent intent = new Intent(KuisIslamMedium.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        });
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

    private void setDataToViews (int currentPos){
        questionNumberTV.setText("Question Attempted: " +questionAttempted+ "/35");
        if(questionAttempted == 36){
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
        quizModalMediumArrayList.add(new QuizModalMedium("Di bawah ini adalah persamaan antara jin dan manusia, kecuali ...", "Memiliki kecerdasan", "Memiliki pengetahuan", "Diciptakan dari tanah", "Diperintah untuk beriman dan beramal sholeh", "Diciptakan dari tanah"));
        quizModalMediumArrayList.add(new QuizModalMedium("Peristiwa manusia setelah kematiannya berada di Alam kubur sampai datang Kiamat dan kemudian dibangkitkannya dari kuburnya tersebut kemudian mereka akan dihalau disebuah padang yang luas berkumpul seluruh manusia sejak nabi Adam Alaihis Salam sampai manusia terakhir, yaitu padang ....", "Barzakh", "Mahsyar", "Surga", "Neraka", "Mahsyar"));
        quizModalMediumArrayList.add(new QuizModalMedium("Hari raya Idul Fitri jatuh pada tanggal ….", "1 Dzulhijah", "1 Rajab", "1 Syawwal", "1 Sya’ban", "1 Syawwal"));
        quizModalMediumArrayList.add(new QuizModalMedium("Salah satu persamaan antara malaikat dan jin adalah keduanya sama-sama...", "Berjenis kelamin", "Makhluk gaib", "Berkembang biak", "Memiliki nafsu", "Makhluk gaib"));
        quizModalMediumArrayList.add(new QuizModalMedium("Menampakan keimanan dan menyembunyikan kekafiran di hatinya. Pernyataan ini adalah pengertian dari ....", "Ghadab", "Namimah", "Ananiah", "Munafik", "Ananiah"));
        quizModalMediumArrayList.add(new QuizModalMedium("Misi utama yang harus di laksanakan Rasulullah Shallallahu 'Alaihi wa Sallam adalah menjadikan ....", "Masyarakat hidup berkecukupan", "Rakyat hidup harmonis", "Akhlak umat lebih mulia", "Bahasa Arab menjadi bahasa dunia", "Akhlak umat lebih mulia"));
        quizModalMediumArrayList.add(new QuizModalMedium("Makna beriman kepada Kitabullah adalah meyakini bahwa Allah Subhanahu wa Ta'ala memiliki kitab-kitab yang diturunkan kepada para Rasul-Nya untuk disampaikan kepada umat manusia. Berdasarkan ilustrasi tersebut, pernyataan yang bukan hikmah beriman kepada Kitabullah adalah ... .", "meningkatkan keimanan kepada Allah Subhanahu wa Ta'ala yang telah mengutus para Rasul untuk menyampaikan risalah-Nya.", "hidup manusia menjadi tertata karena adanya hukum yang bersumber dari kebiasaan nenek moyang", "termotivasi untuk beribadah dan menjalankan kewajiban-kewajiban agama, seperti yang tertuang dalam kitab suci.", "menumbuhkan sikap optimis karena telah dikaruniai pedoman hidup dari Allah Subhanahu wa Ta'ala untuk meraih kesuksesan di dunia dan akhirat.", "hidup manusia menjadi tertata karena adanya hukum yang bersumber dari kebiasaan nenek moyang"));
        quizModalMediumArrayList.add(new QuizModalMedium("Mu.jizat Nabi Muhammad Shallallahu 'Alaihi wa Sallam yang terbesar adalah ….", "Membelah bulan", "Memindahkan matahari", "Al-Qur’an", "Hadits", "Al-Qur’an"));
        quizModalMediumArrayList.add(new QuizModalMedium("Iman kepada malaikat adalah rukun iman yang ke ….", "4", "2", "6", "3", "2"));
        quizModalMediumArrayList.add(new QuizModalMedium("Apabila mendapat nikmat dari Allah Subhanahu wa Ta'ala harus bersyukur dengan mengucap ....", "Subhanallah", "Alhamdulillah", "Astaghfirullah", "Laailahailallah", "Alhamdulillah"));
        quizModalMediumArrayList.add(new QuizModalMedium("Peristiwa turunnya Al-Qur’an, sering diperingati dengan sebutan ...", "Nuzulul Qur’an", "Maulid Nabi", "Isra Mi’raj", "Lailatul Qadar", "Nuzulul Qur’an"));
        quizModalMediumArrayList.add(new QuizModalMedium("Shalat sunnat yang tidak ada sujud dan ruku’nya disebut ...", "Shalat Jenazah", "Shalat Tahiyatul Masjid", "Shalat Tahajjud", "Shalat Ghaib", "Shalat Jenazah"));
        quizModalMediumArrayList.add(new QuizModalMedium("Berbuat sesuatu semata-mata hanya karena Allah Subhanahu wa Ta'ala dinamakan ...", "Ikhlas", "Riya’", "Jujur", "Sopan", "Ikhlas"));
        quizModalMediumArrayList.add(new QuizModalMedium("Yang mendapat julukan Bapak para Nabi adalah Nabi", "Nabi Ibrahim Alaihis Salam", "Nabi Muhammad Shallallahu 'Alaihi wa Sallam", "Nabi Isa Alaihis Salam", "Nabi Sulaiman Alaihis Salam", "Nabi Ibrahim Alaihis Salam"));
        quizModalMediumArrayList.add(new QuizModalMedium("Sebutan bagi orang yang mengumandangkan adzan adalah ...", "Muadzin", "Bilal", "Makmum", "Imam", "Muadzin"));
        quizModalMediumArrayList.add(new QuizModalMedium("Seruan atau panggilan sebagai ajakan menunaikan ibadah shalat disebut ...", "Adzan", "Sholawat", "Iqomah", "Muadzin", "Adzan"));
        quizModalMediumArrayList.add(new QuizModalMedium("Rukun iman berjumlah ...", "6", "10", "5", "7", "6"));
        quizModalMediumArrayList.add(new QuizModalMedium("Nabi dan Rasul yang wajib kita imani ada ...", "25", "10", "6", "20", "25"));
        quizModalMediumArrayList.add(new QuizModalMedium("Orang lanjut usia yang tidak kuat boleh tidak berpuasa dan mengganti dengan membayar ...", "Fidyah", "Hutang", "Sedekah", "Pajak", "Fidyah"));
        quizModalMediumArrayList.add(new QuizModalMedium("Para Rasul dan Nabi yang diberi kesabaran dan keteguhan tinggi ketika diuji disebut ...", "Ulul Azmi", "Ulul Amri", "Ulul Abi", "Ulin Nuha", "Ulul Azmi"));
        quizModalMediumArrayList.add(new QuizModalMedium("Pemuda yang tetap imannya meski terkurung di gua ratusan tahun disebut ...", "Ashabul Kahfi", "Asbabun Nuzul", "Ashabul Jannah", "Ashabul Rasul", "Ashabul Kahfi"));
        quizModalMediumArrayList.add(new QuizModalMedium("Orang yang berjihad di jalan Allah Subhanahu wa Ta'ala disebut ...", "Mujahid", "Musafir", "Muhajir", "Munafik", "Mujahid"));
        quizModalMediumArrayList.add(new QuizModalMedium("Matahari akan terbit dari barat merupakan salah satu tanda datangnya ...", "Kiamat", "Rizki", "Hujan", "Bencana", "Kiamat"));
        quizModalMediumArrayList.add(new QuizModalMedium("Nama-nama Allah Subhanahu wa Ta'ala yang mulia, atau asmaul husna berjumlah", "99", "100", "101", "98", "99"));
        quizModalMediumArrayList.add(new QuizModalMedium("Orang yang menyampaikan khutbah disebut ...", "Khotib", "Imam", "Muadzin", "Muallaf", "Khotib"));
        quizModalMediumArrayList.add(new QuizModalMedium("Surat terakhir dalam urutan mushaf Al-Qur’an adalah ...", "Al-Falaq", "An-Nas", "Al-Ikhlas", "Al-Fatihah", "Al-Falaq"));
        quizModalMediumArrayList.add(new QuizModalMedium("Kakek Nabi Muhammad Shallallahu 'Alaihi wa Sallamyang juga sebagai penjaga Ka’bah bernama ...", "Abdul Muthalib", "Abu Lahab", "Abdullah", "Abu Thalib", "Abdul Muthalib"));
        quizModalMediumArrayList.add(new QuizModalMedium("Di akhirat kelak amal manusia akan ditimbang, maka saat itu sering disebut ...", "Yaumul Mizan", "Yaumul Din", "Yaumul Jaza", "Yaumul Hisab", "Yaumul Mizan"));
        quizModalMediumArrayList.add(new QuizModalMedium("Seorang muslim diharuskan memiliki akhlak terpuji atau disebut juga ...", "Akhlakul Karimah", "Uswatun Hasanah", "Amal Jariyah", "Sadaqah Jariyah", "Akhlakul Karimah"));
        quizModalMediumArrayList.add(new QuizModalMedium("Orang yang berhak menerima zakat disebut ...", "Mustahiq", "Muallaf", "Amil", "Mudarris", "Mustahiq"));

    }
}
