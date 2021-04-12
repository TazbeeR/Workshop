package pl.firstproject.taskManager;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] tasksArr = new String[1][3];
        showMenu();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            switch (input){
                case "add" :
                    addTask(tasksArr);
                    System.out.println("tu dodasz");
                    break;
                case "remove" :

                    System.out.println("tu usuniesz");
                    break;
                case "list" :
                    listTask(tasksArr);
                    System.out.println("tu wypiszesz");
                    break;
                case "quit" :

                    System.out.println(ConsoleColors.RED + "Bye, Bye." + ConsoleColors.RESET);
                    System.exit(0);
                default:
                    System.out.println(ConsoleColors.RED_BOLD + "Use command from list" + ConsoleColors.RESET);
            }
            showMenu();
        }

    }

    private static void listTask(String[][] taskArr) {
        for (int i = 0; i < taskArr.length -1; i++) {
            for (int j = 0; j < taskArr.length +2; j++) {
                System.out.println(taskArr[i][j]);
            }

        }
    }

    private static String[][] addTask(String[][] tasksArr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add task description");
            String taskName = scanner.nextLine();
        System.out.println("Please add task due date");
            String taskDate = scanner.nextLine();
        System.out.println("Is your task important: true/false");
            String taskPriority = scanner.nextLine();
        tasksArr = Arrays.copyOf(tasksArr, tasksArr.length +1);
        tasksArr[tasksArr.length -1] = new String[3];
        tasksArr[tasksArr.length -1][0] = taskName;
        tasksArr[tasksArr.length -1][1] = taskDate;
        tasksArr[tasksArr.length -1][2] = taskPriority;
        return tasksArr;
    }

    private static void showMenu() {
        System.out.println(ConsoleColors.BLUE + "Please select an options:" + ConsoleColors.RESET);
        System.out.println("add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println("quit");
    }
    

}