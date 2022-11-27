package com.example.marathon; // Votre package

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class InformationsActivity extends ListActivity {
    private JeuDataSource datasource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informations); //Votre layout où est votre ListView
        datasource = new JeuDataSource(this);
        datasource.open();
        List<Jeu> values = datasource.getAllJeu();

        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();


        for(int compteur=0; compteur<values.size();compteur++){
            HashMap<String,String> temp = new HashMap<String,String>();
            temp.put("id",Long.toString(values.get(compteur).getId()));
            temp.put("Joueur1",values.get(compteur).getJOUEUR1());
            temp.put("Joueur2",values.get(compteur).getJOUEUR2());
            temp.put("Score", Integer.toString(values.get(compteur).getSCORE()));
            temp.put("Temps", values.get(compteur).getTEMPS());
            temp.put("Date", values.get(compteur).getDATE());
            //vos variables

            list.add(temp);
        }

        setContentView(R.layout.activity_informations);
        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                R.layout.listview_personnalisee, // Nom du fichier de votre ListView personnalisée
                new String[] {"Joueur1", "Joueur2", "Nombre de lancé", "Temps", "Date"}, // à compléter avec vos autres variables
                new int[] {R.id.joueur1, R.id.joueur2, R.id.nbr_lance, R.id.temps, R.id.date} // à compléter avec les ID vos TextView qui afficheront les valeurs

        );

        setListAdapter(adapter);

    }
}