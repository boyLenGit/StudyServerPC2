package lenTest;

public class lt010_Runnable_Thread {

    static class ChildRunnable implements Runnable{
        private int cnt = 0;
        @Override
        public void run() {
            while (cnt<3){
                System.out.println(cnt++);
            }
        }
    }

    static class ChildThread extends Thread{
        private int cnt = 0;
        @Override
        public void run() {
            while (cnt<3){
                System.out.println(cnt++);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 多个线程运行同一个Runnable
        ChildRunnable childRunnable = new ChildRunnable();
        new Thread(childRunnable).start();
        Thread.sleep(100);
        new Thread(childRunnable).start();
        Thread.sleep(100);
        new Thread(childRunnable).start();

        // 多个线程运行Runnable
        Thread.sleep(1000);
        System.out.println("多个newRunnable类");
        new Thread(new ChildRunnable()).start();
        Thread.sleep(100);
        new Thread(new ChildRunnable()).start();
        Thread.sleep(100);
        new Thread(new ChildRunnable()).start();

        // 多个线程Thread运行
        Thread.sleep(1000);
        System.out.println("多个线程Thread运行");
        new ChildThread().start();
        Thread.sleep(100);
        new ChildThread().start();
        Thread.sleep(100);
        new ChildThread().start();
    }
}
