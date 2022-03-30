package lenTest;

import java.util.HashSet;

public class lt004_synchronized {
    static int num = 0;
    public static void main(String[] args) {
        // synchronized锁
        for (int i1=0; i1<3; i1++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (lt004_synchronized.class){
                        while (num<1000){
                            num++;
                            System.out.println("Thread name:"+Thread.currentThread().getName()+", val:"+num);
                        }
                    }
                }
            });
            thread.start();
        }

    }
}
