package DeadLock;

/**
 * Created by taoLen on 8/3/2018.
 */
public class A {
    private Object key1 = new Object();
    private Object key2 = new Object();
    void a(){
        synchronized (key1) {
            System.out.println("a - Thread: " + Thread.currentThread().getName());
            b();
        }
    }
    void b(){
        synchronized (key2){
            System.out.println("b - Thread: " + Thread.currentThread().getName());
           c();
        }
    }

    //this can't be called because the key1 is blocked at method a()
    void c(){
        synchronized (key1){
            System.out.println("c- Thread: " + Thread.currentThread().getName());
        }
    }
}
