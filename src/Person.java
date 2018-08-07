/**
 * Created by taoLen on 8/7/2018.
 */
public class Person {
    String name;
    Person(){}
    Person(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Aida";
        Student student = new Student();
        String name = person.getName();
        System.out.println(name);
    }
}
