package Worker;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by taoLen on 8/4/2018.
 */
public class Worker extends Thread {
    private volatile boolean quittingTime = false;

    @Override
    public void run() {
        while (!quittingTime){

        }
    }
    private void working(){
        try{
            Thread.sleep(300);
        }catch (InterruptedException e){}
    }
    synchronized void quit() throws InterruptedException{
        quittingTime =true;
        join();
    }
    synchronized void keepWorking(){quittingTime=false;}

    public static void main(String[] args) throws InterruptedException {
        final Worker worker = new Worker();
        worker.start();

        Timer t = new Timer(true);
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                worker.keepWorking();
            }
        },500);
        Thread.sleep(400);
        worker.quit();
    }
}
