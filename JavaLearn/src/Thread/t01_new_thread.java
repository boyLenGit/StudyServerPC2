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
    }
}

class WelcomeThread extends Thread{
    @Override
    public void run(){
        System.out.println("2"+Thread.currentThread().getName());
        // TODO
    }
}

class WelcomeRunnable implements Runnable{
    @Override
    public void run(){
        System.out.println();
    }
}