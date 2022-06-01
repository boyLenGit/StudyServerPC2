package lenTest;

public class lt013_dead_lock {
    public static void main(String[] args) {
        Object o1=new Object();
        Object o2=new Object();
        Thread t1=new my1(o1,o2);
        Thread t2=new my2(o1,o2);
        t1.start();
        t2.start();
        Integer.parseInt("A");
    }
}

class my1 extends Thread {
    Object o1;
    Object o2;
    public my1(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }
    @Override
    public void run() {
        synchronized (o1) { //t1先占用o1的对象锁
            try {
                Thread.sleep(1000);//sleep意在保证t1锁住o1，将要锁o2时，o2已经被t2给锁住了。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o2) {
            }   //嵌套在第一个synchronized里面
        }//当这个大括号（同步代码块）执行结束时，o1的对象锁才会放开！，而此时要o2被锁住并释放（同步代码块结束）才能释放o1的锁！而o2锁被t2占用，t1无法去锁o2，那么o1也无法释放。 o1无法释放，导致t2也无法锁o1，由于t2一样采用嵌套的设计，所以 t2锁住的o2也无法被释放。
    }
}

class my2 extends Thread {
    Object o1;
    Object o2;
    public my2(Object o1, Object o2) {
        this.o1 = o1;
        this.o2 = o2;
    }
    @Override
    public void run() {
        synchronized (o2) { //T2先占o2
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o1) { //再尝试占o1
            }
        }
    }
}
