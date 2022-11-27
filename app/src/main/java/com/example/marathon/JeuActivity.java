package com.example.marathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class JeuActivity extends AppCompatActivity {

    private JeuDataSource datasource;
    private TextView pseudo1;
    private TextView pseudo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        pseudo1 = (TextView) findViewById(R.id.pseudo1);
        pseudo2 = (TextView) findViewById(R.id.pseudo2);

        datasource = new JeuDataSource(this);
        datasource.open();
        List<Jeu> jeux = datasource.getAllJeu();
        Jeu derniere_partie = jeux.get(jeux.size()-1);
        String  Joueur1 = derniere_partie.getJOUEUR1();
        String Joueur2 = derniere_partie.getJOUEUR2();
        pseudo1.setText("Au tour du joueur : " + Joueur1);
        pseudo2.setText("Au tour du joueur : " + Joueur2);

    }

}