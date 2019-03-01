package com.example.pianocomposers;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    private static final String[] eras = {"Baroque", "Classical", "Romantic", "Contemporary"};

    private MediaPlayer mp;
    public Button button1;
    public Button button2;
    public ImageView img;
    private String wh_era;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button1 = findViewById(R.id.pause);
        button2 = findViewById(R.id.play);
        img = findViewById(R.id.icon);
        TextView era = findViewById(R.id.textView);

        Intent info = getIntent();
        wh_era = info.getStringExtra("What Era");

        if(wh_era.equals(eras[0])){
            era.setText(eras[0]);
        }
        else if(wh_era.equals(eras[1])){
            era.setText(eras[1]);
        }
        else if(wh_era.equals(eras[2])){
            era.setText(eras[2]);
        }
        else {
            era.setText(eras[3]);
        }
    }

    public void radio_Click(View view) {
        if (view.getId() == R.id.song1) {
            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            if (wh_era.equals(eras[0])){
                img.setImageResource(R.drawable.bach);
                stopPlaying();
                mp = MediaPlayer.create(Main2Activity.this, R.raw.invention);
                mp.start();
            }
            else if(wh_era.equals(eras[1])){
                img.setImageResource(R.drawable.beethoven);
                stopPlaying();
                mp = MediaPlayer.create(Main2Activity.this, R.raw.bagatelle);
                mp.start();
            }
            else if(wh_era.equals(eras[2])){
                img.setImageResource(R.drawable.chopin);
                stopPlaying();
                mp = MediaPlayer.create(Main2Activity.this, R.raw.nocturne);
                mp.start();
            }
            else{
                img.setImageResource(R.drawable.debussy);
                stopPlaying();
                mp = MediaPlayer.create(Main2Activity.this, R.raw.clair);
                mp.start();
            }


        } else if (view.getId() == R.id.song2) {
            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            if (wh_era.equals(eras[0])){
                img.setImageResource(R.drawable.bach);
                stopPlaying();
                mp = MediaPlayer.create(Main2Activity.this, R.raw.prelude);
                mp.start();
            }
            else if(wh_era.equals(eras[1])){
                img.setImageResource(R.drawable.mozart);
                stopPlaying();
                mp = MediaPlayer.create(Main2Activity.this, R.raw.sonata);
                mp.start();
            }
            else if(wh_era.equals(eras[2])){
                img.setImageResource(R.drawable.chopin);
                stopPlaying();
                mp = MediaPlayer.create(Main2Activity.this, R.raw.fantaisie);
                mp.start();
            }
            else{
                img.setImageResource(R.drawable.debussy);
                stopPlaying();
                mp = MediaPlayer.create(Main2Activity.this, R.raw.cathedral);
                mp.start();
            }
        } else {
            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            if (wh_era.equals(eras[0])){
                img.setImageResource(R.drawable.bach);
                stopPlaying();
                mp = MediaPlayer.create(Main2Activity.this, R.raw.partita);
                mp.start();
            }
            else if(wh_era.equals(eras[1])){
                img.setImageResource(R.drawable.clementi);
                stopPlaying();
                mp = MediaPlayer.create(Main2Activity.this, R.raw.sonatina);
                mp.start();
            }
            else if(wh_era.equals(eras[2])){
                img.setImageResource(R.drawable.albeniz);
                stopPlaying();
                mp = MediaPlayer.create(Main2Activity.this, R.raw.granada);
                mp.start();
            }
            else{
                img.setImageResource(R.drawable.faure);
                stopPlaying();
                mp = MediaPlayer.create(Main2Activity.this, R.raw.romance);
                mp.start();
            }
        }
    }

    public void onBackPressed(){
        stopPlaying();
        finish();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        stopPlaying();
    }

    private void stopPlaying() {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    public void button_click1(View view) throws IOException {
        mp.stop();
        mp.prepare();
    }


    public void button_click2(View view) throws IOException {
        mp.stop();
        mp.prepare();
        mp.start();
    }
}
