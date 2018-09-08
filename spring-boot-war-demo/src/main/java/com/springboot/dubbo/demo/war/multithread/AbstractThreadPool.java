package com.springboot.dubbo.demo.war.multithread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by laonie on 2018/9/8.
 */
public abstract class AbstractThreadPool<E extends Runnable> implements ThreadPool<E>{

    protected static final int DEFAULT_MAX_WORK_NUM = 10;
    protected static final int DEFAULT_MIN_WORK_NUM = 1;
    protected static final int DEFAULT_NORMAL_WORK_NUM = 5;

    private int workNum = DEFAULT_NORMAL_WORK_NUM;
    private AtomicLong atomicLong = new AtomicLong();

    /**
     * 执行工作队列
     */
    private final LinkedList<E> jobs = new LinkedList<>();

    private final List<Work> works = Collections.synchronizedList(new ArrayList<>());

    public AbstractThreadPool(){
        this(DEFAULT_NORMAL_WORK_NUM);
    }

    public AbstractThreadPool(int workNum) {
        this.workNum = (workNum > DEFAULT_MAX_WORK_NUM ? DEFAULT_MAX_WORK_NUM : workNum < DEFAULT_MIN_WORK_NUM ? DEFAULT_MIN_WORK_NUM : workNum);
        initialWorks(this.workNum);
    }

    private void initialWorks(int workNum){
        for (int i = 0; i < workNum; i++) {
            Work work = createWork();
            works.add(work);
            Thread thread = new Thread(work,"work" + atomicLong.incrementAndGet());
            thread.start();
        }
    }

    protected abstract Work createWork();


    @Override
    public void executeJob(E job) {
        if (null != job) {
            synchronized (jobs) {
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for (Work work : works) {
            work.shutdown();
        }
    }

    @Override
    public void addWorks(int num) {
        synchronized (jobs) {
            if (num + this.workNum > DEFAULT_MAX_WORK_NUM) {
                num = DEFAULT_MAX_WORK_NUM - this.workNum;
            }
            if (num > 0) {
                initialWorks(num);
                this.workNum += num;
            }
        }
    }

    @Override
    public void removeWorks(int num) {
        synchronized (jobs) {
            if (num > this.workNum) {
                throw new IllegalArgumentException("beyond workNum");
            }
            int count = 0;
            while (count < num) {
                Work work = works.get(count);
                if (works.remove(work)) {
                    work.shutdown();
                    count ++;
                }

            }
            this.workNum-=count;
        }
    }

    @Override
    public int getJobSize() {
        return jobs.size();
    }

    public abstract class Work implements Runnable {

        private boolean running = true;

        @Override
        public void run() {
            while (running) {
                E job = null;
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    job = jobs.removeFirst();
                }
                if (null != job) {
                    runWork(job);
                }
            }
            System.out.println("ThreadPool shutdown.");
        }

        protected abstract void runWork(E job);

        public void shutdown(){
            running = false;
        }

    }
}
