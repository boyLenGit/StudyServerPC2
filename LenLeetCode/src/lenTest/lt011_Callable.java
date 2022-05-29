package lenTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class lt011_Callable {
    static class ChildCallable implements Callable<String> {
        private String str1 = "当前线程为";

        @Override
        public String call() throws Exception {
            return str1 + this.getClass();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ChildCallable childCallable1 = new ChildCallable();
        ChildCallable childCallable2 = new ChildCallable();
        FutureTask<String> futureTask1 = new FutureTask<>(childCallable1);
        FutureTask<String> futureTask2 = new FutureTask<>(childCallable2);
        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        // 获取结果
        System.out.println(futureTask1.get());
        System.out.println(futureTask2.get());
    }
}
