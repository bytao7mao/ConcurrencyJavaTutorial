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
        String marius = "Marius";
        Student student = new Student();
        String nameForStudent = student.studentName = marius;
        String name2 = student.name = marius+"B";
        Person person = new Person();
        person.name = "Rares";
        System.out.println(student.studentName);
        System.out.println(student.name);
    }
}
