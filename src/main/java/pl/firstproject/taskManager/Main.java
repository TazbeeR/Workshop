package pl.firstproject.taskManager;

import org.apache.commons.lang3.ArrayUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {

    static final String fileName = "src/main/java/pl/firstproject/taskManager/tasks.csv";
    static String[][] tasksArr = new String[0][0];

    public static void main(String[] args) {

        loadFile();
        showMenu();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            switch (input) {
                case "add" -> addTask();
                case "remove" ->  remove();
                case "list" -> listTask();
                case "quit" -> {
                    try{
                        saveFile();
                    }catch (IOException exception){
                        System.out.println("plik brak stworzono");
                    }
                    System.out.println(ConsoleColors.RED + "Bye, Bye." + ConsoleColors.RESET);
                    System.exit(0);
                }
                default -> System.out.println(ConsoleColors.RED_BOLD + "Use command from list" + ConsoleColors.RESET);
            }
            showMenu();
        }

    }

    private static void remove() {
        System.out.println("Please select namber to remove:");
            try {//przeniesc scanner
                Scanner scanner = new Scanner(System.in);
            int index = scanner.nextInt();
            tasksArr = ArrayUtils.remove(tasksArr, index);
            } catch (IndexOutOfBoundsException | InputMismatchException exception) {
                System.out.println("Incorrect argument passed. Please give number greater or equal 0");
                remove();
            }

        System.out.println("Value is successfully deleted.");

    }

    private static void saveFile() throws IOException {
//            Path path = Paths.get(fileName);
//            boolean exists = Files.exists(path);
//            List<String> outList = new ArrayList<>();
//            if (!exists) {
//                Files.createFile(path);
//            } else {
//                outList.add("<html>\n" + "<body>");
//                while (true) {
//                    Scanner scanner = new Scanner(System.in);
//                    System.out.println("podaj tekst");
//                    String input = scanner.nextLine();
//                    if (input.equals("quit")) {
//                        break;
//                    }
//                    outList.add("<p>" + input+"</p>");
//                }
//                outList.add("</body>\n" + "</html>");
//                Files.write(path, outList);
//
//        }
    }

    private static void loadFile() {
    }

    private static void listTask() {
        for (int i = 0; i < tasksArr.length; i++) {
            System.out.print(i + " : ");
            for (int j = 0; j < tasksArr[i].length; j++) {
                System.out.print(ConsoleColors.PURPLE_BOLD + tasksArr[i][j] + ConsoleColors.RESET + " ");
                if (j == tasksArr[i].length - 1) System.out.println();
            }

        }
    }

    private static void addTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please add task description");
        String taskName = scanner.nextLine();
        System.out.println("Please add task due date");
        String taskDate = scanner.nextLine();
        System.out.println("Is your task important: true/false");
        String taskPriority = scanner.nextLine();
        tasksArr = Arrays.copyOf(tasksArr, tasksArr.length + 1);
        tasksArr[tasksArr.length - 1] = new String[3];
        tasksArr[tasksArr.length - 1][0] = taskName;
        tasksArr[tasksArr.length - 1][1] = taskDate;
        tasksArr[tasksArr.length - 1][2] = taskPriority;

    }

    private static void showMenu() {
        System.out.println(ConsoleColors.BLUE + "Please select an options:" + ConsoleColors.RESET);
        System.out.println("add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println("quit");
    }


}