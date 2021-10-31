package main.model;

import java.util.*;

public class Station {
    private final int numberStation;
    private final String address;
    private List<Citizen> citizenList;
    private float percent;
    private int numberOfVoters;
    private Map<String, Integer> partyVoices;

    public Station(int numberStation, String address){
        this.numberStation=numberStation;
        this.address=address;
        citizenList=new ArrayList<>();
        partyVoices=new HashMap<>();
    }

    public int getNumberStation() {
        return numberStation;
    }

    public String getAddress() {
        return address;
    }

    public List<Citizen> getCitizenList() {
        return citizenList;
    }

    public void setCitizenList(List<Citizen> citizenList) {
        this.citizenList = citizenList;
    }

    public void addCitizens(Citizen citizen){
        this.citizenList.add(citizen);
    }

    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    public int getNumberOfVoters() {
        return numberOfVoters;
    }

    public void setNumberOfVoters(int numberOfVoters) {
        this.numberOfVoters = numberOfVoters;
    }

    public Map<String, Integer> getPartyVoices() {
        return partyVoices;
    }

    public void setPartyVoices(Map<String, Integer> partyVoices) {
        this.partyVoices = partyVoices;
    }

    @Override
    public String toString() {
        return "{Номер: " + numberStation + ", " +
               "Адрес: " + address + "}\n";
    }
}
