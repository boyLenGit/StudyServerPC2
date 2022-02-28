package Thread;

public class t01_new_thread {
    public static void main(String[] args){
        Thread thread = new WelcomeThread();
    }
}


class WelcomeThread extends Thread{
    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
    }
}