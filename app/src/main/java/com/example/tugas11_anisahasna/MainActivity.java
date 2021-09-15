package com.example.tugas11_anisahasna;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Deklarasi Variable
    private CardView cardKpop, cardLocal, cardWestern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardKpop = (CardView) findViewById(R.id.card1);
        cardLocal = (CardView) findViewById(R.id.card2);
        cardWestern = (CardView) findViewById(R.id.card3);

        cardKpop.setOnClickListener(this);
        cardLocal.setOnClickListener(this);
        cardWestern.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        Intent i;

        switch (view.getId()){
            case R.id.card1:
                i = new Intent(this, KpopActivity.class);
                startActivity(i);
                break;

            case R.id.card2:
                i = new Intent(this, LocalActivity.class);
                startActivity(i);
                break;

            case R.id.card3:
                i = new Intent(this, WesternActivity.class);
                startActivity(i);
                break;
        }

    }
}