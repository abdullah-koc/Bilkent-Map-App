package com.grondstofapps.bilatlas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SuccessfullyArrivedActivity extends AppCompatActivity {

    private Button buttonFeedback, buttonMainMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successfully_arrived);

        buttonFeedback = findViewById(R.id.buttonFeedback);
        buttonMainMenu = findViewById(R.id.buttonMainMenu);

        buttonMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SuccessfullyArrivedActivity.this, MainActivity.class));
                finish();
            }
        });

        buttonFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.grondstofapps.bilatlas")));
            }
        });
    }
}
