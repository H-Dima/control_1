package main.model;

import java.util.ArrayList;
import java.util.List;

public class PoliticalParty {
    private final String name;
    private final String fraction;
    private final String data;
    private List<Citizen> listOfCitizens;

    public PoliticalParty(String name,
                          String fraction,
                          String data) {
        this.name = name;
        this.fraction = fraction;
        this.data = data;
        this.listOfCitizens = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getFraction() {
        return fraction;
    }

    public String getData() {
        return data;
    }

    public List<Citizen> getListOfCitizens() {
        return listOfCitizens;
    }

    public void setListOfCitizens(List<Citizen> listOfCitizens) {
        this.listOfCitizens = listOfCitizens;
    }
}
