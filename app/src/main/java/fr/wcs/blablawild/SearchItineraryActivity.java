package fr.wcs.blablawild;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SearchItineraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final EditText depart = (EditText) findViewById(R.id.depart);
        final EditText destination = (EditText) findViewById(R.id.destination);


       final Button buttonSearch = (Button) findViewById(R.id.buttonSearch);
       // Implémente les cas d'erreur quand l'utilisateur a oublié de remplir des champs obligatoires dans SearchItineraryActivity.

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (depart.getText().toString().isEmpty() || destination.getText().toString().isEmpty()){
                    Toast.makeText(SearchItineraryActivity.this,"Veuillez remplir les champs",Toast.LENGTH_LONG).show();
                }else {
                    //Implémente le passage de données entre SearchItineraryActivity et ViewSearchItineraryResultsListActivity.

                    Intent intent = new Intent(SearchItineraryActivity.this,
                            ViewSearchItineraryResultsListActivity.class);
                    intent.putExtra("departure", depart.getText().toString());
                    intent.putExtra("destination", destination.getText().toString());
                    startActivity(intent);

                }

            }
        });
    }
}
