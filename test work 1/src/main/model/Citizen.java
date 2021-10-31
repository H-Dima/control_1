package main.model;

public class Citizen {
    private final String surname;
    private final String name;
    private final String passportID;
    private final String registrationNumber;
    private final int year;
    private int pollingStationNumber;
    private boolean military;
    private boolean quarantine;
    private String nameParty;
    private String votingResult;

    public Citizen(String surname,
                   String name,
                   String passportID,
                   String registrationNumber,
                   int year,
                   int pollingStationNumber,
                   boolean military,
                   boolean quarantine,
                   String nameParty) {
        this.surname = surname;
        this.name = name;
        this.passportID = passportID;
        this.registrationNumber = registrationNumber;
        this.year = year;
        this.pollingStationNumber = pollingStationNumber;
        this.military = military;
        if (military) {
            this.pollingStationNumber = 1;
        }
        this.quarantine = quarantine;
        if (quarantine) {
            this.pollingStationNumber = 2;
        }
        this.nameParty = nameParty;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPassportID() {
        return passportID;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public int getYear() {
        return year;
    }

    public int getPollingStationNumber() {
        return pollingStationNumber;
    }

    public void setPollingStationNumber(int pollingStationNumber) {
        this.pollingStationNumber = pollingStationNumber;
    }

    public boolean isMilitary() {
        return military;
    }

    public void setMilitary(boolean military) {
        this.military = military;
    }

    public boolean isQuarantine() {
        return quarantine;
    }

    public void setQuarantine(boolean quarantine) {
        this.quarantine = quarantine;
    }

    public String getNameParty() {
        return nameParty;
    }

    public void setNameParty(String nameParty) {
        this.nameParty = nameParty;
    }

    public String getVotingResult() {
        return votingResult;
    }

    public void setVotingResult(String votingResult) {
        this.votingResult = votingResult;
    }

    @Override
    public String toString() {
        return "{Фамилия и имя: " + surname + " " + name + ", " +
               "РНУКПН: " + registrationNumber + ", " +
               "Избирательный участок №" + pollingStationNumber+", " +
               "Партийность: "+nameParty +"}\n";
    }
}
