package com.company;

import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;


//http://www.java2novice.com/java-annotations/retention-policy/

//A retention policy determines at what point annotation should be discarded.
//Java defined 3 types of retention policies through java.lang.annotation.RetentionPolicy enumeration. It has SOURCE, CLASS and RUNTIME.
//Annotation with retention policy SOURCE will be retained only with source code, and discarded during compile time.
//Annotation with retention policy CLASS will be retained till compiling the code, and discarded during runtime.
//Annotation with retention policy RUNTIME will be available to the JVM through runtime.
//The retention policy will be specified by using java built-in annotation @Retention, and we have to pass the retention policy type.
//The default retention policy type is CLASS.



//http://www.java2s.com/Tutorials/Java/Java_Language/Annotations/What_is_Java_annotation_retention_policy.htm
//Description
//A retention policy determines at what point an annotation is discarded.
//
//Level
//Java defines three such policies:SOURCE, CLASS, and RUNTIME.
//
//SOURCE is retained only in the source file and is discarded during compilation.
//CLASS is stored in the .class file during compilation. It is not available through the JVM during run time.
//RUNTIME is stored in the .class file and is available through the JVM during run time.


@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
public @interface RetentionExample {
    String name();
    String years();
}

class Retention {
    @RetentionExample(name = "Annotation Example", years = "100")
    public static void myMeth() {
        Retention retention = new Retention();
        try {
            Class retentionClass = retention.getClass();
            Method myMeth = retentionClass.getMethod("myMeth");
            RetentionExample annotation = myMeth.getAnnotation(RetentionExample.class);
            System.out.println(annotation.name() + " " + annotation.years());
        } catch (NoSuchMethodException exc) {
            System.out.println("Method Not Found.");
        }
    }
    public static void main(String args[]) {
        myMeth();
    }
}
