package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapsExample {

    private static final Map<String, Person> mapOfPeople = new HashMap<>();

    public static void main(String[] args) {

        Person mike = new Person("Mike", "mike@email.com");
        Person shaun = new Person("Shaun", "shaun@email.com");

        addToPersonMap(mike);
        addToPersonMap(shaun);

        for (String key : mapOfPeople.keySet()) {
            System.out.println(key);
        }

        for (Person person : mapOfPeople.values()) {
            System.out.println(person);
        }

        removePersonFromPersonMap(shaun.getEmail());

        for (String key : mapOfPeople.keySet()) {
            System.out.println("Updated: HashMap  " + key);
            System.out.println("Is Mike a customer? " + mapOfPeople.containsKey(mike.getEmail()));
            System.out.println("Is Shaun a customer? " + mapOfPeople.containsKey(shaun.getEmail()));
        }

    }

    private static void addToPersonMap(Person person) {
        // adds a Key of person's email and a Value of Person object
        mapOfPeople.put(person.getEmail(), person);
    }

    private static void removePersonFromPersonMap(String email) {
        // removes the person from the map by their email (Key)
        mapOfPeople.remove(email);
    }

}
