package thread_safe;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author QiaoGuanHui
 * @date 2019/12/16-19:03
 */
public class ReentranLock_demo implements Runnable{

    private int ticketNum = 100;//电影票的数量
    //ReenteanLock 是同步锁中的重入锁，实现方式是先创建一个锁
    private Lock lock = new ReentrantLock(true);//参数当传入true时，为公平锁；每个线程公平竞争，一个线程拿到锁后，
    // 执行一段时间会释放，当传入参数为false时，为独占锁。此时只有等该线程执行完，或者释放锁其他线程才能拿到锁

    //使用时，先调用锁的lock方法。然后将同步代码块放入try中，在finally中调用unLock方法，不然会形成死锁


    public void run() {
        lock.lock();
        try {
            while(true) {//如有票，则售卖
                //加同步代码块锁

                    if(ticketNum>0){

                        Thread.sleep(200);
                        System.out.println("当前"+Thread.currentThread().getName()+"窗口，售卖了："+ticketNum--);
                    }

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock(); //一定要调用unlock方法
        }

    }
}
