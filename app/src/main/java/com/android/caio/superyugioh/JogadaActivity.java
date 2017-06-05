package com.android.caio.superyugioh;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class JogadaActivity extends AppCompatActivity {
    private TextView tv_char_choice;
    private TextView tv_enemy_power;
    private TextView char_choice1;
    private TextView tv_choice;
    private ImageView iv_enemy;

    private static int TEMPO = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_jogada);

        tv_char_choice = (TextView) findViewById(R.id.tv_char_choice);
        tv_enemy_power = (TextView) findViewById(R.id.tv_enemy_power);
        char_choice1 = (TextView) findViewById(R.id.char_choice1);
        tv_choice = (TextView) findViewById(R.id.tv_choice);
        iv_enemy = (ImageView) findViewById(R.id.iv_enemy);

        Intent i = getIntent();
        Bundle valorbd = i.getExtras();
        String choice = (String) valorbd.get("choice");
        String choice2 = (String) valorbd.get("choice2");
        int valor = (Integer) valorbd.get("valor");

        char_choice1.setText(choice.toUpperCase());
        tv_choice.setText(choice2.toUpperCase());
        tv_char_choice.setText(String.valueOf(valor));
        int enemy_valor = 0;
        int personagemComputador = (int) (Math.random()*5)+1;

        if(personagemComputador == 1){
            iv_enemy.setImageResource(R.drawable.dzombie);
            if(choice.equals("atk")){
                enemy_valor = 1600;
            }else if(choice.equals("def")){
                enemy_valor = 0;
            }
        }else if(personagemComputador == 2){
            iv_enemy.setImageResource(R.drawable.kuriboh);
            if(choice.equals("atk")){
                enemy_valor = 300;
            }else if(choice.equals("def")){
                enemy_valor = 200;
            }
        }else if(personagemComputador == 3) {
            iv_enemy.setImageResource(R.drawable.labirinth);
            if(choice.equals("atk")){
                enemy_valor = 0;
            }else if(choice.equals("def")){
                enemy_valor = 3000;
            }
        }else if(personagemComputador == 4) {
            iv_enemy.setImageResource(R.drawable.necro);
            if(choice.equals("atk")){
                enemy_valor = 2200;
            }else if(choice.equals("def")){
                enemy_valor = 2800;
            }
        }else if(personagemComputador == 5) {
            iv_enemy.setImageResource(R.drawable.bewd);
            if(choice.equals("atk")){
                enemy_valor = 3000;
            }else if(choice.equals("def")){
                enemy_valor = 2500;
            }
        }

        tv_enemy_power.setText(Integer.toString(enemy_valor));

        if(choice2.equals("maior")) {
            if (enemy_valor == valor) {
                Toast.makeText(getBaseContext(),
                        "EMPATE", Toast.LENGTH_LONG).show();
            } else if (enemy_valor > valor) {
                Toast.makeText(getBaseContext(),
                        "JOGADOR GANHOU", Toast.LENGTH_LONG).show();
                Score.score += 500;
            } else if (enemy_valor < valor) {
                Toast.makeText(getBaseContext(),
                        "JOGADOR PERDEU", Toast.LENGTH_LONG).show();
                Score.score -= 200;
            }
        }else if(choice2.equals("menor")) {
            if (enemy_valor == valor) {
                Toast.makeText(getBaseContext(),
                        "EMPATE", Toast.LENGTH_LONG).show();
            } else if (enemy_valor < valor) {
                Toast.makeText(getBaseContext(),
                        "JOGADOR GANHOU", Toast.LENGTH_LONG).show();
                Score.score += 500;
            } else if (enemy_valor > valor) {
                Toast.makeText(getBaseContext(),
                        "JOGADOR PERDEU", Toast.LENGTH_LONG).show();
                Score.score -= 200;
            }
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(getBaseContext(), MenuActivity.class);
                startActivity(i);
                finish();
            }
        },TEMPO);

    }
}
