public class Main {

    //A Thread executes a task

    //A Thread is a set of instructions
    //An application can be composed of several threads
    //Different threads can be executed "at the same time"
    //JVM works with several threads: JIT for example

    //Race Condition: two different threads are trying to read and write
    //the same variable at the same time. Example: Singleton
    //We can prevent two threads to execute two instances of Singleton
    //with synchronization

    //A deadlock is a situation where a thread T1, holds a key
    //needed by a thread T2,
    //and T2 holds the key needed by T1

    //Runnable Pattern was introduces in Java 1.0 - the first pattern used to launch Threads

    //Synchronization - Guarantees the exclusive execution of a block of code

    //Volatile - Essentially, volatile is used to indicate that a variable's value will be modified by different threads.
//    Declaring a volatile Java variable means:
//
//    The value of this variable will never be cached thread-locally: all reads and writes will go straight to "main memory";
//    Access to the variable acts as though it is enclosed in a synchronized block, synchronized on itself.



    public static void main(String[] args) {
        //The most basic way to create threads in
        //Java is to use the Runnable Pattern

        //First create an instance of Runnable
        //Java 7
//        Runnable runnableJava7 = new Runnable() {
//            @Override
//            public void run() {
//                String nameOfthisThread = Thread.currentThread().getName();
//                System.out.println("I'm running in thread " + nameOfthisThread);
//            }
//        };

        //Java 8
        Runnable runnableJava8 = () -> {
            //getting current thread (this is a trick :P)
            String nameOfthisThread = Thread.currentThread().getName();
            System.out.println("I'm running in thread " + nameOfthisThread);
        };
        //Then pass it to the constructor of the Thread class
        Thread thread = new Thread(runnableJava8);
        //Then call the start() method of this thread object
        thread.start();
        //thread.run(); // NO!!! this will show main thread

        //how to interrupt it ?
        //thread.interrupt(); //will throw InterruptedException
        //while(! Thread.currentThread().isInterrupted()){}

        //we can read the state of a thread with the following method:
        Thread.State state = thread.getState();
        //states: NEW, RUNNABLE, TERMINATED, BLOCKED, WAITING, TIME_WAITING
    }



}
