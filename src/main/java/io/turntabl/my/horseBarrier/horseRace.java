package io.turntabl.my.horseBarrier;

import io.turntabl.execution.barriers.BarrierWorker;

import java.util.concurrent.CyclicBarrier;
import java.util.stream.IntStream;

public class horseRace {
    public static void main(String[] args){
        int horses = 5;

        CyclicBarrier b = new CyclicBarrier(horses,
                ()-> System.out.println("\n ********************* \n"));

        IntStream.range(0, horses).forEach(i->
                new horseRaceBarrier(i, b).start()
        );
    }
}
