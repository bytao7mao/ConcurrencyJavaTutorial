/**
 * Created by taoLen on 8/7/2018.
 */
public class Student extends Person{
    String studentName;

    @Override
    public String toString() {
        return this.getName();
    }
    void getNameFromSuperClass(String personName){
        super.name = personName;
    }
    void getNameFromThisClass(String studentName){
        this.studentName = studentName;
    }


}
