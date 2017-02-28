package com.ical.test.realmlearn;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm realm = Realm.getInstance(this);

        realm.beginTransaction();

        // Create an object
        Country country1 = realm.createObject(Country.class);

        // Set its fields
        country1.setName("Norway");
        country1.setPopulation(5165800);
        country1.setCode("NO");

        realm.commitTransaction();


        // Create the object
        Country country2 = new Country();
        country2.setName("Russia");
        country2.setPopulation(146430430);
        country2.setCode("RU");

        realm.beginTransaction();
        Country copyOfCountry2 = realm.copyToRealm(country2);
        realm.commitTransaction();

        RealmResults<Country> results1 =
                realm.where(Country.class).findAll();

        for(Country c:results1) {
            Log.d("results1", c.getName());
        }

        RealmResults<Country> results2 =
                realm.where(Country.class)
                        .greaterThan("population", 100000000)
                        .findAll();

        // Sort by name, in descending order
        RealmResults<Country> results3 =
                realm.where(Country.class)
                        .findAllSorted("name", false);

    }
}
