package Volatile;

/**
 * Created by taoLen on 8/4/2018.
 */
public class Classing {
    volatile static int index;
    static void increment(){index++;}
    static void print(){
        System.out.println(index);
    }

    public static void main(String[] args) {
        print();
        increment();
        print();
    }
}
