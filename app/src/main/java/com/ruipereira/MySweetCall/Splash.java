package com.ruipereira.MySweetCall;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.ruipereira.mysweetcall.R;

public class Splash extends AppCompatActivity {
    Intent i_pino;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                i_pino = new Intent(Splash.this , Pin.class) ;
                startActivity(i_pino);
            }
        },4000); //Mostra imagem durante 4 Segundos e depois vai para o activity do pino
    }
}