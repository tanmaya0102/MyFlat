package com.tanmaya.myflat;

public class Details {
    public String name;
    public String number;

    public Details(String name, String number) {
        this.name=name;
        this.number=number;
    }


    public void setName(String name) {
        this.name =name;
    }
    public void setNumber(String number) {
        this.number =number;
    }
    public String getName() {
        return name;
    }
    public String getNumber() {
        return number;
    }
}
