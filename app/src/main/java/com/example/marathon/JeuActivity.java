package com.example.marathon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

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
    }
}