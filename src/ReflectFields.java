import java.lang.reflect.Field;


public class ReflectFields {

    public int i = 5;

    public Integer test = 5;

    public String omghi = "der";

    public static String testStatic = "THIS IS STATIC";

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        ReflectFields t = new ReflectFields();
        for(Field f : t.getClass().getFields()) {
            System.out.println(f.getGenericType() +" -- "+f.getName() + " = " + f.get(t));
        }
    }

}
