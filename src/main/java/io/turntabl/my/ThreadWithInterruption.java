package io.turntabl.my;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class ThreadWithInterruption {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = IntStream.range(0, 10)
                .mapToObj(t -> new Thread(() ->{
                    while (!Thread.interrupted()) {}
                        System.out.println("Thread " +t +" Interrupted");
                }))
                        .collect(Collectors.toList());

                threadList.forEach((Thread::start));

        System.out.println("Active " + Thread.activeCount());
        Random rand = new Random();
        while(Thread.activeCount() != 1) {
            Thread.sleep(100);
            threadList.get(rand.nextInt(10)).interrupt();
        }

    }
}