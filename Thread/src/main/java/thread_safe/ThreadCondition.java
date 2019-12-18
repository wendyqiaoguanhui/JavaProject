package thread_safe;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author QiaoGuanHui
 * @date 2019/12/18-14:01
 */
public class ThreadCondition {
    private int i=0;
    private Lock lock = new ReentrantLock(false);
    private Condition condition = lock.newCondition();
    public static void main(String[] args) {
        final ThreadCondition com = new ThreadCondition();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
               com.obb();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                com.even();
            }
        });
        thread1.start();
        thread2.start();
    }

    /**
     * 打印奇数
     */
    public void obb(){
        //打印奇数
        while (i<10){
            lock.lock();
            try{

                System.out.println("进入奇数线程打印");

                if(i%2==1){
                    System.out.println("奇数线程打印了:"+i);
                    i++;
                    try {
                        condition.signal();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }

        }

    }
    /**
     * 打印偶数
     */
    public void even(){
        //打印偶数
        while (i < 10) {
            lock.lock();
            try{

                if (i % 2 == 0) {
                    System.out.println("偶数线程打印了:" + i);
                    i++;
                    try {
                        condition.signal();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        condition.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }finally {
                lock.unlock();
            }

        }
    }

}
