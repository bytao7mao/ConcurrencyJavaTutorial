import classes.LongWrapper;

/**
 * Created by taoLen on 8/3/2018.
 */
public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {
        LongWrapper longWrapper = new LongWrapper(0L);
        Runnable runnable = () -> {
          for (int i = 0; i<1_000;i++){
              longWrapper.incrementValue();
          }
        };
//        Thread thread = new Thread(runnable);
//        thread.start();
//        //just to be sure that the next thread will wait until
//        //this thread will finish executing we use join() method
//        thread.join();

        Thread[] threads = new Thread[1_000];
        for (int i = 0; i < threads.length; i++){
            threads[i] = new Thread(runnable);
            threads[i].start();
        }
        for (int i = 0; i < threads.length; i++){
            threads[i].join();
        }

        System.out.println("Value = " + longWrapper.getValue());
    }
}
