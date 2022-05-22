package com.example.exemplomodelos_de_comunicacao;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = findViewById(R.id.button);
        Button btsub = findViewById(R.id.button2);
        Button btmult = findViewById(R.id.button3);
        Button btdiv = findViewById(R.id.button4);

        tv= findViewById(R.id.textView);

        bt.setOnClickListener(view -> {
           PrecisaCalcular shc = new PrecisaCalcular(tv);
           //shc.calculoRemoto();
            //shc.calculoLocal()
            shc.calculoRemotoHTTPsoma();

        });

        btsub.setOnClickListener(view -> {
            PrecisaCalcular shc = new PrecisaCalcular(tv);
            //shc.calculoRemoto();
            //shc.calculoLocal()
            shc.calculoRemotoHTTPsub();

        });
    }
}
