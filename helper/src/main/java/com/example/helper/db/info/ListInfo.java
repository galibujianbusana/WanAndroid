package com.example.helper.db.info;

public class ListInfo {

    String name;

    String number;

    public ListInfo(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "ListInfo{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
