package com.example.marathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class JeuActivity extends AppCompatActivity {

    private JeuDataSource datasource;
    private TextView pseudo1;
    private TextView pseudo2;
    private TextView distanceJ1;
    private TextView distanceJ2;
    private Button lancer;
    private ImageView de_debut;
    private ImageView d1;
    private ImageView d2;
    private ImageView d3;
    private ImageView d4;
    private Button choix1;
    private Button choix2;
    private Button choix3;
    private Button choix4;
    private TextView parcourTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        pseudo1 = (TextView) findViewById(R.id.pseudo1);
        pseudo2 = (TextView) findViewById(R.id.pseudo2);
        distanceJ1 = (TextView) findViewById(R.id.distanceJ1);
        distanceJ2 = (TextView) findViewById(R.id.distanceJ2);
        lancer = (Button) findViewById(R.id.lancer);
        de_debut = (ImageView) findViewById(R.id.de_debut);
        d1 = (ImageView) findViewById(R.id.d1);
        d2 = (ImageView) findViewById(R.id.d2);
        d3 = (ImageView) findViewById(R.id.d3);
        d4 = (ImageView) findViewById(R.id.d4);
        choix1 = (Button) findViewById(R.id.choix1);
        choix2 = (Button) findViewById(R.id.choix2);
        choix3 = (Button) findViewById(R.id.choix3);
        choix4 = (Button) findViewById(R.id.choix4);
        parcourTextView = (TextView) findViewById(R.id.parcourTextView);


        datasource = new JeuDataSource(this);
        datasource.open();
        List<Jeu> jeux = datasource.getAllJeu();
        Jeu derniere_partie = jeux.get(jeux.size() - 1);
        String joueur1 = derniere_partie.getJOUEUR1();
        String joueur2 = derniere_partie.getJOUEUR2();
        int distanceJoueur1 = derniere_partie.getDISTANCE1();
        int distanceJoueur2 = derniere_partie.getDISTANCE2();
        int valeurParcour = 42195 ;
        pseudo1.setText("Au tour du joueur : " + joueur1);
        distanceJ1.setText("La distance qu'il te reste à parcourir est de : " + distanceJoueur1);
        distanceJ2.setText("La distance qu'il te reste à parcourir est de : " + distanceJoueur2);
        parcourTextView.setText("");
        choix1.setVisibility(View.INVISIBLE);
        choix2.setVisibility(View.INVISIBLE);
        choix3.setVisibility(View.INVISIBLE);
        choix4.setVisibility(View.INVISIBLE);

        lancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int dAleatoire1 = rand.nextInt(6 - 1 + 1) + 1;
                int dAleatoire2 = rand.nextInt(6 - 1 + 1) + 1;
                int dAleatoire3 = rand.nextInt(6 - 1 + 1) + 1;
                int dAleatoire4 = rand.nextInt(6 - 1 + 1) + 1;
                de_debut.setVisibility(View.INVISIBLE);
                choix1.setVisibility(View.VISIBLE);
                choix2.setVisibility(View.VISIBLE);
                choix3.setVisibility(View.VISIBLE);
                choix4.setVisibility(View.VISIBLE);
                parcourTextView.setVisibility(View.INVISIBLE);

                if (distanceJoueur1 >= distanceJoueur2) {
                    pseudo1.setVisibility(View.VISIBLE);
                    distanceJ1.setVisibility(View.VISIBLE);
                    pseudo2.setVisibility(View.INVISIBLE);
                    distanceJ2.setVisibility(View.INVISIBLE);
                    distanceJ1.getText().toString();
                    parcourTextView.getText().toString();
                    parcourTextView.setText(String.format("%s tu a parcouru ", joueur1, "metres"  ));
                    //int distance1 = distanceJ1;
                    //int distanceparcouru = Integer.parseInt(parcourTextView.getText().toString());
                    //distanceJ1.setText(distance1 - distanceparcouru);
                } else {
                    pseudo1.setVisibility(View.INVISIBLE);
                    distanceJ1.setVisibility(View.INVISIBLE);
                    pseudo2.setVisibility(View.VISIBLE);
                    distanceJ2.setVisibility(View.VISIBLE);
                    parcourTextView.getText().toString();
                    parcourTextView.setText(String.format("%s tu a parcouru ", joueur2, "metres"  ));

                    distanceJ2.setText(distanceJoueur2 - Integer.parseInt(parcourTextView.getText().toString()));

                }
                pseudo2.setText("Au tour du joueur : " + joueur2);

                if (distanceJoueur1 == 0 || distanceJoueur2 == 0){

                    Intent WinActivity = new Intent(JeuActivity.this, WinActivity.class);
                    startActivity(WinActivity);
                }

                switch (dAleatoire1) {

                    case 1:
                        d1.setImageResource(R.drawable.d1);
                        break;

                    case 2:
                        d1.setImageResource(R.drawable.d2);
                        break;

                    case 3:
                        d1.setImageResource(R.drawable.d3);
                        break;

                    case 4:
                        d1.setImageResource(R.drawable.d4);
                        break;

                    case 5:
                        d1.setImageResource(R.drawable.d5);
                        break;

                    case 6:
                        d1.setImageResource(R.drawable.d6);break;

                }


                switch (dAleatoire2) {

                    case 1:
                        d2.setImageResource(R.drawable.d1);
                        break;

                    case 2:
                        d2.setImageResource(R.drawable.d2);
                        break;

                    case 3:
                        d2.setImageResource(R.drawable.d3);
                        break;

                    case 4:
                        d2.setImageResource(R.drawable.d4);
                        break;

                    case 5:
                        d2.setImageResource(R.drawable.d5);
                        break;

                    case 6:
                        d2.setImageResource(R.drawable.d6);
                        break;
                }


                switch (dAleatoire3) {

                    case 1:
                        d3.setImageResource(R.drawable.d1);
                        break;

                    case 2:
                        d3.setImageResource(R.drawable.d2);
                        break;

                    case 3:
                        d3.setImageResource(R.drawable.d3);
                        break;

                    case 4:
                        d3.setImageResource(R.drawable.d4);
                        break;

                    case 5:
                        d3.setImageResource(R.drawable.d5);
                        break;

                    case 6:
                        d3.setImageResource(R.drawable.d6);
                        break;
                }


                switch (dAleatoire4) {

                    case 1:
                        d4.setImageResource(R.drawable.d1);
                        break;

                    case 2:
                        d4.setImageResource(R.drawable.d2);
                        break;

                    case 3:
                        d4.setImageResource(R.drawable.d3);
                        break;

                    case 4:
                        d4.setImageResource(R.drawable.d4);
                        break;

                    case 5:
                        d4.setImageResource(R.drawable.d5);
                        break;

                    case 6:
                        d4.setImageResource(R.drawable.d6);
                        break;


                }

                choix1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        parcourTextView.setVisibility(View.VISIBLE);
                        String distanceparc = parcourTextView.getText().toString();
                        String valeurParcour = distanceparc + dAleatoire1;
                        parcourTextView.setText(valeurParcour);
                        choix1.setVisibility(View.INVISIBLE);
                    }
                });
                choix2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        parcourTextView.setVisibility(View.VISIBLE);
                        String distanceparc = parcourTextView.getText().toString();
                        String valeurParcour = distanceparc + dAleatoire2;
                        parcourTextView.setText(valeurParcour);
                        choix2.setVisibility(View.INVISIBLE);
                    }
                });
                choix3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        parcourTextView.setVisibility(View.VISIBLE);
                        String distanceparc = parcourTextView.getText().toString();
                        String valeurParcour = distanceparc + dAleatoire3;
                        parcourTextView.setText(valeurParcour);
                        choix3.setVisibility(View.INVISIBLE);
                    }
                });
                choix4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        parcourTextView.setVisibility(View.VISIBLE);
                        String distanceparc = parcourTextView.getText().toString();
                        String valeurParcour = distanceparc + dAleatoire4;
                        parcourTextView.setText(valeurParcour);
                        choix4.setVisibility(View.INVISIBLE);
                    }
                });

            }
        });
    }

}