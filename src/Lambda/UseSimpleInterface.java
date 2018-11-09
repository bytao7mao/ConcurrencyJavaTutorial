public class UseSimpleInterface {

    public static void main(String[] args) {
        SimpleInterface obj = () -> System.out.println("Say something");
        //run
        obj.doSomethign();

        InterfaceWithArgs obj2 = (v1, v2) -> {
            int result = v1 * v2;
            System.out.println("Result is: " + result);
        };
        //run
        obj2.doSomethingArgs(10, 5);


        Runnable r1 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("first thread");
        };
        Runnable r2 = () -> System.out.println("second thread");
        new Thread(r1).start();
        new Thread(r2).start();
    }
}
