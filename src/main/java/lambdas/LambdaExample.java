package lambdas;

import java.util.function.BiFunction;

public class LambdaExample {

    public static void main(String[] args) {

        // BiFunction is a functional interface. We can use a lambda expression to return a String value
        BiFunction<String, String, String> addMyWords = (String firstWord, String secondWord) -> firstWord + " " + secondWord;

        // BiFunction.apply(obj, obj) is the functional method of BiFunction

    }

}
