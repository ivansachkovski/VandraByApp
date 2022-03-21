package com.example.vandrabyapp.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vandrabyapp.R;
import com.example.vandrabyapp.activities.main.MainActivity;
import com.example.vandrabyapp.model.database.DataModel;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button button_login = findViewById(R.id.button_login);
        button_login.setOnClickListener(v -> {
            openMainActivity();
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        DataModel dataModel = DataModel.getInstance();
        dataModel.init(); // todo::move it to splash activity

        // openMainActivity();
    }

    private void openMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }
}