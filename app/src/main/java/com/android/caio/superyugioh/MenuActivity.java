package com.android.caio.superyugioh;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity{

    private Button btn_selecionar1;
    private Button btn_selecionar2;
    private TextView tv_score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_menu);

        btn_selecionar1 = (Button) findViewById(R.id.btn_selecionar1);
        btn_selecionar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent select1 = new Intent(getBaseContext(), EscolhaActivity.class);
                select1.putExtra("choice","atk");
                startActivity(select1);
            }
        });

        btn_selecionar2 = (Button) findViewById(R.id.btn_selecionar2);
        btn_selecionar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent select2 = new Intent(getBaseContext(), EscolhaActivity.class);
                select2.putExtra("choice","def");
                startActivity(select2);
            }
        });

        tv_score = (TextView) findViewById(R.id.tv_score);
        tv_score.setText(Integer.toString(Score.score));

        if (Score.score <= 0) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent go = new Intent(getBaseContext(), GameOver.class);
                    startActivity(go);
                    finish();
                }
            },1000);
        }

    }
}
