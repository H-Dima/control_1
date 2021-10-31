package main.view;

import java.util.ResourceBundle;

public class View {
    public void printBaseMenu() {
        String menu = "1.Добавить избирательный участок.\n" +
                      "2.Добавить гражданина.\n" +
                      "3.Добавить партию.\n" +
                      "4.Определить партию для гражданина.\n" +
                      "5.Показать избирательные участки.\n" +
                      "6.Показать граждан.\n"+
                      "7.Показать партии.\n" +
                      "8.Провести выборы.\n" +
                      "9.Показать результаты выборов.\n" +
                      "10.Выход из программы";
        System.out.println(menu);
    }

    public void printShowStationsMenu(){
        String menu = "1.Показать список избирателей.\n" +
                      "2.Добавить избирателя.\n" +
                      "3.Удалить избирателя.\n" +
                      "4.Выход";
        System.out.println(menu);
    }

    public void printIncorrectChoiceMessage() {
        System.out.println("Номер меню некорректный");
    }
}
