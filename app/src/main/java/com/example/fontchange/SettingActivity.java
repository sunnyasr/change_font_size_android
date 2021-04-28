package com.example.fontchange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.fontchange.preferences.FontSizePref;

public class SettingActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private FontSizePref sizePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Setting");
        sizePref = new FontSizePref(this);
        radioGroup = findViewById(R.id.radio_group);


        if (sizePref.getTextSize() == 16)
            radioButton = findViewById(R.id.radio_small);
        if (sizePref.getTextSize() == 20)
            radioButton = findViewById(R.id.radio_medium);
        if (sizePref.getTextSize() == 30)
            radioButton = findViewById(R.id.radio_large);
        radioButton.setChecked(true);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = findViewById(group.getCheckedRadioButtonId());

                if (radioButton.getText().equals("Small")) {
                    sizePref.setTextSize(Integer.parseInt(getResources().getString(R.string.small)));
                }
                if (radioButton.getText().equals("Medium")) {
                    sizePref.setTextSize(Integer.parseInt(getResources().getString(R.string.medium)));
                }
                if (radioButton.getText().equals("Large")) {
                    sizePref.setTextSize(Integer.parseInt(getResources().getString(R.string.large)));
                }

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}