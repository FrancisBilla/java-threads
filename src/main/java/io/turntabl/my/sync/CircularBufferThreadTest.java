package io.turntabl.my.sync;

import java.util.stream.IntStream;

public class CircularBufferThreadTest {
    public static void main(String[] args) throws InterruptedException {

        CircularBuffer myBuffer = new CircularBuffer(10);

        Thread producer = new Thread(() -> IntStream.range(0, 10).forEach(t ->{
            System.out.println("Producer: " + t);
            myBuffer.insert((char) t);
            Thread.yield();
        }));

        Thread consumer = new Thread(() -> IntStream.range(0, 10).forEach(t ->{
            System.out.println("Consumer: " + t);
            Thread.yield();
        }));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

    }
}
