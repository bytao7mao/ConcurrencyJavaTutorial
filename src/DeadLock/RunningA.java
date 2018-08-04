package DeadLock;

/**
 * Created by taoLen on 8/3/2018.
 */
public class RunningA {
    public static void main(String[] args) throws InterruptedException {
        A aClass = new A();
        Runnable r1 = () -> aClass.a();
        Runnable r2 = () -> aClass.b();
        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r2);
        t2.start();

        t1.join();
        t2.join();
    }
}
