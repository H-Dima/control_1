package main.controller;

import main.model.CitezenFactory;
import main.model.StationFactory;

import java.util.Scanner;
import java.util.stream.Collectors;

public class StationController extends Controller{
    private final int DEFAULT_SELECTION_CODE = 0;
    private final int BOTTOM_SELECTION_VALUE = 1;
    private final int TOP_SELECTION_VALUE = 4;
    private final int SHOW_VOTER_LIST = 1;
    private final int ADD_VOTER = 2;
    private final int REMOVE_VOTER = 3;
    private final int EXIT_CODE = 4;

    public void showStations(StationFactory stationFactory, CitezenFactory citezenFactory) {
        Scanner scanner = new Scanner(System.in);
        int number;
        stationFactory.getStationList().forEach(System.out::println);
        System.out.println("Выберите номер участка.");
        number = scanner.nextInt();
        makeAList(stationFactory, citezenFactory, number);
        int userSelection = DEFAULT_SELECTION_CODE;
        while (userSelection != EXIT_CODE) {
            view.printShowStationsMenu();

            while (!scanner.hasNextInt()) {
                view.printIncorrectChoiceMessage();
                view.printShowStationsMenu();
                scanner.next();
            }

            userSelection = scanner.nextInt();
            if (!checkInput(userSelection)) {
                view.printIncorrectChoiceMessage();
                continue;
            }

            switch (userSelection) {
                case SHOW_VOTER_LIST: showVoterList(stationFactory,  number);
                    break;
                case ADD_VOTER: addVoter(stationFactory, citezenFactory, number);
                    break;
                case REMOVE_VOTER: //;
                    break;
            }
        }
    }

    private void addVoter(StationFactory stationFactory, CitezenFactory citezenFactory, int number) {
        Scanner scanner=new Scanner(System.in);
        String name;
        System.out.println("Укажите фамилию гражданина которого нужно добавить на участок.");
        name=scanner.nextLine();
        citezenFactory.getCitizens().
                stream().
                filter(x->x.getSurname().equals(name)).
                peek(z->z.setPollingStationNumber(number));
        makeAList(stationFactory, citezenFactory, number);
    }

    private void makeAList( StationFactory stationFactory, CitezenFactory citezenFactory, int number) {
        stationFactory.getStationList().stream().
                filter(x->x.getNumberStation()==number).
                peek(x->x.setCitizenList(citezenFactory.getCitizens().
                                            stream().
                                            filter(z->z.getPollingStationNumber()==number).
                                            collect(Collectors.toList())
                                        )
                );

        /*citezenFactory.getCitizens().
                stream().
                filter(z->z.getPollingStationNumber()==number).
                forEach(System.out::println);
        */
    }

    private void showVoterList(StationFactory stationFactory, int number) {
        stationFactory.getStationList().stream().
                filter(x->x.getNumberStation()==number).
                peek(x->x.getCitizenList().forEach(System.out::println));
    }

    private boolean checkInput(int input) {
        return input >= BOTTOM_SELECTION_VALUE && input <= TOP_SELECTION_VALUE;
    }
}
