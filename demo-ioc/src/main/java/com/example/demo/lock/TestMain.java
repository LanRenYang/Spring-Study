package com.example.demo.lock;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestMain {

    // synchronized ()
    // ReentrantLock 可重入锁
    /*
        ReentrantLock提供了两种锁，他的里面有两个内部类：NonfairSync 非公平锁 和 FairSync 公平锁
        FairSync 公平锁，如果锁已被其他线程获得，会先判断是否有等待队列，如果有等待队列，那么这个线程会被放入线程等待队列，等锁被释放时，队列中的线程按顺序去获取锁
        NonfairSync 非公平锁 如果锁已被其他线程获得，不会判断是否有等待队列，直接使用compareAndSwap去进行锁的占用;
        ReentrantLock默认使用NonfairSync锁，使用ReentrantLock(boolean fair)构造方法可以选择创建锁类型。
             // 线程加锁的过程分为两步：1，获取锁；2，修改state值，是为上锁
            FairSync lock()的方法实现：
                 final void lock() {
                    // 获取锁
                    acquire(1);
                }
            NonfairSync lock()的方法实现：
                  // 直接修改state值，直接上锁
                  if (compareAndSetState(0, 1))
                    setExclusiveOwnerThread(Thread.currentThread());
                  // 上锁失败，来获取锁
                else
                    acquire(1);
     */
    /*
        acquire()解析：
        AbstractQueuedSynchronizer.acquire(){
            if (!tryAcquire(arg) &&
            acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
            selfInterrupt();
        }
        这里用到了四个方法：
       tryAcquire(); acquireQueued(); addWaiter(); selfInterrupt()
            acquireQueued(); addWaiter(); selfInterrupt()方法都使用的AbstractQueuedSynchronizer实现的方法
            tryAcquire()：尝试获取锁方法，AbstractQueuedSynchronizer的tryAcquire()是一个空方法，具体代码逻辑由子类实现：
            在FairSync的tryAcquire()中：会使用hasQueuedPredecessors()方法判断线程队列中是否由线程在等待，如果没有才使用compareAndSetState()修改state状态上锁；
            在NonFairSync的tryAcquire()中：是调用了nonfairTryAcquire(),在这个方法中NonFairSync锁，不公平的本质暴露无疑，他还是调用compareAndSetState()尝试直接上锁，不想排队。


     */
    // reentrantLock 就相当于一把锁
    static final ReentrantLock reentrantLock = new ReentrantLock();


    public static void main(String[] args) throws InterruptedException {

         /*
        Condition的await() 和 sigal() 类似于Object的wait() 和 notify(),Condition提供了更为丰富的线程等待方法，来协调线程间的通信。
        Condition对象必须要有reentrantLock获取才有效。
        */
        Condition condition = reentrantLock.newCondition();

        /*
            compareAndSetState(0, 1) 比较和设置状态。如果status值为0的话，修改state为1，修改成功返回true
         */
        try {
            // ReentrantLock中有字段：state，用于记录线程加锁计数，线程获得锁一次，state加1一次，当state == 0时，表示没有线程持有锁，其他线程可以来获取这个锁。
            System.out.println("获取当前线程加锁计数：——>" + reentrantLock.getHoldCount());// 获取当前线程加锁计数
            reentrantLock.lock();   //  线程加锁一次，每加锁一次，state就加1一次
            System.out.println("获取当前线程加锁计数：——>" + reentrantLock.getHoldCount());// 获取当前线程加锁计数
            reentrantLock.lock();   //  线程获得锁一次
            System.out.println("获取当前线程加锁计数：——>" + reentrantLock.getHoldCount());// 获取当前线程加锁计数
//        reentrantLock.unlock();  // 当前线程释放锁一次，state-1
//        System.out.println("获取当前线程加锁计数：——>" + reentrantLock.getHoldCount());// 获取当前线程加锁计数

            System.out.println("锁是否被当前线程持有：——>" + reentrantLock.isHeldByCurrentThread());         //  锁是否被当前线程持有
            System.out.println("当前有多少个线程在等待获取锁：——>" + reentrantLock.getQueueLength());//获取等待获取这个锁的线程个数
            System.out.println("是否有线程在等待获取锁：——>" + reentrantLock.hasQueuedThreads()); // 是否有其他线程等待获取这个锁
            System.out.println("锁类型是公平锁吗：——>" + reentrantLock.isFair()); // 判断锁类型是否是公平锁
            System.out.println("尝试获取锁,获取到了吗：——>" + reentrantLock.tryLock());  // 尝试获取锁,获取成功返回teue
            System.out.println("在指定时间内尝试获取锁,获取到了吗：——>" + reentrantLock.tryLock(10, TimeUnit.SECONDS));// 尝试获取锁，如果没有立即获取到，等待指定时间。获取成功返回true

            System.out.println("获取当前线程加锁计数：——>" + reentrantLock.getHoldCount());// 获取保持计数
            System.out.println("当前线程是否持有锁：——>" + reentrantLock.isHeldByCurrentThread());         //  当前线程是否持有锁

//            boolean hasWaiters = reentrantLock.hasWaiters();
//            int waitQueueLength = reentrantLock.getWaitQueueLength();


            /*
                线程阻塞 与 线程等待有什么区别？
                    阻塞：线程已经启动，在因为在临界区等待获取锁而阻塞，因为为了保证线程安全，对共享数据线程需要先获取锁，才能继续执行。
                    等待：线程已经获取锁，但是需要等待其他线程执行某些操作，wait() park()都是释放锁，让线程处于等待状态。线程等待的前提是线程拥有锁资源。
             */
            condition.await();  // 释放锁，进入等待状态，直到被signal()唤醒
            long awaitNanos = condition.awaitNanos(1000);// 线程等待指定纳米时间
            boolean awaitUntil = condition.awaitUntil(new Date());// 线程等到直到指定时间
            boolean await = condition.await(10, TimeUnit.SECONDS);// 线程等待指定时间
            condition.awaitUninterruptibly();
            condition.signal();  // 唤醒，被唤醒的线程不是直接获取锁，而是参与重新竞争
            condition.signalAll(); // 唤醒全部


            System.out.println("锁是否被锁定：--->" + reentrantLock.isLocked());// 判断锁是否被锁定 实质上就是 判断 state字段是否为0

            reentrantLock.lockInterruptibly(); //

            System.out.println("指定线程是否在等待获取锁：——>" + reentrantLock.hasQueuedThread(Thread.currentThread()));// 查询指定线程是否在等待获取锁

        } finally {
            reentrantLock.unlock();  // 当前线程释放一次锁
        }


    }
}
