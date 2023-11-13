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


public class KuisIslamEasy extends AppCompatActivity {
    private TextView questionTV, questionNumberTV;
    private Button option1Btn,option2Btn, option3Btn, option4Btn;
    private ArrayList<QuizModal> quizModalArrayList;
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
        quizModalArrayList = new ArrayList<>();
        random = new Random();
        getQuizQuestion(quizModalArrayList);
        currentPos = random.nextInt(quizModalArrayList.size());
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
        String correctAnswer = quizModalArrayList.get(currentPos).getAnswer().trim();


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


                option1Btn.setText(quizModalArrayList.get(currentPos).getOption1());
                option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
                option3Btn.setText(quizModalArrayList.get(currentPos).getOption3());
                option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());


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
        currentPos = random.nextInt(quizModalArrayList.size());
        setDataToViews(currentPos);
    }

    private void showBottomSheet() {
        final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(KuisIslamEasy.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.score_bottom_sheet, (LinearLayout) findViewById(R.id.idLLScore));
        TextView scoreTV = bottomSheetView.findViewById(R.id.idTVScore);
        Button backToMenuBtn = bottomSheetView.findViewById(R.id.idBtnRestartKuis);
        Button exitBtn = bottomSheetView.findViewById(R.id.idBtnExit);
        scoreTV.setText("Skor anda adalah \n" + currentScore + "/35");
        backToMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = random.nextInt(quizModalArrayList.size());
                setDataToViews(currentPos);
                questionAttempted = 1;
                currentScore = 0;
                bottomSheetDialog.dismiss();
            }
        });
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KuisIslamEasy.this, MainActivity.class);
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
            questionTV.setText(quizModalArrayList.get(currentPos).getQuestion());
            option1Btn.setText(quizModalArrayList.get(currentPos).getOption1());
            option2Btn.setText(quizModalArrayList.get(currentPos).getOption2());
            option3Btn.setText(quizModalArrayList.get(currentPos).getOption3());
            option4Btn.setText(quizModalArrayList.get(currentPos).getOption4());
        }
    }

    private void getQuizQuestion(ArrayList<QuizModal> quizModalArrayList) {
        quizModalArrayList.add(new QuizModal("Kepercayaan sepenuh hati, diucapkan secara lisan dan dipraktikkan dalam tindakan sehari-hari, adalah pemahaman... ", "Iman", "Islam", "Taqwa", "ikhsan", "Iman"));
        quizModalArrayList.add(new QuizModal("Anita di suruh ibunya pergi ke warung untuk membeli beras dan minyak goreng. Anita diberi uang sebesar Rp.25.000, dan masih ada kembalian Rp.2.000 uang kembaliannya itu diberikan lagi kepada ibunya, perilaku yang ditunjukkan oleh Anita merupakan contoh perilaku...", "Jujur", "Boros", "Empati", "Istiqomah", "Jujur"));
        quizModalArrayList.add(new QuizModal("Perhatikan pernyataan berikut!\n1. Akan dipercaya oleh orang lain,\n2. Temukan banyak teman,\n3. Dapatkan banyak kekayaan,\n4. Akan selalu bersama Allah Subhanahu wa Ta'ala.\nApa yang melibatkan kebijaksanaan perilaku jujur adalah...", "1, 2, dan 4", "2, 3, dan 4", "1, 2, dan 3", "1, 3, dan 4", "1, 2, dan 4"));
        quizModalArrayList.add(new QuizModal("Sikap yang kuat terhadap pendirian dan konsekuensi dalam tindakan adalah pemahaman...", "Iman", "Jujur", "Mempercayai", "Istiqomah", "Iman"));
        quizModalArrayList.add(new QuizModal("Orang-orang yang memiliki sikap istiqamah akan berperilaku...", "Bersabar dan rendah hati", "Marah", "Egois", "Sombong", "Bersabar dan rendah hati"));
        quizModalArrayList.add(new QuizModal("Thaharah mengajarkan kita untuk selalu hidup...", "Bersih", "Mudah", "Perdamaian", "Tenang", "Bersih"));
        quizModalArrayList.add(new QuizModal("Menyapu wajah dan tangan hingga siku dengan tanah suci sebagai pengganti wudhu atau mandi adalah...", "Tayamum", "Thaharah", "Mandi wajib", "Istinja", "Tayamum"));
        quizModalArrayList.add(new QuizModal("Jumlah rakaat shalat lima waktu sehari dan malam adalah... raka'at.", "17", "27", "37", "47", "17"));
        quizModalArrayList.add(new QuizModal("Paman Rasulullah Shallallahu 'Alaihi wa Sallam yang sangat memusuhi dakwah Islam dan celaannya diabadikan dalam Al-Quran adalah...", "Abu Lahab", "Abu Thalib", "Hamzah bin Abi Thalib", "Abdul Mutholib", "Abu Lahab"));
        quizModalArrayList.add(new QuizModal("Sikap kaum Quraisy terhadap dakwah Rasulullah Shallallahu 'Alaihi wa Sallam pada umumnya adalah...", "Menolak semua ajakan dari Rasulullah", "Biasa-biasa saja", "Menerima atau menolak sebagian", "Terima semua undangan dari Rasulullah", "Menolak semua ajakan dari Rasulullah"));
        quizModalArrayList.add(new QuizModal("Hukum menuntut ilmu dalam Islam adalah...", "fardu 'Ain", "Fardu Kifayah", "Sunnah Mu'akkadah", "Mubah", "fardu 'Ain"));
        quizModalArrayList.add(new QuizModal("Nama-nama yang baik yang dimiliki oleh Allah Subhanahu wa Ta'ala disebut...", "Asmaul Husna", "Akhakul Karimah", "Sifat wajib Allah", "Sifat Allah untuk Allah", "Asmaul Husna"));
        quizModalArrayList.add(new QuizModal("Nama Allah Subhanahu wa Ta'ala yang berarti al-Alim berarti...", "Maha mengetahui", "Mendengar", "Perasaan yang paling", "Maha melihat", "Maha mengetahui"));
        quizModalArrayList.add(new QuizModal("Jika seseorang mempercayai kita, sikap kita harus...", "Menerima dan melaksanakan sesuai dengan kemampuan", "Menolak karena dia tidak bisa", "Terima meskipun tidak bisa", "Hargai mereka yang memberikan tugas", "Menerima dan melaksanakan sesuai dengan kemampuan"));
        quizModalArrayList.add(new QuizModal("Di bawah ini sikap yang tidak dimiliki Nabi Muhammad Shallallahu 'Alaihi wa Sallam adalah...", "Memaksakan kehendak agar mereka masuk Islam", "Menyampaikan dakwah dengan sopan dan ramah", "Memberikan kesempatan kepada mereka berpikir", "Berdakwah dengan teladan yang baik", "Memaksakan kehendak agar mereka masuk Islam"));
        quizModalArrayList.add(new QuizModal("Nabi Muhammad Shallallahu 'Alaihi wa Sallam diangkat sebagai rasul pada usia...", "40 tahun", "25 tahun", "30 tahun", "35 tahun", "40 tahun"));
        quizModalArrayList.add(new QuizModal("Malaikat diciptakan Allah Subhanahu wa Ta'ala dari...", "Cahaya", "Tanah", "Air", "Api", "Cahaya"));
        quizModalArrayList.add(new QuizModal("Iman kepada Allah Subhanahu wa Ta'ala merupakan bagian dari rukun iman yang ke...", "Satu", "Empat", "Tiga", "Dua", "Satu"));
        quizModalArrayList.add(new QuizModal("Al-Qur'an adalah kitab suci umat Islam yang berfungsi sebagai pedoman hidup. Yang dimaksud dengan pedoman hidup adalah menjadi...", "Rujukan dalam kehidupan", "Bahan untuk dipelajari", "Kitab yang selalu dibaca", "Sumber hukum bernegara", "Rujukan dalam kehidupan"));
        quizModalArrayList.add(new QuizModal("Shalat yang dilaksanakan setelah Shalat Isya sampai menjelang fajar shalat subuh dengan bilangan ganjil jumlah bilangan raka'at-nya: satu, tiga, lima, tujuh, sembilan, atau sebelas rakaat. Hukum melaksanakannya adalah sunnah mu'akkadah. Shalat tersebut dinamakan dengan shalat Sunnah...", "Witir", "Tarawih", "Khusuf", "Tasbih", "Witir"));
        quizModalArrayList.add(new QuizModal("Lawan kata dari sifat rendah hati, kecuali...", "Pembohong", "Takabbur", "Sombong", "Angkuh", "Pembohong"));
        quizModalArrayList.add(new QuizModal("Haji adalah berangkat ke tempat suci yaitu ... di Mekkah untuk melakukan rukun thawaf, sa'i dalam amalan ibadah haji untuk mendapat ridha Allah Subhanahu wa Ta'ala. Kata yang tepat untuk mengisi titik-titik di atas adalah...", "Masjidil Haram", "Masjid Aqso", "Masjid Quba", "Masjid Nabawi", "Masjidil Haram"));
        quizModalArrayList.add(new QuizModal("Dalam melaksanakan Ibadah haji, termasuk dalam melakukan wukuf di padang Arafah pakaian yang dipakai bagi laki-laki adalah tidak berjahit yang disebut pakaian...", "Ihram", "Sorban", "Jubah", "Koko", "Ihram"));
        quizModalArrayList.add(new QuizModal("Iman menurut bahasa berarti...", "Percaya", "Bahagia", "Mengetahui", "Selamat", "Percaya"));
        quizModalArrayList.add(new QuizModal("Fenomena hancurnya alam semesta merupakan gambaran terjadinya hari kiamat. Allah Subhanahu wa Ta'ala menugasi malaikat peniup sangkakala yang dapat menghancurkan alam semesta ini. Malaikat tersebut adalah...", "Israfil", "Jibril", "Mikail", "Izrail", "Israfil"));
        quizModalArrayList.add(new QuizModal("Kelebihan atau kemampuan luar biasa yang diberikan kepada nabi untuk menguatkan dakwahnya adalah...", "Mu'jizat", "Karamah", "Maunah", "Wasiat", "Mu'jizat"));
        quizModalArrayList.add(new QuizModal("Binatang yang halal dimakan tanpa di sembelih ditunjukkan oleh nomor...", "3 dan 4", "1 dan 2", "2 dan 3", "4 dan 5", "3 dan 4"));
        quizModalArrayList.add(new QuizModal("Yang bukan merupakan keutamaan mendirikan shalat adalah...", "Mengganggu aktivitas sehari-hari", "Menentramkan jiwa dan raga", "Mencegah perbuatan keji dan munkar", "Mendekatkan diri pada Allah", "Mengganggu aktivitas sehari-hari"));
        quizModalArrayList.add(new QuizModal("Tujuan diwajibkannya shalat adalah...", "Semua benar", "Mencegah perbuatan keji dan munkar", "Menjauhi larangan Allah", "Melaksanakan perintah Allah", "Semua benar"));
        quizModalArrayList.add(new QuizModal("Berikut ini perjuangan Rasulullah Shallallahu 'Alaihi wa Sallam dan sahabat-sahabatnya di Madinah dalam mencapai kejayaan, kecuali...", "Suka berperang", "Perencanaan yang matang", "Kerja sama yang baik", "Keikhlasan", "Suka berperang"));
        quizModalArrayList.add(new QuizModal("Membayar pajak merupakan, kecuali...", "Pemberian sukarela masyarakat bagi negara", "Tindakan yang bermanfaat bagi negara dan juga bagi masyarakat", "Bentuk partisipasi dalam membangun negara", "Kewajiban masyarakat bagi negara", "Pemberian sukarela masyarakat bagi negara"));
        quizModalArrayList.add(new QuizModal("Semua pihak yang merupakan pembayar pajak, pemotong pajak, dan pemungut pajak, serta mempunyai hak dan kewajiban perpajakan sesuai dengan peraturan perundang-undangan perpajakan, baik individu maupun badan disebut sebagai...", "Wajib Pajak", "Wajib Bayar", "Wajib Pungut", "Wajib Beli", "Wajib Pajak"));
        quizModalArrayList.add(new QuizModal("Tempat Wajib Pajak untuk melaporkan pajaknya adalah...", "Kantor Pajak Pratama (KPP)", "Kantor Keuangan Milik Negara", "Kantor Pos dan BUMN yang ditunjuk Menteri Keuangan", "BUMN dan BUMD", "Kantor Pajak Pratama (KPP)"));
        quizModalArrayList.add(new QuizModal("Pajak yang dikenakan kepada badan atau orang pribadi atas penghasilan yang diterima selama tahun pajak disebut...", "Pajak penghasilan", "Penghasilan", "Penghasilan final", "Subjek pajak penghasilan", "Pajak penghasilan"));
        quizModalArrayList.add(new QuizModal("Contoh pengingkaran kewajiban sebagai warga negara adalah...", "Tidak membayar pajak", "Mentaati hukum yang berlaku", "Tidak memeluk agama", "Tidak menyekolahkan anak", "Tidak membayar pajak"));
    }
}
