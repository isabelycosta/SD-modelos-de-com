package com.example.exemplomodelos_de_comunicacao;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button bt = findViewById(R.id.button);
        Button btsub = findViewById(R.id.button2);
        Button btmult = findViewById(R.id.button3);
        Button btdiv = findViewById(R.id.button4);

        //EditText numero1EditText= findViewById(R.id.num1);
       // EditText numero2EditText= findViewById(R.id.num2);

        tv= findViewById(R.id.textView);
        //tv2= findViewById(R.id.textView2);

        //String numero1String = numero1EditText.getText().toString();
        //String numero2String = numero2EditText.getText().toString();

        //String numero1 = Double.toString(Double.parseDouble(numero1String));
        //String numero2 = Double.toString(Double.parseDouble(numero2String));

        bt.setOnClickListener(view -> {
           PrecisaCalcular shc = new PrecisaCalcular(tv);
           //shc.calculoRemoto();
            //shc.calculoLocal()
            shc.calculoRemotoHTTPsoma();

        });

        btsub.setOnClickListener(view -> {
            PrecisaCalcular shc = new PrecisaCalcular(tv);
            shc.calculoRemotoHTTPsub();

        });

        btmult.setOnClickListener(view -> {
            PrecisaCalcular shc = new PrecisaCalcular(tv);
            shc.calculoRemotoHTTPmult();

        });

        btdiv.setOnClickListener(view -> {
            PrecisaCalcular shc = new PrecisaCalcular(tv);
            shc.calculoRemotoHTTPdiv();

        });
    }
}
