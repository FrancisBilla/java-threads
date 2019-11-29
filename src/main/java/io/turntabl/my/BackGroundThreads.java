package io.turntabl.my;

public class BackGroundThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->
                System.out.println("Thread t1"));

        Thread t2 = new Thread(()->
                System.out.println("Thread t2"));

        t1.start();
        t2.start();
        //t1.join();

        Thread.sleep(10);
        System.out.println("MAIN THREAD IN ACTION");

    }

}
