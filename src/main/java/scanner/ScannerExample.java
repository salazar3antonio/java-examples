package scanner;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // TODO: 7/31/2022 does this need to catch an exception?
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
                        System.out.println("Three");
                        break;
                    case "4": {
                        System.out.println("See you later!");
                        break;
                    }
                    default:
                        System.out.println("Please enter only number 1-3");
                        // TODO: 7/31/2022 Need some way to go back to the main menu
                        main(args);
                        break;
                }
            }
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }
}