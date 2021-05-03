package com.example.tp3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import com.example.tp3.R;
import com.example.tp3.interventions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ListView _lsvInterventions;
SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _lsvInterventions = (ListView) findViewById(R.id.lsvInterventions);
//*les bases des données
        db = openOrCreateDatabase("Intervention",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS INTERVENTIONS(id number primary key, titreIntervention varchar, client varchar, adressClient varchar, heureIntervention DATE);");
        _lsvInterventions = (ListView) findViewById(R.id.lsvInterventions);
        db = openOrCreateDatabase("Client",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS CLIENTS(id number primary key, titre varchar, datedebut DATE, datefin DATE, heuredebutplan DATE, heurefinplan DATE, commantaires string, dateplanification DATE );");
        db = openOrCreateDatabase("image",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS IMAGE(id number primary key, nom string, img longblob, dateducapture DATE, intervention_id number, valsync NUMBER);");
        db = openOrCreateDatabase("taches",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS TACHES(id number primary key, reference string, nom string, duree DECIMAL, dateaction DATE );");
        db=openOrCreateDatabase("sites",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS SITES(id number primary key, longitude DECIMAL, latitude DECIMAL, adresse string, rue string, codepostal integer, ville string, telcontact STRING);");
        db = openOrCreateDatabase("priorité",MODE_PRIVATE,null);
        db.execSQL("CREATE TABLE IF NOT EXISTS PRIORITE(id integer primary key, nom string, valsync INTEGER );");



        final ArrayList<interventions> interventions = new ArrayList<interventions>();
        interventions.add(new interventions("Dev Mobile","Amal Derouich","Bardo","07:00-11:00",false));
        interventions.add(new interventions("Titre Intervention 2","Client 2","Adresse Client 2","07:00-12:00",true));
$        _lsvInterventions.setIntent(adaptInterv);

    }
}