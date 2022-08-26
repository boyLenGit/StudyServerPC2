package lenTest;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/10 23:47
 */
public class lt018_deadLock {
    public static void main(String[] args) {
        test1();
    }

    private static Object lockObject1 = new Object();

    private static Object lockObject2 = new Object();

    public static void test1(){
        new Thread(() -> {
            synchronized (lockObject1){
                System.out.println("线程1获取锁1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockObject2){
                    System.out.println("线程1获取锁2");
                }
            }
        }, "Thread1").start();

        new Thread(() -> {
            synchronized (lockObject2){
                System.out.println("线程2获取锁1");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lockObject1){
                    System.out.println("线程2获取锁2");
                }
            }
        }, "Thread1").start();
    }
}
