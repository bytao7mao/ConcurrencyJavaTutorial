/**
 * Created by taoLen on 8/3/2018.
 */

//we will use in this example Singleton pattern
public class Singleton {
    private final static Object key = new Object();
    private static Singleton instance;
    //constructor private to not be able to create type of it
    private Singleton(){}
    public static Singleton getInstance() {
        //every java object has a lock method (with a key)
        //synchronizing means protecting this method by not
        //letting other threads to run at the same time

        //if instance is not null
        //we read it and return it
        //type: non-sync read
        if (instance != null) {
            return instance;
        }

        //if instance is null
        //we create it by writing it
        //type: sync write
        synchronized (key) {
            //read operation
            if (instance == null) {
                //write operation
                instance = new Singleton();
            }
            return instance;
        }//end of sync key
    }//end of getInstance method
}//end of Singleton class
