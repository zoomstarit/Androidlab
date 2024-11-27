package com.mobile.ab_3.activity;

import static com.mobile.ab_3.util.CommonContants.NAME;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mobile.ab_3.R;
import com.mobile.ab_3.util.CommonContants;

public class NameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        TextView tvWelcome = findViewById(R.id.tv_welcome);
        Button btnThankYou = findViewById(R.id.btn_thank_you);
        Button btnDontCallMe = findViewById(R.id.btn_dont_call_me);

        // Get the name from Intent
        String name = getIntent().getStringExtra(NAME);
        tvWelcome.setText(getString(R.string.welcome_name, name));

        btnThankYou.setOnClickListener(v -> {
            setResult(1);
            finish();
        });

        btnDontCallMe.setOnClickListener(v -> {
            setResult(0);
            finish();
        });
    }
}