package com.example.marathon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NouvellePartieActivity extends AppCompatActivity {

    private JeuDataSource datasource;
    private Button jouer;
    private EditText premier_joueur;
    private EditText deuxieme_joueur;
    private TextView erreurPseudo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouvelle_partie);

        jouer =(Button) findViewById(R.id.jouer);
        premier_joueur = (EditText) findViewById(R.id.premier_joueur);
        deuxieme_joueur = (EditText) findViewById(R.id.deuxieme_joueur);
        erreurPseudo = (TextView) findViewById(R.id.erreurPseudo);

        //On ouvre la BDD pour stocker les données
        datasource = new JeuDataSource(this);
        datasource.open();

        jouer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Récupére les valeurs des deux pseudos
                String Pseudo1 = premier_joueur.getText().toString();
                String Pseudo2 = deuxieme_joueur.getText().toString();

                //Si on clique sur le bouton "jouer" sans avoir renseigné tous les pseudos ça nous return un erreur
                if (Pseudo1.matches("") || Pseudo2.matches("")) {
                    erreurPseudo.setText("Il manque un pseudo");
                    erreurPseudo.setVisibility(View.VISIBLE);

                //Sinon ça nous récupére la date actuelle et initialise le temps à 0
                } else {
                    Date now = Calendar.getInstance().getTime();
                    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
                    String strDate = dateFormat.format(now);

                    Time time = new Time(0, 0, 0);
                    DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
                    String strTime = timeFormat.format(time);

                    //Permet de créer une nouvelle partie dans la BDD
                    datasource.createJeu(Pseudo1, Pseudo2, 42195, 42195, 0,0,strTime, strDate);

                    //redirection de l'activity NouvellesPartie vers l'activity Jeu pour pouvoir commencer à jouer
                    Intent JouerActivity = new Intent(NouvellePartieActivity.this, JeuActivity.class);
                    startActivity(JouerActivity);
                }

            }
        });
    }
}