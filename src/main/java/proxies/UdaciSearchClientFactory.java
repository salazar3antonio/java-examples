package proxies;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME;

public final class UdaciSearchClientFactory {

    public static UdaciSearchClient fromPropertyMap(Map<String, Object> properties) {
        Object dynamicProxy =
                Proxy.newProxyInstance(
                        UdaciSearchClientFactory.class.getClassLoader(),
                        new Class<?>[]{UdaciSearchClient.class},
                        new Handler(properties));
        return (UdaciSearchClient) dynamicProxy;
    }

    private UdaciSearchClientFactory() {
        // UdacisearchClientFactory cannot be instantiated.
    }

    private static final class Handler implements InvocationHandler {

        private final Map<String, Object> properties;

        private Handler(Map<String, Object> properties) {
            this.properties = new HashMap<>(Objects.requireNonNull(properties));
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            String methodName = method.getName();
            if (method.getDeclaringClass().equals(Object.class)) {
                // Invoke toString() and hashCode() directly on the property Map.
                try {
                    return method.invoke(properties, args);
                } catch (InvocationTargetException e) {
                    throw e.getTargetException();
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }

            if (methodName.length() <= 3 || !methodName.startsWith("get")) {
                throw new RuntimeException("Method is not a property getter: " + methodName);
            }

            String propertyName = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
            if (!properties.containsKey(propertyName)) {
                throw new RuntimeException("No property named \"" + propertyName + "\" found in map.");
            }

            if (method.isAnnotationPresent(Tracker.class)) {
                System.out.println(propertyName + "_tracking" + " propertyValue: " + properties.get(propertyName) );

                Path path = Path.of("src/main/java/proxies/logging.txt");
                File profileFile = new File(path.toUri());
                FileWriter fileWriter = new FileWriter(profileFile, true);

                try (BufferedWriter writer = new BufferedWriter(fileWriter)) {
                    writer.write(System.lineSeparator());
                    writer.write("Run at " + Calendar.getInstance().getTime() + ": ");
                    writer.write(propertyName + ": " + properties.get(propertyName));
                    writer.write(System.lineSeparator());
                }

            }

            return properties.get(propertyName);
        }
    }
}
