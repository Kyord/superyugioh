package com.android.caio.superyugioh;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private static int TEMPO = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Score.score = 300;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ir = new Intent(getBaseContext(), MenuActivity.class);
                startActivity(ir);
                finish();
            }
        },TEMPO);
    }
}
