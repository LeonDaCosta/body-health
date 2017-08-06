package com.lroxima.body_health.bodyhealth;

public class Entry {

    private int weight,bodyFat,water,bone,Bmi,weightMetric,date,id;

    public static int KG = 1;
    public static int POUNDS = 2;
    public static int STONES = 3;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(int bodyFat) {
        this.bodyFat = bodyFat;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getBone() {
        return bone;
    }

    public void setBone(int bone) {
        this.bone = bone;
    }

    public int getBmi() {
        return Bmi;
    }

    public void setBmi(int bmi) {
        Bmi = bmi;
    }

    public int getWeightMetric() {
        return weightMetric;
    }

    public void setWeightMetric(int weightMetric) {
        this.weightMetric = weightMetric;
    }

    public int getDate() { return date; }

    public void setDate(int date) { this.date = date; }
}
