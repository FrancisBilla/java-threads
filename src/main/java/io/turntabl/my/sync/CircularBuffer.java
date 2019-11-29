package io.turntabl.my.sync;

public class CircularBuffer {
    private final Object lock = new Object();
    private int front = 0;
    private int rear = 0;
    private volatile int bufferLength = 0;
    private volatile char[]  buffer;
    private int maxSize;

    //CONSTRUCTORS
    public CircularBuffer(int maxSize){
        this.maxSize=maxSize;
        front = rear = 0;
        bufferLength = 0;
        buffer = new char[maxSize];
    }

    //FUNCTION TO GET THE SIZE OF THE BUFFER
    public int getSize(){
        return bufferLength;
    }

    //FUNCTION TO CHECK IF BUFFER IS EMPTY
    public boolean isEmpty(){
        return bufferLength == 0;
    }

    //FUNCTION TO CHECK IF BUFFER IS FULL
    public boolean isFull(){
        return bufferLength == maxSize;
    }

    //FUNCTION TO INSERT AN ELEMENT
    public void insert(char i){
        synchronized (lock) {
            if (!isFull()) {
                bufferLength++;
                rear = (rear + 1) % maxSize;
                buffer[rear] = i;
                lock.notifyAll();
            } else
                System.out.println("Error: Underflow Exception");
        }
    }

    //FUNCTION TO DELETE AN ELEMENT
    public char delete() {
        synchronized (lock) {
            if (!isEmpty()) {
                bufferLength--;
                front = (front + 1) % maxSize;
                lock.notifyAll();
                return buffer[front];

            } else {
                System.out.println("Error: Underflow Exception");
                lock.notifyAll();
                return ' ';
            }
        }
    }

    //FUNCTION TO CLEAR BUFFER
    public void clear(){
        front = rear = 0;
        rear = 0;
        bufferLength = 0;
        buffer = new char[maxSize];
    }

    public void display(){
        synchronized (lock){
            System.out.println("\n Buffer: ");
            for(int i =0; i < maxSize; i++){
                System.out.println(buffer[i] + " ");
                System.out.println();
            }
        }
    }


}
