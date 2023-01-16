package collections.arraylist;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListExample {

    public static void main(String[] args) {

/*
        The ArrayList class is a resizable array, which can be found in the java.util package.

        The difference between a built-in array and an ArrayList in Java, is that the size of an array cannot
        be modified (if you want to add or remove elements to/from an array, you have to create a new one).
        While elements can be added and removed from an ArrayList whenever you want.
*/

        ArrayList<Person> persons = new ArrayList<>(); // Create an ArrayList Person objects

        Person personOne = new Person("John Doe", "jdoe@hotmail.com");
        Person personTwo = new Person("Jane Smith", "jane-smith@gmail.com");
        Person personThree = new Person("Jill Scott", "jill_scott@gmail.com");

        persons.add(personOne);
        persons.add(personTwo);
        persons.add(personThree);

        printIndex1Email(persons);
        findJillInArrayList(persons);
        removeLastIndexOfArrayList(persons);
        findJillInArrayList(persons);

    }

    private static void printIndex1Email(ArrayList<Person> persons) {
        // Get Email of Person object at the 1 index of persons ArrayList
        String personAtIndex1Email = persons.get(1).getEmail();
        System.out.println(personAtIndex1Email);
    }

    private static void removeLastIndexOfArrayList(ArrayList<Person> persons) {
        persons.remove(persons.size() - 1);
        System.out.println(persons);
    }

    private static boolean findJillInArrayList(ArrayList<Person> persons) {
        for (Person person : persons) {
            if (Objects.equals(person.getName(), "Jill Scott")) {
                System.out.println("Jill was found!");
                return true;
            }
        }
        System.out.println("Jill was NOT found!");
        return false;
    }

}
