package classes;

/**
 * Created by taoLen on 8/3/2018.
 */
public class LongWrapper {
    private Object key = new Object();
    private long aLong;

    //setter
    public LongWrapper(long aLong){
        this.aLong = aLong;
    }
    //getter
    public long getValue(){
        return aLong;
    }
    public void incrementValue(){
        synchronized (key){
            aLong=aLong+1;
        }

    }
}
