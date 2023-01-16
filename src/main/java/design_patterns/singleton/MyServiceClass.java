package design_patterns.singleton;

public class MyServiceClass {

//    In object-oriented programming, a singleton class is a class that can have only one object (an instance of the class) at a time

    private static final MyServiceClass instance = new MyServiceClass();

    private MyServiceClass() {}

    public static MyServiceClass getInstance() {
        return instance;
    }

    public void printHelloWorld() {
        System.out.println("Hello World from MyServiceClass!");
    }


}



