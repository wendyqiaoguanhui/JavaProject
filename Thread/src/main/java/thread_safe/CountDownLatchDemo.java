package thread_safe;

import java.util.concurrent.CountDownLatch;

/**
 * 模拟教练等待，三个运动员到场且准备好后，才开始训练
 * @author QiaoGuanHui
 * @date 2019/12/18-15:30
 */
public class CountDownLatchDemo {
    //首先新建countDownLatch对象,3代表等待三个线程（3个运动员）
    private CountDownLatch countDownLatch = new CountDownLatch(3);

    //运动员调用
    public void racer(){
        //获取运动员线程信息，并打印
        System.out.println(Thread.currentThread().getName()+"开始准备");
        //线程睡眠
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印准备好。countDownLatch线程减一
        System.out.println(Thread.currentThread().getName()+"准备好了");
        countDownLatch.countDown();


    }

    //教练调用
    public void cach(){
        System.out.println(Thread.currentThread().getName()+"等待运动员准备");
        //调用await方法等待，当减为一后自动唤醒，然后执行
        try {

            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("所有运动员准备就绪，开始运动");
    }


    public static void main(String[] args) {
        final CountDownLatchDemo countDownLatchDemo = new CountDownLatchDemo();
        //创建线程
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                countDownLatchDemo.racer();
            }
        },"运动员1");

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                countDownLatchDemo.racer();
            }
        },"运动员2");
        Thread thread3 = new Thread(new Runnable() {
            public void run() {
                countDownLatchDemo.racer();
            }
        },"运动员3");
        //教练线程
        Thread thread4 = new Thread(new Runnable() {
            public void run() {
                countDownLatchDemo.cach();
            }
        },"教练");

        thread4.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
