package main.controller;

import main.model.CitezenFactory;
import main.model.PoliticalPartyFactory;
import main.model.StationFactory;
import main.view.View;

import java.util.Scanner;

public class Controller {
    private final int DEFAULT_SELECTION_CODE = 0;
    private final int BOTTOM_SELECTION_VALUE = 1;
    private final int TOP_SELECTION_VALUE = 10;
    private final int ADD_STATION = 1;
    private final int ADD_CITIZEN = 2;
    private final int ADD_POLITICAL_PARTY = 3;
    private final int DEFINE_POLITICAL_PARTY = 4;
    private final int SHOW_STATIONS = 5;
    private final int SHOW_CITIZENS = 6;
    private final int SHOW_POLITICAL_PARTY = 7;
    private final int CONDUCT_ELECTIONS = 8;
    private final int SHOW_ELECTION_RESULTS = 9;
    private final int EXIT_CODE = 10;

    protected View view;
    private CitezenFactory citezenFactory;
    private PoliticalPartyFactory politicalPartyFactory;
    private StationFactory stationFactory;

    public Controller() {
        this.view = new View();
        this.citezenFactory=new CitezenFactory();
        this.politicalPartyFactory=new PoliticalPartyFactory();
        this.stationFactory=new StationFactory();
    }

    public void processUser(Scanner scanner){
        int userSelection = DEFAULT_SELECTION_CODE;
        while(userSelection!=EXIT_CODE){
            view.printBaseMenu();

            while(!scanner.hasNextInt()) {
                view.printIncorrectChoiceMessage();
                view.printBaseMenu();
                scanner.next();
            }

            userSelection = scanner.nextInt();
            if(!checkInput(userSelection)) {
                view.printIncorrectChoiceMessage();
                continue;
            }

            switch (userSelection) {
                case ADD_STATION: stationFactory.addStation();
                    break;
                case ADD_CITIZEN: citezenFactory.addCitizen();
                    break;
                case ADD_POLITICAL_PARTY: politicalPartyFactory.addPoliticalParty();
                    break;
                case DEFINE_POLITICAL_PARTY: defineTheParty();
                    break;
                case SHOW_STATIONS: showStations(stationFactory, citezenFactory);
                    break;
                case SHOW_CITIZENS: showCitizen();
                    break;
                case SHOW_POLITICAL_PARTY: ;
                    break;
                case CONDUCT_ELECTIONS:;
                break;
                case SHOW_ELECTION_RESULTS:;
                break;
            }
        }
    }

    private void defineTheParty() {
        Scanner scanner =new Scanner(System.in);
        String name, nameParty;
        showCitizen();
        System.out.println("Укажите фамилию гражданина который будет кандидатом в партию.");
        name=scanner.nextLine();
        System.out.println("Укажите название партии");
        nameParty=scanner.nextLine();
        citezenFactory.
                getCitizens().
                stream().
                filter(x->x.getSurname().equals(name)).
                peek(s->s.setNameParty(nameParty)).
                forEach(System.out::println);
    }

    private void showCitizen() {
        citezenFactory.getCitizens().forEach(System.out::println);
    }

    private void showStations(StationFactory stationFactory,CitezenFactory citezenFactory) {
        new StationController().showStations(stationFactory, citezenFactory);
    }

    private boolean checkInput(int input) {
        return input >= BOTTOM_SELECTION_VALUE && input <= TOP_SELECTION_VALUE;
    }
}
