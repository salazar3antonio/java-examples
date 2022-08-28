package threading;

import java.util.ArrayList;
import java.util.List;

public class IntPrinter {

    public static void main(String[] args) throws InterruptedException {

        int number = 10;

        List<Thread> threads = new ArrayList<>(number);

        for (int i = 0; i < number; i++) {
            threads.add(new Thread(new IntRunner(i)));
        }

        for (Thread thread : threads) {
            System.out.println("Thread #" + thread.getId() + " State " + thread.getState());
        }

        for (Thread thread : threads) {
            thread.start();
            System.out.println("Thread #" + thread.getId() + " State " + thread.getState());
        }

        for (Thread thread : threads) {
            thread.join();
            System.out.println("Thread #" + thread.getId() + " State " + thread.getState());
        }
    }

    private static final class IntRunner implements Runnable {

        private final int value;

        IntRunner(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            System.out.println("Thread #" + Thread.currentThread().getId() + " printed " + value);
        }
    }

}
