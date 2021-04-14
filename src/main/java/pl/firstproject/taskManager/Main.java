package pl.firstproject.taskManager;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static final String fileName = "tasks.csv";
    static String[][] tasksArr;

    public static void main(String[] args) {

        loadFile();
        showMenu();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            String input = scanner.nextLine();
            switch (input){
                case "add" :
                    addTask();
                    break;
                case "remove" :
                    remove();
                   break;
                case "list" :
                    listTask();
                   break;
                case "quit" :
                    saveFile();
                    System.out.println(ConsoleColors.RED + "Bye, Bye." + ConsoleColors.RESET);
                    System.exit(0);
                default:
                    System.out.println(ConsoleColors.RED_BOLD + "Use command from list" + ConsoleColors.RESET);
            }
            showMenu();
        }

    }

    private static void remove() {
    }

    private static void saveFile() {
    }

    private static void loadFile() {
    }

    private static void listTask() {
        for (int i = 0; i < tasksArr.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < tasksArr[i].length; j++) {
                System.out.print(ConsoleColors.GREEN_BOLD+tasksArr[i][j]+ConsoleColors.RESET + " ");
                if (j==2) System.out.println();
            }

        }
    }

    private static String[][] addTask() {
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