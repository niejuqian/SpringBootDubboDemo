package com.springboot.dubbo.demo.war.multithread;

/**
 * Created by laonie on 2018/9/8.
 */
public interface ThreadPool<E extends Runnable> {
    /**
     * 执行job
     * @param job
     */
    void executeJob(E job);

    /**
     * 关闭线程池
     */
    void shutdown();

    /**
     * 增加工作者
     * @param num
     */
    void addWorks(int num);

    /**
     * 删除工作者
     * @param num
     */
    void removeWorks(int num);

    /**
     * 查看等待执行的job数量
     * @return
     */
    int getJobSize();

}
