//package io.turntabl.my;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//public class Collections extends Thread{
//    public void run(){
//        try {
//            Thread.sleep(100);
//            System.out.println("Good");
//        } catch (InterruptedException e) {
//            throw new RuntimeException("Thread" + "Interrupted");
//        }
//    }
//    public static void main(String[] args){
//
//        List<Thread> threadList = Arrays.asList(
//                new Thread(() ->{
//                    while (!Thread.interrupted()) {
//                        System.out.println("Thread t1 Interrupted");}}),
//                new Thread(() ->{
//                    while (!Thread.interrupted()) {
//                        System.out.println("Thread t2 Interrupted");}}),
//                new Thread(() ->{
//                    while (!Thread.interrupted()) {
//                        System.out.println("Thread t3 Interrupted");}})
//        );
//
//        try {
//            threadList.stream().map(t -> t.interrupt()).collect(Collectors.toList());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
