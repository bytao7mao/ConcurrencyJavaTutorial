package Volatile;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by taoLen on 8/4/2018.
 */
public class Classing {
    private volatile static int index=0;
    public static final String wait = "wait";
    private static final String equals = "equals";
    private static final String toString = "tostring";
    private static final String hashcode = "hashcode";
    private static final String notify = "notify";
    private static final String notifyall = "notifyall";
    private static final String getclass = "getclass";

    public static void increment(){
        setIndex(getIndex() + 1);
    }
    public static void print(){
        System.out.println(getIndex());
    }
    public static int getIndex() {
        return index;
    }
    public static void setIndex(int index) {
        Classing.index = index;
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
//            System.out.println(method.getName()+" ");

            //#switch version
//            switch (method.getName()){
//                case wait:
//                case equals:
//                case toString:
//                case hashcode:
//                case notify:
//                case notifyall:
//                case getclass:
//                    return;
//                default:
//                    System.out.print(method.getName()+" ");
//            }

            //#if-else version
            if (method.getName().equalsIgnoreCase(wait))
//                    method.getName().equalsIgnoreCase(equals)||
//                    method.getName().equalsIgnoreCase(toString)||
//                    method.getName().equalsIgnoreCase(hashcode)||
//                    method.getName().equalsIgnoreCase(notify)||
//                    method.getName().equalsIgnoreCase(notifyall)||
                    //method.getName().equalsIgnoreCase(getclass))
            {
                return;
            }else {
                System.out.print(method.getName()+" ");
            }
        }
    }

//    public String getWait() {
//        return wait;
//    }
//
//    public String getEquals() {
//        return equals;
//    }
//
//    public String getToString() {
//        return toString;
//    }
//
//    public String getHashcode() {
//        return hashcode;
//    }
//
//    public String getNotify() {
//        return notify;
//    }
//
//    public String getNotifyall() {
//        return notifyall;
//    }
//
//    public String getGetclass() {
//        return getclass;
//    }

    public enum Methods {
        wait{
            public String toString(){
                return "wait";
            }
        },equals{
            public String toString(){
                return "equals";
            }
        },toString,hashcode,notify,notifyall,getclass;
    }
}
