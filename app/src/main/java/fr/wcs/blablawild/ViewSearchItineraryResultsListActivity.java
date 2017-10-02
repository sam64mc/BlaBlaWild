package fr.wcs.blablawild;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ViewSearchItineraryResultsListActivity extends AppCompatActivity {
    ListView mListViewResults;
    TripResultAdapter mResultsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_search_itinerary_results_list);

        // Affiche les paramètres de la recherche dans la barre de titre de ViewSearchItineraryResultsListActivity
       // String departure = getIntent().getStringExtra("departure");
       // String destination = getIntent().getStringExtra("destination");
        SearchRequestModel requestModel = getIntent().getExtras().getParcelable("les3");
        String departure = requestModel.getVilleDepart();
        String destination = requestModel.getVilleDestination();
        Date date = requestModel.getDateTrajet();
        setTitle(departure + " >> " + destination);

        mListViewResults = (ListView) findViewById(R.id.listeTrip);
        ArrayList<TripResultModel> results = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-hh:mm");
        Toast.makeText(this, sdf.format(date), Toast.LENGTH_SHORT).show();

        try {
            results.add(new TripResultModel("Bruce", sdf.parse("21/02/2017-15:30"), 15));
            results.add(new TripResultModel("Clark", sdf.parse("21/02/2017-16:00"), 20));
            results.add(new TripResultModel("Bary", sdf.parse("21/02/2017-16:30"), 16));
            results.add(new TripResultModel("Lex", sdf.parse("21/02/2017-17:00"), 40));
        } catch (ParseException e) {
        }
        mResultsAdapter = new TripResultAdapter(this, results);

        mListViewResults.setAdapter(mResultsAdapter);
    }


}
