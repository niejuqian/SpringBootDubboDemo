package com.springboot.dubbo.demo.war.multithread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by laonie on 2018/9/7.
 */
public class Test {
    public volatile static boolean flag = true;
    public static Object lock = new Object();

    public static int i = 0;
    public static void main(String[] args) throws InterruptedException {

        // 线程池
        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(1000,10000,10000, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
        BThread bThread = new BThread();
        Future future = executor.submit(bThread);
        executor.shutdown();*/


        /*BThread bThread = new BThread();
        AThread aThread = new AThread(new Thread(bThread,"bThread"));
        new Thread(aThread,"aThread").start();*/

        // 自定义线程池
        // 串行执行线程
        /*ThreadPool<Thread> singleThreadPool = new SingleThreadPool<>();
        for (int i1 = 0; i1 < 5; i1++) {
            singleThreadPool.executeJob(new Thread(new MyJob(i1 + 1),"MyJob" + i1));
        }

        sleepMillis(100);
        singleThreadPool.shutdown();*/

        // 多线程并发执行
        /*ThreadPool<Thread> muliteThreadPool = new MuliteThreadPool<>();
        for (int i1 = 0; i1 < 5; i1++) {
            muliteThreadPool.executeJob(new Thread(new MyJob(i1 + 1),"MyJob" + i1));
        }*/


        // 测试join方法
        /*Thread previous = Thread.currentThread();
        Thread thread1 = new Thread(new JoinRunner(previous),"1");
        Thread thread2 = new Thread(new JoinRunner(thread1),"2");
        Thread thread3 = new Thread(new JoinRunner(thread2),"3");
        thread3.start();
        thread1.start();
        thread2.start();


        *//*for (int j = 0; j < 3; j++) {
            Thread thread = new Thread(new JoinRunner(previous),"" + j);
            thread.start();
            previous = thread;
        }*//*

        System.out.println("Main is finish.");*/

        // 线程通知/等待测试
        /*WaitRunner waitRunner = new WaitRunner();
        Thread waitThread = new Thread(waitRunner,"waitThread");
        NotifyRunner notifyRunner = new NotifyRunner();
        waitRunner.setNotifyRunner(notifyRunner);
        notifyRunner.setWaitRunner(waitRunner);
        Thread notifyThread = new Thread(notifyRunner,"notifyThread");
        waitThread.start();
        notifyThread.start();*/

        // 测试线程优先级已经状态
       /* CountDownLatch latch = new CountDownLatch(2);
        Thread1 thread1 = new Thread1(latch);
        Thread2 thread2 = new Thread2(latch);
        // 设置优先级，1-10，值越大，越优先执行
        //thread2.setPriority(Thread.MAX_PRIORITY);

        System.out.println("...thread1：" + thread1.getState());
        System.out.println("...thread2：" + thread2.getState());

        thread1.start();
        thread2.start();

        System.out.println("....thread1：" + thread1.getState());
        System.out.println("....thread2：" + thread2.getState());

        latch.await();
        System.out.println("i=" + i);
        System.out.println(".....thread1：" + thread1.getState());
        System.out.println(".....thread2：" + thread2.getState());*/
    }

    public static class BThread implements Runnable{
        @Override
        public void run() {
            System.out.println("BThread" + Thread.currentThread().getName() + "," + getClass().getName());
        }
    }

    public static class AThread implements Runnable{

        private Thread bThread;
        public AThread(Thread thread) {
            this.bThread = thread;
        }

        @Override
        public void run() {
            System.out.println("AThread" + Thread.currentThread().getName() + "," + getClass().getName());
            bThread.start();
        }
    }

    public static class MyJob implements Runnable {
        private int value;
        private Random r = new Random();

        public MyJob(int value) {
            this.value = value;
        }

        @Override
        public void run() {
            int millis = r.nextInt(2000);
            sleepMillis(millis);
            System.out.println("====" + Thread.currentThread().getName() + ",vlaue=" + value + ",millis=" + millis);
        }
    }

    public static class JoinRunner implements Runnable {
        private Thread thread;

        public JoinRunner(Thread thread) {
            this.thread = thread;
        }

        @Override
        public void run() {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("JoinRunner  " + Thread.currentThread().getName() + "  is finish.");
        }
    }


    public static class WaitRunner extends Thread {
        private int index = 1;
        private NotifyRunner notifyRunner;

        public void setNotifyRunner(NotifyRunner notifyRunner) {
            this.notifyRunner = notifyRunner;
        }
        @Override
        public void run() {
            synchronized (lock) {
                while (flag) {
                    System.out.println(currentThread().getName()+ ",index=" + index + "，flag=" + flag + ",time=" + nowDateTime());
                    index++;
                    try {
                        System.out.println(currentThread().getName()+ ",this flag is true,wait......" + ",time=" + nowDateTime());
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(currentThread().getName()+ ",WaigRunner thread is finish." + ",time=" + nowDateTime());
            }
        }
    }

    public static class NotifyRunner extends Thread {
        private WaitRunner waitRunner;

        public void setWaitRunner(WaitRunner waitRunner) {
            this.waitRunner = waitRunner;
        }

        @Override
        public void run() {
            synchronized (lock) {
                System.out.println(currentThread().getName()+ ",NotifyRunner get lock,start work......" + ",time=" + nowDateTime());
                lock.notify();
                flag = false;
                printThreadState(waitRunner);
                printThreadState(currentThread());
                System.out.println(currentThread().getName()+ ",notify WaitRunner can continue......" + ",time=" + nowDateTime());
                sleepMillis(2000);
            }

            synchronized (lock) {
                sleepMillis(3000);
            }
            System.out.println(currentThread().getName()+ ",NotifyRunner thread is finish." + ",time=" + nowDateTime());
        }
    }


    public static class Thread1 extends Thread {
        private CountDownLatch latch;

        public Thread1(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            i ++;
            System.out.println("1------------i=" + i);
            // 主动让出执行时间，等待cpu下一次分配
            System.out.println("......thread1：" + Thread.currentThread().getState());
            Thread.yield();
            System.out.println("......thread1：" + Thread.currentThread().getState());
            --i;
            System.out.println("1**************i=" + i);
            latch.countDown();
        }
    }

    public static class Thread2 extends Thread {
        private CountDownLatch latch;

        public Thread2(CountDownLatch latch) {
            this.latch = latch;
        }
        @Override
        public void run() {
            ++i;
            System.out.println("2………………………………………………………………i=" + i);
            latch.countDown();
        }
    }

    public static String nowDateTime(){
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static void printThreadState(Thread thread) {
        System.out.println(thread.getName() + " state：" + thread.getState());
    }

    public static void sleepMillis(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
