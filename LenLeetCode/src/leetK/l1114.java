package leetK;

public class l1114 {

}

class Foo {
    private int stat1, stat2, stat3;

    public Foo() {
        stat1=0;stat2=0;stat3=0;
    }

    public void first(Runnable printFirst) throws InterruptedException {
        stat1=1;
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (stat1==0) stat2=0;
        stat2=1;
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (stat1==0 | stat2==0) stat3=0;
        stat3=1;
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}