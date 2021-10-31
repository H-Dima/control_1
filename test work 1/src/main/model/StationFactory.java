package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StationFactory {
    private  List <Station> stationList;
    Scanner scanner =new Scanner(System.in);

    public StationFactory(){
        this.stationList =new ArrayList<>();
        Station military= new Station(1, "г. Николаев. ул. Военная");
        Station quarantine =new Station(2,"г. Николаев. ул. Карантинная");
        stationList.add(military);
        stationList.add(quarantine);
    }

    public void addStation(){
        int numberStation=stationList.size()+1;
        String address;
        System.out.println("Укажите адрес избирательного участка.");
        address=scanner.nextLine();
        Station station=new Station(numberStation,address);
        this.stationList.add(station);
    }

    public List<Station> getStationList() {
        return stationList;
    }
}
