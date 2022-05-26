package lenTest;

public class lt008_thread {
    public static void main(String[] args) throws InterruptedException {
        lt008_thread l = new lt008_thread();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    l.testSyncFunc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    l.testSyncFunc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread2.start();
    }

    public synchronized void testSyncFunc() throws InterruptedException {
        System.out.println("测试1");
        Thread.sleep(1000);
        System.out.println("测试2");
    }
}
