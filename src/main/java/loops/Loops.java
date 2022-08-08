package loops;

public class Loops {

    public static void main(String[] args) {

        int[] numbers = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        // Enhanced for loop
        // data type, item, collection
        for (int number : numbers) {
            System.out.println(number);
        }

        // Add while Loop Here
        int index = 0;
        while (index < numbers.length) {
            System.out.println(numbers[index]);
            index++;
        }

        // Add Do while Loop Here
        // do while loop runs the loop once first before it checks the condition.
        int counter = 0;
        do {
            // check if something is true/false
            System.out.println(numbers[counter]);
            counter++;
            break;
        } while (counter < numbers.length);

    }

}
