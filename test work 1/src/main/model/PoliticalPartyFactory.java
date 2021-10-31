package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PoliticalPartyFactory {
    private final List<PoliticalParty> politicalPartyList;
    Scanner scanner =new Scanner(System.in);

    public PoliticalPartyFactory(){
        politicalPartyList=new ArrayList<>();
    }

    public void addPoliticalParty() {
        String name,fraction, data;
        System.out.println("Укажите название партии.");
        name=scanner.nextLine();
        System.out.println("Укажите к какой фракции она принадлежит. (Левая, Правая или Центр)");
        fraction=scanner.nextLine();
        System.out.println("Укажите дату создания партии ");
        data=scanner.nextLine();
        PoliticalParty politicalParty=new PoliticalParty(name,fraction,data);
        this.politicalPartyList.add(politicalParty);
    }

    public List<PoliticalParty> getPoliticalPartyList() {
        return politicalPartyList;
    }
}
