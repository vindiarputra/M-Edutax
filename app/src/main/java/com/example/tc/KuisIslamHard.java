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

public class KuisIslamHard extends AppCompatActivity {
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
        setContentView(R.layout.kuis_islam_easy);

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

                option1Btn.setText(quizModalHardArrayList.get(currentPos).getOption1());
                option2Btn.setText(quizModalHardArrayList.get(currentPos).getOption2());
                option3Btn.setText(quizModalHardArrayList.get(currentPos).getOption3());
                option4Btn.setText(quizModalHardArrayList.get(currentPos).getOption4());

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
        currentPos = random.nextInt(quizModalHardArrayList.size());
        setDataToViews(currentPos);
    }

    private void showBottomSheet() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(KuisIslamHard.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet, (LinearLayout) findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button backToMenuBtn = bottomSheetView.findViewById(R.id.idBtnRestartKuis);
        Button exitBtn = bottomSheetView.findViewById(R.id.idBtnExit);
        scoreTV.setText("Skor anda adalah \n" + currentScore + "/35");
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
                Intent intent = new Intent(KuisIslamHard.this, MainActivity.class);
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
        if(questionAttempted == 35){
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
        quizModalHardArrayList.add(new QuizModalHard("Ilmu yang membicarakan tentang cara-cara yang menetapkan aqidah agama dengan mempergunakan dalil-dalil yang meyakinkan, disebut:", "Ilmu Tauhid", "Ilmu Akhlaq", "Ilmu Fiqih", "Ilmu Filsafat", "Ilmu Tauhid"));
        quizModalHardArrayList.add(new QuizModalHard("Agama Islam adalah termasuk dalam golongan:", "Agama Samawi", "Agama Thabii", "Dinu’L-Ardhi", "Natural Religion", "Agama Samawi"));
        quizModalHardArrayList.add(new QuizModalHard("Dibawah ini adalah bagaimana caranya kita menghidupkan sunnah Rasulullah, kecuali ...", "Adanya kemarahan pada diri kita terhadap orang yang menyelisih sunnah atau berpaling darinya", "Sebagai teladan dalam kehidupan sehari-hari", "Mengenal Rasulullah", "Mempelajari sunnah Rasulullah dan mengajarkannya", "Adanya kemarahan pada diri kita terhadap orang yang menyelisih sunnah atau berpaling darinya"));
        quizModalHardArrayList.add(new QuizModalHard("Dibawah ini yang merupakan syarat sahnya sholat adalah:", "Suci dari hadast besar dan hadast kecil", "Membaca surat Al-Fatihah pada setiap rakaat", "Ruku’ dengan tuma’ninah", "Berdiri (bagi yang mampu)", "Suci dari hadast besar dan hadast kecil"));
        quizModalHardArrayList.add(new QuizModalHard("Kitab yang diberikan kepada Nabi Musa Alaihis Salam adalah ...", "Taurat", "Zabur", "Injil", "Al-Qur’an", "Taurat"));
        quizModalHardArrayList.add(new QuizModalHard("Nabi Musa Alaihis Salam telah menerima wahyu melalui dialog langsung dengan Tuhan Yang Mahakuasa. Dan terjadi di ...", "Jabal Nur", "Gua Hira", "Jabal Rahmah", "Bukit Thursina", "Jabal Nur"));
        quizModalHardArrayList.add(new QuizModalHard("Sumber pokok aajaran Islam adalah ...", "Al-Qur’an dan as-Sunnah", "Al-Qur’an, Hadits, Ijma’ dan Qiyas", "Al-Qur’an, as-Sunnah, dan Ijtihad", "Al-Qur’an, as-Sunnah, dan Urf", "Al-Qur’an dan as-Sunnah"));
        quizModalHardArrayList.add(new QuizModalHard("Aurat bagi wanita muslim adalah seluruh tubuhnya kecuali telapak tangan dan ...", "Wajahnya", "Rambutnya", "Kakinya", "Kepalanya", "Wajahnya"));
        quizModalHardArrayList.add(new QuizModalHard("Wukuf di Padang Arafah adalah salah satu…", "Rukun Haji", "Syarat wajib Haji", "Sunnah Haji", "Jenis ibadah Haji", "Rukun Haji"));
        quizModalHardArrayList.add(new QuizModalHard("Suatu perbuatan apabila dikerjakan tidak mendapat pahala dan tidak pula berdosa, dan kalau ditinggalkan juga tidak berpahala dan tidak berdosa, di dalam Islam masuk hukum yang bernamakan …", "Mubah", "Wajib", "Sunnah", "Haram", "Mubah"));
        quizModalHardArrayList.add(new QuizModalHard("Apabila nun mati atau tanwin bertemu dengan huruf ba disebut ....", "Iqlab", "Ikhfa", "Izhar", "Idgham Bigunnah", "Iqlab"));
        quizModalHardArrayList.add(new QuizModalHard("Mengucapkan dua kalimat syahadat termasuk ...", "Rukun Islam", "Rukun Iman", "Rukun Sholat", "Rukun Puasa", "Rukun Islam"));
        quizModalHardArrayList.add(new QuizModalHard("Perintah sholat diterima Nabi Muhammad Shallallahu 'Alaihi wa Sallam, dalam peristiwa yang dikenal dengan ....", "Isra Miraj", "Nuzul Quran", "Maulid Nabi", "Nisfu Syaban", "Isra Miraj"));
        quizModalHardArrayList.add(new QuizModalHard("Surah Al-Quran yang pertama kali diturunkan kepada Nabi Muhammad Shallallahu 'Alaihi wa Sallam adalah ...", "Surah Al-'Alaq", "Surah Al-Fatihah", "Surah Yasin", "Surah Al-Ikhlas", "Surah Al-'Alaq"));
        quizModalHardArrayList.add(new QuizModalHard("Membaca Surah Al-Fatihah termasuk ... solat", "Rukun", "Syarat", "Wajib", "Sunnah", "Rukun"));
        quizModalHardArrayList.add(new QuizModalHard("Anak wajib berbakti kepada kedua orang tuanya disebut juga dengan istilah ...", "Birrul Walidain", "Khusnul Hatimah", "Suul Walidain", "Suul Khotimah", "Birrul Walidain"));
        quizModalHardArrayList.add(new QuizModalHard("Sifat yang mungkin dimiliki oleh Allah, dan mungkin tidak dimiliki oleh Allah dinamakan sifat ...", "Jaiz", "Wajib", "Mustahil", "Berkehendak", "Jaiz"));
        quizModalHardArrayList.add(new QuizModalHard("Al-Quran terdiri dari ...", "114 Surah 30 Juz", "144 Surah 33 Juz", "141 Surah 30 Juz", "124 Surah 33 Juz", "114 Surah 30 Juz"));
        quizModalHardArrayList.add(new QuizModalHard("Intisari Surah Al-Baqarah Ayat 183 adalah ...", "Perintah Puasa", "Perintah Zakat", "Perintah Berlaku Adil", "Perintah Solat", "Perintah Puasa"));
        quizModalHardArrayList.add(new QuizModalHard("Nama Muhammad memiliki arti orang yang ...", "Terpuji", "Kuat", "Cermat", "Teliti", "Terpuji"));
        quizModalHardArrayList.add(new QuizModalHard("Gura Hira merupakan tempat yang sangat bersejarah dan terkenal karena merupakan tempat", "Turunnya Wahyu Pertama", "Kelahiran Nabi", "Meninggalnya Aminah", "Membangun Masjid Kuba", "Turunnya Wahyu Pertama"));
        quizModalHardArrayList.add(new QuizModalHard("Jenazah berikut yang tidak boleh dimandikan adalah….", "Para Syuhada", "Anak-anak", "Seorang Pezina", "Seorang Ulama Besar", "Para Syuhada"));
        quizModalHardArrayList.add(new QuizModalHard("Ilmu yang mempelajari kaidah membaca Alquran dengan benar disebut ….", "Ilmu Tajwid", "Ilmu Tauhid", "Ilmu Hadis", "Ilmu Nahwu", "Ilmu Tajwid"));
        quizModalHardArrayList.add(new QuizModalHard("Iman kepada Hari Akhir adalah...", "Percaya dengan penuh keyakinan adanya hidup yang kekal abadi di akhirat kelak", "Percaya dengan penuh keyakinan adanya kematian yang kekal abadi di alam barzah", "Percaya dengan penuh keyakinan adanya alam kubur setelah dibangkitkan manusia", "Percaya dengan penuh keyakinan adanya alam akhirat di dunia", "Percaya dengan penuh keyakinan adanya hidup yang kekal abadi di akhirat kelak"));
        quizModalHardArrayList.add(new QuizModalHard("Fastabiqul khairat mempunyai arti yaitu ….", "Berlomba dalam kebaikan", "Berlomba dalam belajar", "Berlomba dalam kesehatan", "Berlomba dalam disiplin", "Berlomba dalam kebaikan"));
        quizModalHardArrayList.add(new QuizModalHard("Era ketidaktahuan juga disebut zaman ….", "Jahiliyah", "Madaniyah", "Makiyah", "Kaya", "Jahiliyah"));
        quizModalHardArrayList.add(new QuizModalHard("Bagian tubuh yang mungkin tidak ditampilkan sesuai dengan ajaran Islam disebut …", "Aurat", "Dekorasi", "Pakaian", "Jubah", "Aurat"));
        quizModalHardArrayList.add(new QuizModalHard("Melakukan perbuatan sesuai dengan apa yang telah diucapkan sebagai pernyataan kesanggupan adalah bentuk dari akhlakul karimah …", "Amanah", "Istiqamah", "Jujur", "Adil", "Amanah"));
        quizModalHardArrayList.add(new QuizModalHard("Paman Nabi Muhammad yang wafat dalam perang Uhud yaitu....", "Hamzah", "Abu Tholib", "Abu Jahal", "Abu Lahab", "Hamzah"));
        quizModalHardArrayList.add(new QuizModalHard("Apabila Nun mati atau tanwin bertemu dengan huruf mim maka hukum bacaannya adalah ….", "Idhgam Bigunnah", "Iqlab", "Ikhfa", "Izhar", "Idhgam Bigunnah"));
        quizModalHardArrayList.add(new QuizModalHard("Media dalam melaporkan kewajiban perpajakan adalah ….", "Surat Pemberitahuan Pajak", "Slip Gaji", "Struk Pembayaran", "Bukti Pemotongan", "Surat Pemberitahuan Pajak"));
        quizModalHardArrayList.add(new QuizModalHard("Dalam pemungutan pajak penghasilan, dikenakan tarif yang berbeda bagi setiap lapisannya. Semakin besar penghasilan, maka semakin besar tarif yang dikenakan. Tarif ini disebut juga sebagai tarif …", "Progresif", "Proporsional", "Regresif", "Degresif", "Progresif"));
        quizModalHardArrayList.add(new QuizModalHard("Sistem pemungutan pajak yang memberikan kuasa kepada pihak ketiga untuk memotong/memungut pajak terutang milik Wajib Pajak adalah …", "Withholding System", "Official Assessment System", "Self Assessment System", "Semua Benar", "Withholding System"));
        quizModalHardArrayList.add(new QuizModalHard("Jumlah penghasilan yang tidak dikenakan pajak disebut....", "PTKP", "PJKP", "PKP", "PPKP", "PTKP"));
        quizModalHardArrayList.add(new QuizModalHard("Pajak yang pengenaannya bersifat final sehingga dapat tidak dikreditkan dari total pajak terutama pada akhir tahun pajak disebut ...", "Pajak Penghasilan Final", "Penghasilan Tidak Kena Pajak", "Penghasilan Final", "Pajak Penghasilan", "Pajak Penghasilan Final"));

    }
}
