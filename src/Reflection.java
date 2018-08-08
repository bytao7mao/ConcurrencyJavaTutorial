// A simple Java program to demonstrate the use of reflection
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;

// class whose object is to be created
class Reflection {
    // creating a private field
    private String string;
    // creating a public constructor
    public Reflection()  {  string = "GeeksforGeeks"; }
    // Creating a public method with no arguments
    public void method1()  {
        System.out.println("The string is " + string);
    }
    // Creating a public method with int as argument
    public void method2(int n)  {
        System.out.println("The number is " + n);
    }
    // creating a private method
    private void method3() {
        System.out.println("Private method invoked");
    }
}

class Demo {
    public static void main(String args[]) throws Exception {
        // Creating object whose property is to be checked
        Reflection obj = new Reflection();

        Field[] fields = Reflection.class.getDeclaredFields();
        //gives no of fields
        System.out.println(fields.length + " fields");
        for (Field field : fields) {
            //gives the names of the fields
            System.out.println(field.getName() + " name of field");
        }

        // Creating class object from the object using
        // getclass method
        String nameOfFoo = obj.toString();
        System.out.println(nameOfFoo);

        Class cls = obj.getClass();
        System.out.println("The name of class is " +
                cls.getSimpleName());
        // Getting the constructor of the class through the
        // object of the class
        Constructor constructor = cls.getConstructor();
        System.out.println("The name of constructor is " +
                constructor.getName());
        System.out.println("The public methods of class are : ");
        // Getting methods of the class through the object
        // of the class by using getMethods
        Method[] methods = cls.getMethods();
        // Printing method names
//        for (Method method:methods)
//            System.out.println(method.getName());
        // creates object of desired method by providing the
        // method name and parameter class as arguments to
        // the getDeclaredMethod
        Method methodcall1 = cls.getDeclaredMethod("method2",
                int.class);
        // invokes the method at runtime
        methodcall1.invoke(obj, 19);
        // creates object of the desired field by providing
        // the name of field as argument to the 
        // getDeclaredField method
        Field field = cls.getDeclaredField("string");
        // allows the object to access the field irrespective
        // of the access specifier used with the field
        field.setAccessible(true);
        // takes object and the new value to be assigned
        // to the field as arguments
        field.set(obj, "JAVA");
        // Creates object of desired method by providing the
        // method name as argument to the getDeclaredMethod
        Method methodcall2 = cls.getDeclaredMethod("method1");
        // invokes the method at runtime
        methodcall2.invoke(obj);
        // Creates object of the desired method by providing
        // the name of method as argument to the 
        // getDeclaredMethod method
        Method methodcall3 = cls.getDeclaredMethod("method3");
        // allows the object to access the method irrespective 
        // of the access specifier used with the method
        methodcall3.setAccessible(true);
        // invokes the method at runtime
        methodcall3.invoke(obj);
    }
}
