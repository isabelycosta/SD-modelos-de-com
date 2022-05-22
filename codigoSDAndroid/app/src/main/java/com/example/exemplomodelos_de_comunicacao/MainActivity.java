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
        tv= findViewById(R.id.textView);
        bt.setOnClickListener(view -> {
           PrecisaCalcular shc = new PrecisaCalcular(tv);
           //shc.calculoRemoto();
            //shc.calculoLocal()
            shc.calculoRemotoHTTP();

        });
    }
}
