package threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(12);

        int number = 30;

        for (int i = 0; i < number; i++) {
            int num = i;
            pool.submit( () ->
                    // Runnable as a lambda
                    System.out.println("Thread #"
                            + Thread.currentThread().getId()
                            + " State " + Thread.currentThread().getState()
                            + " Printed " + num)
            );
        }
    }
}
