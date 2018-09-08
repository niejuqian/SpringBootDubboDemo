package com.springboot.dubbo.demo.war.multithread;

/**
 * 多线程并发执行
 * Created by laonie on 2018/9/8.
 */
public class MuliteThreadPool<E extends Runnable> extends AbstractThreadPool<E>{

    public MuliteThreadPool() {
        super();
    }

    public MuliteThreadPool(int workNum) {
        super(workNum);
    }

    @Override
    protected Work createWork() {
        return new MuliteWork();
    }


    public class MuliteWork extends Work {

        @Override
        protected void runWork(E job) {
            try {
                job.run();
            }catch (Exception e) {

            }
        }
    }


}
