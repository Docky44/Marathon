package com.example.marathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NouvellePartieActivity extends AppCompatActivity {

    private Button jouer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouvelle_partie);

        jouer =(Button) findViewById(R.id.jouer);

        jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent JouerActivity = new Intent(NouvellePartieActivity.this, JeuActivity.class);
                startActivity(JouerActivity);
            }
        });
    }
}