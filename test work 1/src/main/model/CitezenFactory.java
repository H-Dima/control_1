package main.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CitezenFactory {
    private final List<Citizen> citizens;
    public CitezenFactory(){
        citizens=new ArrayList<>();
    }
    public void addCitizen() {
        Scanner scanner =new Scanner(System.in);
        String surname, name, passportID, registrationNumber,nameParty;
        int year, pollingStationNumber;
        boolean military, quarantine;
        System.out.println("Введите фамилию гражданина.");
        surname=scanner.nextLine();
        System.out.println("Введите имя гражданина.");
        name=scanner.nextLine();
        System.out.println("Введите номер ID паспорта состоящий из 13 цифр.");
        passportID=checkPassportID(scanner.nextLine());
        System.out.println("Укажите год рождения гражданина в 4 значном формате.");
        year=checkYear(scanner.nextInt());
        registrationNumber=checkRegistration(year);
        System.out.println("Укажите номер избирательного участка гражданина.");
        pollingStationNumber=scanner.nextInt();
        System.out.println("Является гражданин военным, либо сотрудником спецслужб. (Да/Нет)");
        military=scanner.next().equals("Да");
        System.out.println("Находится гражданин в карантине (Да/Нет).");
        quarantine=scanner.next().equals("Да");
        nameParty=checkNameParty();
        Citizen citizen = new Citizen(
                surname,
                name,
                passportID,
                registrationNumber,
                year,
                pollingStationNumber,
                military,
                quarantine,
                nameParty);
        this.citizens.add(citizen);
    }

    private String checkNameParty() {
        Scanner scanner =new Scanner(System.in);
        System.out.println("Является гражданин кандидатом от партии? (Да/Нет)");
        if(scanner.nextLine().equals("Да")){
            System.out.println("Укажите название партии.");
            return scanner.nextLine();
        } else return "беспартиный";
    }

    private String checkRegistration(int year) {
        Scanner scanner =new Scanner(System.in);
        String number;
        System.out.println("Введите регистрационный номер учетной карточки плательщика налога (10 цифр).");
        number=scanner.nextLine();
            try {
                checkForTenDigits(number);
            } catch (registrationException e) {
                System.out.println(e);
                number=checkRegistration(year);
            }
            return number;
    }

    private int checkYear(int year) {
        Scanner scanner =new Scanner(System.in);
        while(year<1900||year>2022){
            System.out.println("Ошибка\n" +
                               "Введите год рождения гражданина в 4 значном формате.");
            year=checkYear(scanner.nextInt());
        }
        return year;
    }

    private void checkForTenDigits(String number) throws registrationException {
        if (!number.matches("\\d{10}")) {
            throw new registrationException("Ошибка, количество чисел не соответсвует 10.");
        }
    }

    private String checkPassportID(String numberPassport){
        Scanner scanner =new Scanner(System.in);
        while (!numberPassport.matches("\\d{13}")){
            System.out.println("Ошибка, в номере не 13 цифр\n" +
                               "Введите номер ID паспорта состоящий из 13 цифр).");
            numberPassport=scanner.nextLine();
        }
        return numberPassport;
    }

    public static class registrationException extends Exception {
        public registrationException (String message) {
            super(message);
        }
    }

    public List<Citizen> getCitizens(){
        return citizens;
    }
}
