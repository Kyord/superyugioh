package com.android.caio.superyugioh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class EscolhaActivity extends AppCompatActivity {
    private Button btn_maior;
    private Button btn_menor;
    private String choice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_escolha);

        btn_maior = (Button) findViewById(R.id.btn_maior);
        btn_menor = (Button) findViewById(R.id.btn_menor);
        Bundle bundle = getIntent().getExtras();

        choice = bundle.getString("choice");

        btn_maior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), JogadaActivity.class);
                ir.putExtra("choice",choice);
                ir.putExtra("choice2","maior");
                startActivity(ir);
            }
        });

        btn_menor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ir = new Intent(getBaseContext(), JogadaActivity.class);
                ir.putExtra("choice",choice);
                ir.putExtra("choice2","menor");
                startActivity(ir);
            }
        });

    }
}
