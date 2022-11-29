package com.example.marathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class JeuActivity extends AppCompatActivity {

    private JeuDataSource datasource;
    private TextView pseudo1;
    private TextView pseudo2;
    private TextView distanceJ1;
    private TextView distanceJ2;
    private Button lancer;
    private Button valider;
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
    private TextView win;
    private Button menu;
    private TextView scoreJ1;
    private TextView scoreJ2;
    private LinearLayout distanceListLayout;
    private LinearLayout scoreListLayout;
    private LinearLayout parcourListLayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeu);

        pseudo1 = (TextView) findViewById(R.id.pseudo1);
        pseudo2 = (TextView) findViewById(R.id.pseudo2);
        distanceJ1 = (TextView) findViewById(R.id.distanceJ1);
        distanceJ2 = (TextView) findViewById(R.id.distanceJ2);
        lancer = (Button) findViewById(R.id.lancer);
        valider = (Button) findViewById(R.id.valider);
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
        win = (TextView) findViewById(R.id.win);
        menu = (Button) findViewById(R.id.menu);
        scoreJ1 = (TextView) findViewById(R.id.scoreJ1);
        scoreJ2 = (TextView) findViewById(R.id.scoreJ2);
        distanceListLayout = (LinearLayout) findViewById(R.id.distanceListLayout);
        scoreListLayout = (LinearLayout) findViewById(R.id.scoreListLayout);
        parcourListLayout = (LinearLayout) findViewById(R.id.parcourListLayout);


        datasource = new JeuDataSource(this);
        datasource.open();
        List<Jeu> jeux = datasource.getAllJeu();
        Jeu derniere_partie = jeux.get(jeux.size() - 1);
        String joueur1 = derniere_partie.getJOUEUR1();
        String joueur2 = derniere_partie.getJOUEUR2();
        int distanceJoueur1 = derniere_partie.getDISTANCE1();
        int distanceJoueur2 = derniere_partie.getDISTANCE2();
        int scoreJoueur1 = derniere_partie.getSCORE1();
        int scoreJoueur2 = derniere_partie.getSCORE2();
        String date = derniere_partie.getDATE();
        String tempsJeu = derniere_partie.getTEMPS();
        pseudo1.setText("Au tour du joueur : " + joueur1);
        scoreJ1.setText(Integer.toString(scoreJoueur1) );
        scoreJ2.setText(Integer.toString(scoreJoueur2) );

        if (scoreJoueur1 == scoreJoueur2) {
            pseudo1.setVisibility(View.VISIBLE);
            scoreJ2.setVisibility(View.INVISIBLE);
            scoreJ2.setWidth(0);
            distanceJ1.setVisibility(View.VISIBLE);
            pseudo2.setVisibility(View.INVISIBLE);
            distanceJ2.setVisibility(View.INVISIBLE);
            distanceJ2.setWidth(0);
            parcourTextView.getText().toString();
            parcourTextView.setText("");
            scoreJ1.setText(Integer.toString(scoreJoueur1 + 1) );

        } else {
            pseudo1.setVisibility(View.INVISIBLE);
            scoreJ1.setVisibility(View.INVISIBLE);
            scoreJ1.setWidth(0);
            distanceJ1.setVisibility(View.INVISIBLE);
            distanceJ1.setWidth(0);
            pseudo2.setVisibility(View.VISIBLE);
            distanceJ2.setVisibility(View.VISIBLE);
            parcourTextView.getText().toString();
            scoreJ2.setText(Integer.toString(scoreJoueur2 + 1) );
        }
        pseudo2.setText("Au tour du joueur : " + joueur2);
        distanceJ1.setText(Integer.toString(distanceJoueur1));
        distanceJ2.setText(Integer.toString(distanceJoueur2));
        parcourTextView.setText("");
        choix1.setVisibility(View.INVISIBLE);
        choix2.setVisibility(View.INVISIBLE);
        choix3.setVisibility(View.INVISIBLE);
        choix4.setVisibility(View.INVISIBLE);
        valider.setVisibility(View.INVISIBLE);
        menu.setVisibility(View.INVISIBLE);


        if (distanceJoueur1 <= 0) {

            lancer.setVisibility(View.INVISIBLE);
            de_debut.setVisibility(View.INVISIBLE);
            pseudo1.setVisibility(View.INVISIBLE);
            pseudo2.setVisibility(View.INVISIBLE);
            distanceJ1.setVisibility(View.INVISIBLE);
            distanceJ2.setVisibility(View.INVISIBLE);
            distanceListLayout.setVisibility(View.INVISIBLE);
            scoreListLayout.setVisibility(View.INVISIBLE);
            parcourListLayout.setVisibility(View.INVISIBLE);
            menu.setVisibility(View.VISIBLE);
            scoreJ1.setVisibility(View.INVISIBLE);
            scoreJ2.setVisibility(View.INVISIBLE);
            Date derniereDate = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            try {
                Date date1 = dateFormat.parse(date);
                long diffDate = date1.getTime() - derniereDate.getTime();
                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                Time diffTime = new Time(diffDate);
                String temps = timeFormat.format(diffTime);
                derniere_partie.setTEMPS(temps);
                win.setText("Bien joué " + joueur1 + " !" + "\n tu as gagné le " + date + " \nen " + scoreJoueur1 + " coups ! \nEn " + temps);
            } catch (ParseException e) {
                e.printStackTrace();
            }


        } else if (distanceJoueur2 <= 0) {

            pseudo1.setVisibility(View.INVISIBLE);
            pseudo2.setVisibility(View.INVISIBLE);
            distanceJ1.setVisibility(View.INVISIBLE);
            distanceJ2.setVisibility(View.INVISIBLE);
            lancer.setVisibility(View.INVISIBLE);
            de_debut.setVisibility(View.INVISIBLE);
            distanceListLayout.setVisibility(View.INVISIBLE);
            scoreListLayout.setVisibility(View.INVISIBLE);
            parcourListLayout.setVisibility(View.INVISIBLE);
            menu.setVisibility(View.VISIBLE);
            scoreJ1.setVisibility(View.INVISIBLE);
            scoreJ2.setVisibility(View.INVISIBLE);
            Date derniereDate = Calendar.getInstance().getTime();
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            try {
                Date date1 = dateFormat.parse(date);
                long diffDate = date1.getTime() - derniereDate.getTime();
                DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                Time diffTime = new Time(diffDate);
                String temps = timeFormat.format(diffTime);
                derniere_partie.setTEMPS(temps);
                win.setText("Bien joué " + joueur2 + " !" + "\n tu as gagné le " + date + " \nen " + scoreJoueur2 + " coups ! \nEn " + temps);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MenuActivity = new Intent(JeuActivity.this, MainActivity.class);
                startActivity(MenuActivity);
            }
        });

        lancer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random rand = new Random();
                int dAleatoire1 = rand.nextInt(6 - 1 + 1) + 1;
                int dAleatoire2 = rand.nextInt(6 - 1 + 1) + 1;
                int dAleatoire3 = rand.nextInt(6 - 1 + 1) + 1;
                int dAleatoire4 = rand.nextInt(6 - 1 + 1) + 1;
                de_debut.setVisibility(View.INVISIBLE);
                parcourTextView.setVisibility(View.INVISIBLE);
                valider.setVisibility(View.VISIBLE);

                if (scoreJoueur1 == scoreJoueur2){

                    if (distanceJoueur1 >= 1000) {
                        choix1.setVisibility(View.VISIBLE);
                        choix2.setVisibility(View.VISIBLE);
                        choix3.setVisibility(View.VISIBLE);
                        choix4.setVisibility(View.VISIBLE);
                        d1.setVisibility(View.VISIBLE);
                        d2.setVisibility(View.VISIBLE);
                        d4.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.VISIBLE);
                    }

                    if (distanceJoueur1 < 1000) {
                        choix1.setVisibility(View.INVISIBLE);
                        choix2.setVisibility(View.VISIBLE);
                        choix3.setVisibility(View.VISIBLE);
                        choix4.setVisibility(View.VISIBLE);
                        d1.setVisibility(View.INVISIBLE);
                        d2.setVisibility(View.VISIBLE);
                        d4.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.VISIBLE);
                    }

                    if (distanceJoueur1 < 100) {
                        choix4.setVisibility(View.INVISIBLE);
                        choix1.setVisibility(View.INVISIBLE);
                        choix2.setVisibility(View.VISIBLE);
                        choix3.setVisibility(View.VISIBLE);
                        d1.setVisibility(View.INVISIBLE);
                        d4.setVisibility(View.INVISIBLE);
                        d2.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.VISIBLE);
                    }

                    if (distanceJoueur1 < 10) {
                        choix3.setVisibility(View.INVISIBLE);
                        choix4.setVisibility(View.INVISIBLE);
                        choix1.setVisibility(View.INVISIBLE);
                        choix2.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.INVISIBLE);
                        d1.setVisibility(View.INVISIBLE);
                        d4.setVisibility(View.INVISIBLE);
                        d2.setVisibility(View.VISIBLE);
                    }

                }else {
                    if (distanceJoueur2 >= 1000) {
                        choix1.setVisibility(View.VISIBLE);
                        choix2.setVisibility(View.VISIBLE);
                        choix3.setVisibility(View.VISIBLE);
                        choix4.setVisibility(View.VISIBLE);
                        d1.setVisibility(View.VISIBLE);
                        d2.setVisibility(View.VISIBLE);
                        d4.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.VISIBLE);
                    }

                    if (distanceJoueur2 < 1000) {
                        choix1.setVisibility(View.INVISIBLE);
                        choix2.setVisibility(View.VISIBLE);
                        choix3.setVisibility(View.VISIBLE);
                        choix4.setVisibility(View.VISIBLE);
                        d1.setVisibility(View.INVISIBLE);
                        d2.setVisibility(View.VISIBLE);
                        d4.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.VISIBLE);
                    }

                    if (distanceJoueur2 < 100) {
                        choix4.setVisibility(View.INVISIBLE);
                        choix1.setVisibility(View.INVISIBLE);
                        choix2.setVisibility(View.VISIBLE);
                        choix3.setVisibility(View.VISIBLE);
                        d1.setVisibility(View.INVISIBLE);
                        d4.setVisibility(View.INVISIBLE);
                        d2.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.VISIBLE);
                    }

                    if (distanceJoueur2 < 10) {
                        choix3.setVisibility(View.INVISIBLE);
                        choix4.setVisibility(View.INVISIBLE);
                        choix1.setVisibility(View.INVISIBLE);
                        choix2.setVisibility(View.VISIBLE);
                        d3.setVisibility(View.INVISIBLE);
                        d1.setVisibility(View.INVISIBLE);
                        d4.setVisibility(View.INVISIBLE);
                        d2.setVisibility(View.VISIBLE);
                    }
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
                        d1.setImageResource(R.drawable.d6);
                        break;

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
                        parcourTextView.setText(distanceparc + dAleatoire1);
                        if (distanceJoueur1 >= distanceJoueur2) {
                            distanceJ1.setText(Integer.toString(distanceJoueur1 - Integer.parseInt(parcourTextView.getText().toString())));

                        } else {
                            distanceJ2.setText(Integer.toString(distanceJoueur2 - Integer.parseInt(parcourTextView.getText().toString())));
                        }
                        choix1.setVisibility(View.INVISIBLE);
                    }
                });
                choix2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        parcourTextView.setVisibility(View.VISIBLE);
                        String distanceparc = parcourTextView.getText().toString();
                        parcourTextView.setText(distanceparc + dAleatoire2);
                        if (distanceJoueur1 >= distanceJoueur2) {
                            distanceJ1.setText(Integer.toString(distanceJoueur1 - Integer.parseInt(parcourTextView.getText().toString())));

                        } else {
                            distanceJ2.setText(Integer.toString(distanceJoueur2 - Integer.parseInt(parcourTextView.getText().toString())));
                        }

                        choix2.setVisibility(View.INVISIBLE);
                    }
                });
                choix3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        parcourTextView.setVisibility(View.VISIBLE);
                        String distanceparc = parcourTextView.getText().toString();
                        parcourTextView.setText(distanceparc + dAleatoire3);
                        if (distanceJoueur1 >= distanceJoueur2) {
                            distanceJ1.setText(Integer.toString(distanceJoueur1 - Integer.parseInt(parcourTextView.getText().toString())));

                        } else {
                            distanceJ2.setText(Integer.toString(distanceJoueur2 - Integer.parseInt(parcourTextView.getText().toString())));
                        }
                        choix3.setVisibility(View.INVISIBLE);
                    }
                });
                choix4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        parcourTextView.setVisibility(View.VISIBLE);
                        String distanceparc = parcourTextView.getText().toString();
                        parcourTextView.setText(distanceparc + dAleatoire4);
                        if (distanceJoueur1 >= distanceJoueur2) {
                            distanceJ1.setText(Integer.toString(distanceJoueur1 - Integer.parseInt(parcourTextView.getText().toString())));

                        } else {
                            distanceJ2.setText(Integer.toString(distanceJoueur2 - Integer.parseInt(parcourTextView.getText().toString())));
                        }
                        choix4.setVisibility(View.INVISIBLE);

                    }
                });

                valider.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        lancer.setVisibility(View.VISIBLE);
                        valider.setVisibility(View.INVISIBLE);
                        datasource.open();
                        datasource.updateJeu(derniere_partie.getId(), derniere_partie.getJOUEUR1(), derniere_partie.getJOUEUR2(), Integer.parseInt(distanceJ1.getText().toString()), Integer.parseInt(distanceJ2.getText().toString()), Integer.parseInt(scoreJ1.getText().toString()), Integer.parseInt(scoreJ2.getText().toString()), derniere_partie.getTEMPS(), derniere_partie.getDATE());
                        datasource.close();
                        finish();
                        overridePendingTransition(0, 0);
                        startActivity(getIntent());
                    }
                });
            }
        });
    }
}