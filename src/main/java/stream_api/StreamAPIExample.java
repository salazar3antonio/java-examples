package stream_api;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class StreamAPIExample {

    public static Map<String, Integer> foodBlogWords = new LinkedHashMap<>();

    public static void main(String[] args) {

        foodBlogWords.put("chocolate", 87);
        foodBlogWords.put("recipe", 112);
        foodBlogWords.put("cheese", 98);
        foodBlogWords.put("avocado", 76);
        foodBlogWords.put("beef", 56);
        foodBlogWords.put("chicken", 75);
        foodBlogWords.put("egg", 120);

        System.out.println("Unfiltered & unsorted words list " + foodBlogWords);

//        // Stream with functional interfaces individually declared.
        longSyntaxStream(foodBlogWords);

//        // Stream with lambdas used to make Stream more concise.
        shortSyntaxStream(foodBlogWords);

        printEvenNumsWithStream();

    }

    private static void longSyntaxStream(Map<String, Integer> wordMap) {

        // Functional interface that uses a method reference.
        // Method references can be used anywhere a lambda can be used
        Supplier<Map<String, Integer>> supplier = LinkedHashMap::new;

        // Functional interface with a Lambda expression for our merge function. Used in case of conflicts
        BinaryOperator<Integer> mergeFunction = (Integer oldValue, Integer newValue) -> { return oldValue; };

        // Functional interface we use to filter the Stream.
        Predicate<Map.Entry<String, Integer>> countMoreThan100 = (Map.Entry<String, Integer> entry) -> { return entry.getValue() > 100; };

        Map<String, Integer> allWordsSorted = wordMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(countMoreThan100)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, mergeFunction, supplier));

        // Words in natural order that were found more than 100 times
        System.out.println("Filtered & sorted words list " + allWordsSorted);

    }

    private static void shortSyntaxStream(Map<String, Integer> wordMap) {
        // Lambdas used directly in the Stream operators.
        Map<String, Integer> allWordsSorted = wordMap
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .filter(entry -> entry.getValue() > 100)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        // Words in natural order that were found more than 100 times
        System.out.println("Filtered & sorted words list " + allWordsSorted);
    }

    private static void printEvenNumsWithStream() {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> filteredList = list.stream()
                .filter( num -> num % 2 == 0)
                .collect(Collectors.toList());

        System.out.print(filteredList);

    }


}
