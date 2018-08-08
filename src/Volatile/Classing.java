package Volatile;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by taoLen on 8/4/2018.
 */
public class Classing {
    public volatile static int index=0;
    public static void increment(){index++;}
    public static void print(){
        System.out.println(index);
    }

    public static void main(String[] args) throws IllegalAccessException {
        print();
        increment();
        print();
        Classing classing = new Classing();
        for(Field f : classing.getClass().getFields()) {
            System.out.println(f.getGenericType() +" - "+f.getName() + " = " + f.get(classing));
        }
        System.out.println("The public methods of class are: ");
        // Getting methods of the class through the object
        // of the class by using getMethods
        Class cls = classing.getClass();
        Method[] methods = cls.getMethods();
        // Printing method names
        for (Method method:methods){
            if (method.getName().equalsIgnoreCase("wait")||
                    method.getName().equalsIgnoreCase("equals")||
                    method.getName().equalsIgnoreCase("toString")||
                    method.getName().equalsIgnoreCase("hashcode")||
                    method.getName().equalsIgnoreCase("notify")||
                    method.getName().equalsIgnoreCase("notifyall")||
                    method.getName().equalsIgnoreCase("getClass")){
                return;
            }else {
                System.out.print(method.getName()+" ");
            }
        }
    }
}
