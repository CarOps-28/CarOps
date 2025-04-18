package com.carops;

import java.io.Serializable;

public class DateTime implements Serializable {
    String dateTime;

    public DateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getDateTime() {
        return this.dateTime;
    }

    public String getDate(){
        return this.dateTime.split(" - ")[0];
    }

    public String getTime(){
        return this.dateTime.split(" - ")[1];
    }
}
