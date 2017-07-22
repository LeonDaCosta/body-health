package com.lroxima.body_health.bodyhealth;


public class entry {

    private float weight,bodyFat,water,bone,Bmi;
    private int weightMetric;

    public static int KG = 1;
    public static int POUNDS = 2;
    public static int STONES = 3;
    

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

    public int getWeightMetric() {
        return weightMetric;
    }

    public void setWeightMetric(int weightMetric) {
        this.weightMetric = weightMetric;
    }
}
