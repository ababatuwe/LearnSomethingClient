package com.example.hreeels.learnsomethingclient.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Hreeels on 2015-12-01.
 */
public class Instructor implements Parcelable {

    private String firstName;
    private String lastName;

    public Instructor(String aFirstName, String aLastName) {
        firstName = aFirstName;
        lastName = aLastName;
    }

    /**
     * Constructor to use when re-constructing object
     * from a parcel.
     *
     * @param in a parcel from which to read this object
     */
    public Instructor(Parcel in) {
        readFromParcel(in);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String aFirstName) {
        this.firstName = aFirstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String aLastName) {
        this.lastName = aLastName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Writes this object's fields into a parcel.
     * NOTE: When this parcel is read back again,
     * the field's have to be read in the SAME ORDER!
     *
     * @param dest the parcel which will hold the fields
     * @param flags any flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
    }

    /**
     * Reads the data from a parcel and sets this object's
     * fields accordingly.
     * NOTE: When this parcel is read, it has to be read in
     * the SAME ORDER as it was written into.
     *
     * @param in parcel from which to re-create object
     */
    private void readFromParcel(Parcel in) {
        this.setFirstName(in.readString());
        this.setLastName(in.readString());
    }

    /**
     * This field is needed for Android to be able to
     * create new objects, individually or as arrays.
     *
     * This also means that you can use use the default
     * constructor to create the object and use another
     * method to hyrdate it as necessary.
     *
     */
    public static final Parcelable.Creator CREATOR =
            new Parcelable.Creator() {
                public Instructor createFromParcel(Parcel in) {
                    return new Instructor(in);
                }

                public Instructor[] newArray(int size) {
                    return new Instructor[size];
                }
            };
}
