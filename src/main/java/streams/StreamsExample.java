package streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamsExample {


    public static void main(String[] args) {

        Map<String, Integer> foodBlogWords = new LinkedHashMap<>();
        foodBlogWords.put("chocolate", 87);
        foodBlogWords.put("recipe", 112);
        foodBlogWords.put("cheese", 98);
        foodBlogWords.put("avocado", 76);
        foodBlogWords.put("beef", 56);
        foodBlogWords.put("chicken", 75);
        foodBlogWords.put("egg", 120);

        System.out.println("Unfiltered & unsorted " + foodBlogWords);

        // Functional interface, we reference the constructor of LinkedHashMap
        // Method references can be used anywhere a lambda can be used
//        Supplier<Map<String, Integer>> supplier = LinkedHashMap::new;

        // Functional interface with a Lambda expression for our merge function - used in case of conflicts
//        BinaryOperator<Integer> mergeFunction = (Integer oldValue, Integer newValue) -> { return oldValue; };

        // Functional interface Predicate we use to filter our map
//        Predicate<Map.Entry<String, Integer>> countMoreThan100 = (Map.Entry<String, Integer> entry) -> { return entry.getValue() > 100; };

        Map<String, Integer> wordsByAlpha = foodBlogWords
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(entry -> entry.getValue() > 100)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        // Words in ascending order that were found more than 100 times
        System.out.println("Ascending order & greater than 100 " + wordsByAlpha);

    }

}
