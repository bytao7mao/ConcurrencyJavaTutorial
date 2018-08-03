/**
 * Created by taoLen on 8/3/2018.
 */
public class RunnableDemo {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("I'm running in " + Thread.currentThread().getName());
        };
        Thread thread = new Thread(runnable);
        thread.setName("Tao's Thread");
        thread.start(); // YES !
        //thread.run(); NO NO NO!!! this will show main thread
    }
}
