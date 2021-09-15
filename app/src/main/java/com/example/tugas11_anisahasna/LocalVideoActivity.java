package com.example.tugas11_anisahasna;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class LocalVideoActivity extends AppCompatActivity {

    //Deklarasi Variable
    private VideoView videoView;
    private MediaController mediaController;
    private Button playVideo, switchMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_video);

        //Inisialisasi VideoView, MediaController dan Button
        videoView = findViewById(R.id.video);
        playVideo = findViewById(R.id.play);
        mediaController = new MediaController(this);


        //Menjalankan Video saat tombol Play di Klik
        playVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Variable Uri untuk menentukan lokasi Resource Video yang akan ditampilkan
                Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video2);

                videoView.setVideoURI(uri);

                //Memasang MediaController untuk menampilkan tombol play, pause, dsb
                videoView.setMediaController(mediaController);
                mediaController.setAnchorView(videoView);

                //Menjalankan Video
                videoView.start();
            }
        });

        switchMusic = findViewById(R.id.switchMusic);

        switchMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), LocalActivity.class);
                startActivity(i);
            }
        });
    }
}