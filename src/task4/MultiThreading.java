package task4;


import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MultiThreading {
    public static int cnt = 0;

    public static void main(String[] args) {
        int array[] = new int[5000000];
        AtomicInteger atomicCnt = new AtomicInteger(); /*creating atomic variable */
        Arrays.fill(array, 3 + (int) (Math.random() * 1000));
        int serialCnt = (int) IntStream.of(array).filter(arrayElement -> arrayElement % 3 == 0).count();
        IntStream.of(array)
                .parallel()
                .filter(arrayElement -> arrayElement % 3 == 0)
                .forEach(
                        arrayElement -> {
                            /*built-in method for performing parallel calculations in Java*/
                            cnt +=
                                    1; /*finding the number of elements that are multiples of 3 without using an atomic variable*/
                            int oldValue;
                            int newValue;
                            do { // change the quantity using the compareAndSet method
                                oldValue = atomicCnt.get();
                                newValue = oldValue + 1;
                            } while (!atomicCnt.compareAndSet(oldValue, newValue));
                        });
        System.out.println("Serial count:   " + serialCnt);
        System.out.println("Blocking count: " + cnt + (" (always has a little inaccuracy)"));
        System.out.println("Atomic count:   " + atomicCnt.get());
    }
}
