package com.example.czcionki;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView sizeLabel;
    private TextView quoteText;
    private SeekBar seekBar;
    private Button changeQuoteButton;

    private String[] quotes = {"Dzień dobry", "Good morning", "Buenos dias"};
    private int currentQuoteIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sizeLabel = findViewById(R.id.sizeLabel);
        quoteText = findViewById(R.id.quoteText);
        seekBar = findViewById(R.id.seekBar);
        changeQuoteButton = findViewById(R.id.changeQuoteButton);

        updateFontSize(seekBar.getProgress());

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sizeLabel.setText("Rozmiar: " + progress);
                updateFontSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

        changeQuoteButton.setOnClickListener(v -> {
            currentQuoteIndex = (currentQuoteIndex + 1) % quotes.length;
            quoteText.setText(quotes[currentQuoteIndex]);
        });
    }

    private void updateFontSize(int size) {
        quoteText.setTextSize(size);
    }
}