package com.example.marathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class NouvellePartieActivity extends AppCompatActivity {

    private JeuDataSource datasource;
    private Button jouer;
    private EditText premier_joueur;
    private EditText deuxieme_joueur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouvelle_partie);

        jouer =(Button) findViewById(R.id.jouer);
        premier_joueur = (EditText) findViewById(R.id.premier_joueur);
        deuxieme_joueur = (EditText) findViewById(R.id.deuxieme_joueur);

        datasource = new JeuDataSource(this);
        datasource.open();

        jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent JouerActivity = new Intent(NouvellePartieActivity.this, JeuActivity.class);
                startActivity(JouerActivity);
                String Pseudo1 = premier_joueur.getText().toString();
                String Pseudo2 = deuxieme_joueur.getText().toString();
                deuxieme_joueur.setVisibility(View.INVISIBLE);
                datasource.createJeu(Pseudo1, Pseudo2, 42195, 42195, "0", "0");
            }
        });
    }
}