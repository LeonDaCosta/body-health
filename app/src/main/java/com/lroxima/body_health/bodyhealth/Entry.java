package com.lroxima.body_health.bodyhealth;

public class Entry {

    private int date,id;
    private float weight,bodyFat,water,bone,Bmi,weightMetric;

    public static int KG = 1;
    public static int POUNDS = 2;
    public static int STONES = 3;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(float bodyFat) {
        this.bodyFat = bodyFat;
    }

    public float getWater() {
        return water;
    }

    public void setWater(float water) {
        this.water = water;
    }

    public float getBone() {
        return bone;
    }

    public void setBone(float bone) {
        this.bone = bone;
    }

    public float getBmi() {
        return Bmi;
    }

    public void setBmi(float bmi) {
        Bmi = bmi;
    }

    public float getWeightMetric() {
        return weightMetric;
    }

    public void setWeightMetric(float weightMetric) {
        this.weightMetric = weightMetric;
    }

    public int getDate() { return date; }

    public void setDate(int date) { this.date = date; }
}
