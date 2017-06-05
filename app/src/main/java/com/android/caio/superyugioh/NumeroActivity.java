package com.android.caio.superyugioh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class NumeroActivity extends AppCompatActivity {
    private SeekBar sk_valor;
    private Button btn_jogar;
    private TextView tv_valor;
    int valor = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_valor);
        btn_jogar = (Button) findViewById(R.id.btn_jogar);
        tv_valor = (TextView) findViewById(R.id.tv_valor);
        sk_valor = (SeekBar) findViewById(R.id.sk_valor);

        Bundle bundle = getIntent().getExtras();
        final String choice = bundle.getString("choice");
        final String choice2 = bundle.getString("choice2");

        sk_valor.setMax(100);
        sk_valor.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(choice2.equals("maior"))
                    valor = (progress*200)+1000;
                else
                    valor = (progress*200);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        tv_valor.setText(String.valueOf(valor));

        btn_jogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(), JogadaActivity.class);
                i.putExtra("choice", choice);
                i.putExtra("choice2", choice2);
                i.putExtra("valor", valor);
                startActivity(i);
            }
        });
    }
}
