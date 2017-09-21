package fr.wcs.blablawild;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by sam on 19/09/17.
 */

public class SearchRequestModel implements Parcelable{

   private String villeDepart;
   private String villeDestination;
    private Date dateTrajet;


    public SearchRequestModel (String villeDepart, String villeDestination, Date dateTrajet){

        this.villeDepart = villeDepart;
        this.villeDestination = villeDestination;
        this.dateTrajet = dateTrajet;
    }

    public String getVilleDepart() {
        return villeDepart;
    }

    public String getVilleDestination() {
        return villeDestination;
    }

    public Date getDateTrajet() {
        return dateTrajet;
    }



    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(villeDepart);
        dest.writeString(villeDestination);
        dest.writeLong(dateTrajet.getTime());
    }

    public SearchRequestModel(Parcel in) {
        villeDepart = in.readString();
        villeDestination = in.readString();
        dateTrajet = new Date(in.readLong());
    }
    @Override
    public int describeContents()
    {
        return 0;
    }

    public static final Parcelable.Creator<SearchRequestModel> CREATOR = new Parcelable.Creator<SearchRequestModel>()
    {
        @Override
        public SearchRequestModel createFromParcel(Parcel source)
        {
            return new SearchRequestModel(source);
        }

        @Override
        public SearchRequestModel[] newArray(int size)
        {
            return new SearchRequestModel[size];
        }
    };


}

