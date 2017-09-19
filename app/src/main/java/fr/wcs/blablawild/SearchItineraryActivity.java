package fr.wcs.blablawild;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static fr.wcs.blablawild.R.id.date;
import static fr.wcs.blablawild.R.id.depart;
import static fr.wcs.blablawild.R.id.destination;

public class SearchItineraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_itinerary);

        final EditText depart = (EditText) findViewById(R.id.depart);
        final EditText destination = (EditText) findViewById(R.id.destination);


        final Calendar myCalendar = Calendar.getInstance();
            final EditText editText = (EditText) findViewById(R.id.date);
            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

                public void updateLabel() {
                    String myFormat = "MM/dd/yy"; //In which you need put here
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                    editText.setText(sdf.format(myCalendar.getTime()));
                }


                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel();
                }

            };

             editText.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    new DatePickerDialog(SearchItineraryActivity.this, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            });



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
