package len.cloud02.blog_service.service;

import len.cloud02.blog_service.utils.LenLog;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author mabl02 (mabl02@rd.netease.com)
 * @date 2022/8/24 23:20
 */
@Service
public class ThreadPoolService {
    private static ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
            5,
            8,
            10, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(5), //任务队列
            Executors.defaultThreadFactory(), //线程工厂
            new ThreadPoolExecutor.AbortPolicy()); //拒绝策略

    static {
        int core = Runtime.getRuntime().availableProcessors();
        LenLog.info2(ThreadPoolService.class, "static","正在创建线程池ThreadPoolTaskExecutor，线程池核心数量：" + core);
        threadPoolExecutor.setCorePoolSize(core);
        threadPoolExecutor.setMaximumPoolSize(core * 2);
    }

    public void execute(Runnable task){
        threadPoolExecutor.execute(task);
    }

    public int getActiveCount(){
        return threadPoolExecutor.getActiveCount();
    }

    public ThreadPoolExecutor getThreadPool(){
        return threadPoolExecutor;
    }
}
