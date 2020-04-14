package controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        Scanner scanner = new Scanner(System.in);
        String check;
        do {
            controller.showMenu();
            controller.controller();
            System.out.println("Do you want continues y/n : ");
            check = scanner.nextLine();
        }while (check.equals("y"));
    }
}
