public class Main {

    //A Thread is a set of instructions
    //An application can be composed of several threads
    //Different threads can be executed "at the same time"
    //JVM works with several threads: JIT for example

    //Race Condition: two different threads are trying to read and write
    //the same variable at the same time. Example: Singleton
    //We can prevent two threads to execute two instances of Singleton
    //with synchronization





    public static void main(String[] args) {
        System.out.println("Hello World!");
    }
}
