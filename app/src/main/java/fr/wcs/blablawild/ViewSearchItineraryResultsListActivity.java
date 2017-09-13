package fr.wcs.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        // Affiche les paramètres de la recherche dans la barre de titre de ViewSearchItineraryResultsListActivity

        String departure = getIntent().getStringExtra("departure");
        String destination = getIntent().getStringExtra("destination");

        setTitle(departure + " >> " + destination);

    }

}
