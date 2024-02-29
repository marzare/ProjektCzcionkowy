package com.example.projektczcionka;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tekstTextView;
    private SeekBar suwakRozmiaruCzcionki;
    private Button przyciskZmianyTekstu;
    private String[] teksty = {"Dzień dobry", "Good morning", "Buenos dias"};
    private int aktualnyTekst = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tekstTextView = findViewById(R.id.tekstTextView);
        suwakRozmiaruCzcionki = findViewById(R.id.suwakRozmiaruCzcionki);
        przyciskZmianyTekstu = findViewById(R.id.przyciskZmianyTekstu);

        suwakRozmiaruCzcionki.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tekstTextView.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        przyciskZmianyTekstu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aktualnyTekst = (aktualnyTekst + 1) % teksty.length;
                tekstTextView.setText(teksty[aktualnyTekst]);
            }
        });
    }
}
