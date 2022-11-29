package com.example.marathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button nouvelle_partie;
    private Button meilleurs_scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nouvelle_partie =(Button) findViewById(R.id.nouvelle_partie);
        meilleurs_scores =(Button) findViewById(R.id.meilleurs_scores);

        nouvelle_partie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //redirection de l'avtivity main vers l'activity nouvelle partie pour enregistrer les pseudos
                Intent NouvellePartieActivity = new Intent(MainActivity.this, NouvellePartieActivity.class);
                startActivity(NouvellePartieActivity);
            }
        });

        meilleurs_scores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //redirection de l'activity main vers l'activity meilleursScore pour visualiser les 3 meilleurs scores
                Intent MeilleursScoresActivity = new Intent(MainActivity.this, MeilleursScoresActivity.class);
                startActivity(MeilleursScoresActivity);
            }
        });

    }
}