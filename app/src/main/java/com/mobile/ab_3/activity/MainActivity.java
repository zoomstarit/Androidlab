package com.mobile.ab_3.activity;

import static com.mobile.ab_3.util.CommonContants.MY_PREFERENCE;
import static com.mobile.ab_3.util.CommonContants.NAME;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.mobile.ab_3.R;
import com.mobile.ab_3.util.CommonContants;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.et_name);
        Button btnNext = findViewById(R.id.btn_next);

        // Load the name from SharedPreferences
        SharedPreferences preferences = getSharedPreferences(MY_PREFERENCE, Context.MODE_PRIVATE);
        String savedName = preferences.getString(NAME, "");
        etName.setText(savedName);

        btnNext.setOnClickListener(v -> {
            String name = etName.getText().toString();
            Intent intent = new Intent(MainActivity.this, NameActivity.class);
            intent.putExtra(NAME, name);
            startActivityForResult(intent, REQUEST_CODE);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Save the current name in SharedPreferences
        SharedPreferences preferences = getSharedPreferences(MY_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(NAME, etName.getText().toString());
        editor.apply();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == 0) {
                // User can edit the name again
            } else if (resultCode == 1) {
                // finishing
                finish();
            }
        }
    }
}