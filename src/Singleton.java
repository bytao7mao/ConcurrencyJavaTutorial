/**
 * Created by taoLen on 8/3/2018.
 */

//we will use in this example Singleton pattern
public class Singleton {
    private static Singleton instance;
    //constructor private to not be able to create type of it
    private Singleton(){}
    public static synchronized Singleton getInstance(){
        //every java object has a lock method (with a key)
        //synchronizing means protecting this method by not
        //letting other threads to run at the same time
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }
}
