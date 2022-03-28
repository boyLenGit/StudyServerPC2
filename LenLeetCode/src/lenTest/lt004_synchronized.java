package lenTest;

public class lt004_synchronized {
    static int num = 0;
    public static void main(String[] args) {
        for (int i1=0; i1<3; i1++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (num<1000){
                        num++;
                        System.out.println("Thread name:"+Thread.currentThread().getName()+", val:"+num);
                    }
                }
            });
            thread.start();
        }
    }
}
