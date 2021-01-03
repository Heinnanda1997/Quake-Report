package com.example.quakereport;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        ArrayList<Earthquake> earthquakes = QueryUtils.extractEarthquakes();

//        ArrayList<Earthquake> earthquakes = new ArrayList<>();
//        earthquakes.add(new Earthquake("7.2", "San Francisco", "Feb 2, 2016"));
//        earthquakes.add(new Earthquake("6.1", "London", "July 20, 2015"));
//        earthquakes.add(new Earthquake("3.9", "Tokyo", "Nov 10, 2014"));
//        earthquakes.add(new Earthquake("5.4", "Mexico City", "May 3, 2014"));
//        earthquakes.add(new Earthquake("2.8", "Moscow", "Jan 31, 2013"));
//        earthquakes.add(new Earthquake("4.9", "Rio de Janeiro", "Aug 19, 2012"));
//        earthquakes.add(new Earthquake("1.6", "Paris", "Oct 30, 2011"));

      //create earthquake adapter that takes list of earthquakes as input
       EarthquakeAdapter adapter = new EarthquakeAdapter(this,earthquakes);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        ListView earthquakeListView = (ListView) findViewById(R.id.list);
    //So the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);

        earthquakeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current earthquake that was clicked on
                Earthquake currentEarthquake = adapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
                Uri earthquakeUri = Uri.parse(currentEarthquake.getUrl());
                // Create a new intent to view the earthquake URI
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, earthquakeUri);

                // Send the intent to launch a new activity
                startActivity(websiteIntent);
            }
        });
    }
}