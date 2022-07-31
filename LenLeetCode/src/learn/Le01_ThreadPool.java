package learn;

import java.util.concurrent.*;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/7/27 00:04
 */
public class Le01_ThreadPool {
    public static void main(String[] args) {
        testSimple();
    }

    // 最简单的线程池
    public static void testSimple() {
        /*
         *   int corePoolSize,      // 线程池长期维持的线程数，即使线程处于Idle状态，也不会回收。
         *   int maximumPoolSize,   // 线程数的上限
         *   long keepAliveTime,    // 超过corePoolSize的线程的idle时长，
         *   TimeUnit unit,         // 超过这个时间，多余的线程会被回收。
         *   BlockingQueue<Runnable> workQueue, // 任务的排队队列
         *   ThreadFactory threadFactory,       // 新线程的产生方式
         *   RejectedExecutionHandler handler   // 拒绝策略
         */
        ExecutorService executorService = new ThreadPoolExecutor(3, 5, 1L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        for (int i1 = 0; i1 < 5; i1++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程号:" + Thread.currentThread().getName());
                }
            });
        }
    }
}
