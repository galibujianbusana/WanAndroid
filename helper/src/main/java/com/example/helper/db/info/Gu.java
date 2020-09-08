package com.example.helper.db.info;

public class Gu {

    String number;
    String name;
    String time;
    String beginPrice;
    String endPrice;
    String highestPrice;
    String minimumPrice;
    String amplitude;

    public Gu() {
    }

    public Gu(String number, String name, String time, String beginPrice, String endPrice, String highestPrice, String minimumPrice, String amplitude) {
        this.number = number;
        this.name = name;
        this.time = time;
        this.beginPrice = beginPrice;
        this.endPrice = endPrice;
        this.highestPrice = highestPrice;
        this.minimumPrice = minimumPrice;
        this.amplitude = amplitude;
    }

    public String getNumber() {
        return number;
    }

    public Gu setNumber(String number) {
        this.number = number;
        return this;
    }

    public String getName() {
        return name;
    }

    public Gu setName(String name) {
        this.name = name;
        return this;
    }

    public String getTime() {
        return time;
    }

    public Gu setTime(String time) {
        this.time = time;
        return  this;
    }

    public String getBeginPrice() {
        return beginPrice;
    }

    public Gu setBeginPrice(String beginPrice) {
        this.beginPrice = beginPrice;
        return this;
    }

    public String getEndPrice() {
        return endPrice;
    }

    public Gu setEndPrice(String endPrice) {
        this.endPrice = endPrice;
        return this;
    }

    public String getHighestPrice() {
        return highestPrice;
    }

    public Gu setHighestPrice(String highestPrice) {
        this.highestPrice = highestPrice;
        return this;
    }

    public String getMinimumPrice() {
        return minimumPrice;
    }

    public Gu setMinimumPrice(String minimumPrice) {
        this.minimumPrice = minimumPrice;
        return this;
    }

    public String getAmplitude() {
        return amplitude;
    }

    public Gu setAmplitude(String amplitude) {
        this.amplitude = amplitude;
        return this;
    }
}
