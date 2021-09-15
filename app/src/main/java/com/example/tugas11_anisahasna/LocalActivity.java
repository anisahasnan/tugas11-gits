package com.example.tugas11_anisahasna;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class LocalActivity extends AppCompatActivity implements View.OnClickListener{

    //Deklarasi Variable
    private Button Play, Pause, Stop, switchVid;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        //Inisialisasi Button
        Play = findViewById(R.id.play);
        Pause = findViewById(R.id.pause);
        Stop = findViewById(R.id.stop);
        switchVid = findViewById(R.id.switchVid);

        //Menambahkan Listener pada Button
        Play.setOnClickListener(this);
        Pause.setOnClickListener(this);
        Stop.setOnClickListener(this);
        switchVid.setOnClickListener(this);

        stateAwal();
    }

    //Untuk menentukan kondisi saat aplikasi pertama kali berjalan
    private void stateAwal(){
        Play.setEnabled(true);
        Pause.setEnabled(false);
        Stop.setEnabled(false);
    }

    //Method untuk memainkan musik
    private void playAudio(){
        //Menentukan resource audio yang akan dijalankan
        mediaPlayer = MediaPlayer.create(this, R.raw.music2);

        //Kondisi Button setelah tombol play di klik
        Play.setEnabled(false);
        Pause.setEnabled(true);
        Stop.setEnabled(true);

        //Menjalankan Audio / Musik
        try{
            mediaPlayer.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer.start();

        //Setelah audio selesai dimainkan maka kondisi Button akan kembali seperti awal
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void pauseAudio(){

        //Jika audio sedang dimainkan, maka audio dapat di pause
        if(mediaPlayer.isPlaying()){
            if(mediaPlayer != null){
                mediaPlayer.pause();
                Pause.setText("Lanjutkan");
            }
        }else {

            //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
            if(mediaPlayer != null){
                mediaPlayer.start();
                Pause.setText("Pause");
            }
        }
    }

    //Method untuk mengakhiri musik
    private void stopAudio(){
        mediaPlayer.stop();
        try {
            //Menyetel audio ke status awal
            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
        }catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal();
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.play:
                playAudio();
                break;

            case R.id.pause:
                pauseAudio();
                break;

            case R.id.stop:
                stopAudio();
                break;

            case R.id.switchVid:
                i = new Intent(this, LocalVideoActivity.class);
                startActivity(i);
        }
    }
}