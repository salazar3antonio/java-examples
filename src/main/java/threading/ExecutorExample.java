package threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool = Executors.newFixedThreadPool(12);
        int maxLimit = 30;
        for (int i = 0; i < maxLimit; i++) {
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
