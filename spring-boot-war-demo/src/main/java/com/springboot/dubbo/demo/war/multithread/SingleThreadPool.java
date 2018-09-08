package com.springboot.dubbo.demo.war.multithread;

/**
 *  多线程串行执行
 *  <p>
 *      将当前线程设置为下一个线程的引用,并调用上一个线程的Thread.join()方法
 *  </p>
 * Created by laonie on 2018/9/8.
 */
public class SingleThreadPool<E extends Thread> extends AbstractThreadPool<E> {
    private E previous;
    public SingleThreadPool(){
        super(DEFAULT_MIN_WORK_NUM);
    }

    @Override
    protected Work createWork() {
        return new SingleWork();
    }

    @Override
    public void addWorks(int num) {
        // 不允许增加
    }

    class SingleWork extends Work {
        @Override
        protected void runWork(E job) {
            if (null != previous) {
                try {
                    previous.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            previous = job;
            job.run();
        }
    }
}
