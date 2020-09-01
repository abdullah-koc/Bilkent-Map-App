package com.example.deneme333;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("plain/text");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] { "appsupport@gmail.com" });
                intent.putExtra(Intent.EXTRA_SUBJECT, "Görüş, öneri bildirimi");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(intent, ""));
            }
        });
    }
}
