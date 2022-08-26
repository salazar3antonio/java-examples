package scanner;

import java.util.Scanner;

public class ScannerExample {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        standardSwitchWithScanner(args);
        enhancedSwitchWithScanner(args);
    }

    public static void standardSwitchWithScanner(String[] args) {
        System.out.println("Welcome to the main menu!");
        try {
            while (scanner.hasNext()) {
                String userInput = scanner.next();
                switch (userInput) {
                    case "1":
                        System.out.println("One");
                        break;
                    case "2":
                        System.out.println("Two");
                        break;
                    case "3":
                        System.out.println("See you later!");
                        scanner.close();
                        break;
                    default:
                        System.out.println("Please enter only number 1-3");
                        main(args);
                        break;
                }
            }
        } catch (Exception exception) {
            exception.getLocalizedMessage();
        }
    }

    public static void enhancedSwitchWithScanner(String[] args) {
        System.out.println("Welcome to the main menu!");
        try {
            while (scanner.hasNext()) {
                String userInput = scanner.next();
                switch (userInput) {
                    case "1" -> System.out.println("One");
                    case "2" -> System.out.println("Two");
                    case "3" -> {
                        System.out.println("See you later!");
                        scanner.close();
                    }
                    default -> {
                        System.out.println("Please enter only number 1-3");
                        main(args);
                    }
                }
            }
        } catch (Exception exception) {
            exception.getLocalizedMessage();
        }
    }

}