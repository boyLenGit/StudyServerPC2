package Thread;

public class t01_new_thread {
    public static void main(String[] args){
        Thread thread = new WelcomeThread();
        thread.start();
        System.out.println("1"+Thread.currentThread().getName());
    }
}


class WelcomeThread extends Thread{
    @Override
    public void run(){
        System.out.println("2"+Thread.currentThread().getName());
    }
}