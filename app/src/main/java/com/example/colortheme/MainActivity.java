package com.example.colortheme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {

        Spinner lang = findViewById(R.id.spinner);
        String selectedLanguage = String.valueOf(lang.getSelectedItem());

        Spinner color = findViewById(R.id.spinner_colors);
        String selectedColor = String.valueOf(color.getSelectedItem());

        switch (selectedLanguage) {
            case "russian": {
                switchLocale("ru");
                break;
            }
            case "english": {
                switchLocale("en");
                break;
            }
            case "japanese": {
                switchLocale("ja");
                break;
            }
        }

        switch (selectedColor)
        {

            case "green":
                Utils.changeToTheme(this, Utils.THEME_GREEN);
                break;
            case "black":
                Utils.changeToTheme(this, Utils.THEME_BLACK);
                break;
            case "blue":
                Utils.changeToTheme(this, Utils.THEME_BLUE);
                break;
        }

    }
    private void switchLocale(String language) {
        Locale locale = new Locale(language);
        Configuration config = new Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        recreate();
    }
}
