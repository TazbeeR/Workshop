package pl.firstproject.taskManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        showMenu();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            switch (input){
                case "add" :
                    System.out.println("tu dodasz");
                    break;
                case "remove" :
                    System.out.println("tu usuniesz");
                    break;
                case "list" :
                    System.out.println("tu wypiszesz");
                    break;
                    case "quit" :
                    System.out.println(ConsoleColors.RED + "Bye Bye" + ConsoleColors.RESET);
                    System.exit(0);
                default:
                    System.out.println(ConsoleColors.RED_BOLD + "Podaj cos z listy" + ConsoleColors.RESET);
            }
            showMenu();
        }

    }
    private static void showMenu() {
        System.out.println(ConsoleColors.BLUE + "Please select an options:" + ConsoleColors.RESET);
        System.out.println("add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println("quit");
    }

}