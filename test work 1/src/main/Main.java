package main;

import main.controller.Controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller mainController =new Controller();
        mainController.processUser(new Scanner(System.in));
    }
}
