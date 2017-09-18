package fr.wcs.blablawild;

import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sam on 15/09/17.
 */


public class TripResultAdapter extends BaseAdapter {
    private Context context; //context
    private ArrayList<TripResultModel> TripResultModels; //data source of the list adapter

    //public constructor
    public TripResultAdapter(Context context, ArrayList<TripResultModel> TripResultModels) {
        this.context = context;
        this.TripResultModels = TripResultModels;
    }

    @Override
    public int getCount() {
        return TripResultModels.size(); //returns total of TripResultModels in the list
    }

    @Override
    public Object getItem(int position) {
        return TripResultModels.get(position); //returns list TripResultModel at the specified position
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // inflate the layout for each list row
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.trip_item, parent, false);
        }

        // get current TripResultModel to be displayed
        TripResultModel tripItem = (TripResultModel) getItem(position);

        // get the TextView for TripResultModel name and TripResultModel description
        TextView prenom = (TextView)
                convertView.findViewById(R.id.prenomConducteur);
        TextView dateDep = (TextView)
                convertView.findViewById(R.id.dateHeure);
        TextView prix = (TextView)
                convertView.findViewById(R.id.prixTrajet);

        //sets the text for TripResultModel name and TripResultModel description from the current TripResultModel object
        prenom.setText(tripItem.getFirstName());
        dateDep.setText(tripItem.getDeparture().toString());
        prix.setText(String.valueOf(tripItem.getPrice()));

        // returns the view for the current row
        return convertView;
    }
}















