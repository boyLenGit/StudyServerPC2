package lenTest;

public class lt005_threadlocal {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{
            Test005_Threadlocal tt = new Test005_Threadlocal();
            System.out.println(tt.get());
            tt.add("01");
            System.out.println(tt.get());
        });
        thread1.start();

        Thread thread2 = new Thread(()->{
            try {
                thread1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Test005_Threadlocal tt = new Test005_Threadlocal();
            System.out.println(tt.get());
            tt.add("02");
            System.out.println(tt.get());
        });
        thread2.start();
        int[] a = new int[]{3};
    }

    static ThreadLocal<Integer> threadLocal1 = new ThreadLocal<>();
    public static void cleanThreadLocal(){
        try {
            // 业务逻辑
        }finally {
            threadLocal1.remove();
        }
    }
}

class Test005_Threadlocal{
    private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    Test005_Threadlocal(){}

    void add(String str){
        threadLocal.set(str);
    }

    String get(){
        return threadLocal.get();
    }
}