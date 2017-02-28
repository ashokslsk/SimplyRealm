package com.ical.test.realmlearn;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by ashok.kumar on 28/02/17.
 */

public class Country extends RealmObject {

    private String name;
    private int population;
    @PrimaryKey
    private String code;

    public Country() { }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
