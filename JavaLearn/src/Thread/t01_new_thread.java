package Thread;

public class t01_new_thread {
    public static void main(String[] args){
        Thread thread1 = new WelcomeThread();
        thread1.start();
        System.out.println("1"+Thread.currentThread().getName());

        // 方法二
        Thread thread2 = new Thread(new WelcomeRunnable());
        thread2.start();
        System.out.println(Thread.currentThread().getName());

        // 方法三
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("方法三 new Runnable:"+Thread.currentThread().getName());
                // TODO
            }
        });
        thread3.start();
        System.out.println("4"+Thread.currentThread().getName());
    }
}

class WelcomeThread extends Thread{
    @Override
    public void run(){
        System.out.println("方法一 Thread:"+Thread.currentThread().getName());
        // TODO
    }
}

class WelcomeRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println("方法二 Runnable:"+Thread.currentThread().getName());
        // TODO
    }
}