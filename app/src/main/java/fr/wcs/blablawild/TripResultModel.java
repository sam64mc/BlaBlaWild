package fr.wcs.blablawild;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Date;


/**
 * Created by wilder on 13/09/17.
 */

public class TripResultModel {

    private String firstName;
    private Date departure;
    private int price;

    }

    public TripResultModel (String firstName, Date departure, int price){

    this.firstName = firstName;
    this.departure = departure;
    this.price = price;



}


    public String getFirstName() {
        return firstName;
    }

    public Date getDeparture() {
        return departure;
    }

    public int getPrice() {
        return price;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setDeparture(String firstName) {
        this.firstName = firstName;
    }

    public void setPrice(String firstName) {
        this.firstName = firstName;
    }



    }





