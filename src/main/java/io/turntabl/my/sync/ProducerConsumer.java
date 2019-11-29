package io.turntabl.my.sync;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.stream.IntStream;

public class ProducerConsumer {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(20);

        Thread producer = new Thread(() -> IntStream.range(0 ,20).forEach(i -> {
            queue.offer(i);
            Thread.yield();
        }));

        Thread consumer = new Thread(() -> IntStream.range(0 ,20).forEach(i -> {
            System.out.println("Consumer: "+ queue.poll());
            //queue.offer(i);
            Thread.yield();
        }));


        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }
}
