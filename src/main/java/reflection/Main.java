package reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {

//        printAllIntMethods();
//        printStringDeprecatedMethods();
//        invokeContainsMethodOnString();

    }

    private static void printAllIntMethods() {
        Class<int[]> intClass = int[].class;

        List<Method> intMethods = Arrays.stream(intClass.getMethods()).toList();

        for (Method method : intMethods) {
            System.out.println("Int Method: " + method.getName());
        }
    }

    private static void printStringDeprecatedMethods() {
        Class<String> stringClass = String.class;

        // TODO: Can we use Reflection on CartItem?

        List<Method> stringMethods = Arrays.stream(stringClass.getMethods()).toList();

        for (Method method : stringMethods) {
            if (method.isAnnotationPresent(Deprecated.class)) {
                System.out.println("String Deprecated Method: " + method.getName());
            }
        }
    }

    private static void invokeContainsMethodOnString() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<String> stringClass = String.class;

        String hiWorld = "Hi World!";

        Method containsMethod = stringClass.getMethod("contains", CharSequence.class);

        System.out.println(containsMethod.invoke(hiWorld, "or"));

    }

}
