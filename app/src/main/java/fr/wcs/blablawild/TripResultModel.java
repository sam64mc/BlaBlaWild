package fr.wcs.blablawild;

import java.util.Date;


/**
 * Created by wilder on 13/09/17.
 */

public class TripResultModel {

    private String firstName;
    private Date departure;
    private int price;


    public TripResultModel(String firstName, Date departure, int price) {

        this.firstName = firstName;
        this.departure = departure;
        this.price = price;

    }

    public String getFirstName() {
        return this.firstName;
    }

    public Date getDeparture() {
        return this.departure;
    }

    public int getPrice() {
        return this.price;
    }

}





