package io.turntabl.my.horseBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class horseRaceBarrier extends Thread{
    private CyclicBarrier barrier;

    public horseRaceBarrier(int i, CyclicBarrier barrier){
        super("horse-" + i);
        this.barrier = barrier;
    }

    @Override
    public void run(){
        try{
            System.out.println( Thread.currentThread().getName() + " moving to the starting line");
            barrier.await();
            Thread.sleep((int)(Math.random() * 10000));

            System.out.println( Thread.currentThread().getName() + " at the starting line");
            barrier.await();
            Thread.sleep((int)(Math.random() * 10000));

            System.out.println( Thread.currentThread().getName() + " ready");
            barrier.await();
            Thread.sleep((int)(Math.random() * 10000));

            System.out.println( Thread.currentThread().getName() + " finished");
            barrier.await();
        }
        catch(InterruptedException ie){}
        catch(BrokenBarrierException bbe){}
    }


}
