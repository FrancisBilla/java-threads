package io.turntabl.my;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class SynchronizeWorkBook {
    public static void main(String[] args){
        int capacity = 5;

        BlockingQueue queue = new ArrayBlockingQueue<>(capacity);

//        Producer producer = new Producer(queue);
//        Consumer consumer = new Consumer(queue);
//
//        new Thread(producer);
//        producer.start();
//        consumer.start();
    }

}
