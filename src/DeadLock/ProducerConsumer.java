package DeadLock;

/**
 * Created by taoLen on 8/4/2018.
 */
public class ProducerConsumer {

    //wait() and notify() are two methods
    //from the Object class and can be invoked
    //only in a synchronized block

    private static int[] buffer;
    private static int count;
    private static Object lock = new Object();

    static class Producer {
        public void produce() throws InterruptedException {
            synchronized (lock) {
                if (isFull(buffer)) {
                    lock.wait();
                }
                buffer[count++] = 1;
                lock.notify();
            }
        }
    }
    static class Consumer {
        public void consume() throws InterruptedException {
            synchronized (lock) {
                if (isEmpty(buffer)) {
                    lock.wait();
                }
                buffer[--count] = 0;
                lock.notify();
            }
        }
    }

    static boolean isEmpty(int[] buffer){
        return count == 0;
    }
    static boolean isFull(int[] buffer){
        return count == buffer.length;
    }

    public static void main(String[] args) throws InterruptedException {
        buffer = new int[10];
        count = 0;
        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable produceTask = () -> {
            for (int i=0;i<50;i++){
                try {
                    producer.produce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Done producing");
        };
        Runnable consumeTask = () -> {
            for (int i=0;i<45;i++){
                try {
                    consumer.consume();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Done consuming");
        };

        Thread consumeThread = new Thread(consumeTask);
        Thread produceThread = new Thread(produceTask);

        consumeThread.start();
        produceThread.start();
        consumeThread.join();
        produceThread.join();

        System.out.println("Data left in the buffer: " + count);

    }
}
