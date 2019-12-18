package thread_safe;

/**
 * 奇数线程和偶数线程，奇数线程打印奇数，偶数线程打印偶数
 * @author QiaoGuanHui
 * @date 2019/12/18-9:19
 */
public class Thread_communicate {
    public static int i =0;
    public static Object obj = new Object();
    public static void main(String[] args) {
        System.out.println("*******************");
        ThreadUtil t = new ThreadUtil();
        EvenThread eve = new EvenThread(t);
        ObbThread obb = new ObbThread(t);
        Thread thread1 = new Thread(eve);
        Thread thread2 = new Thread(obb);
        thread1.start();
        thread2.start();



       /* final Thread_communicate com = new Thread_communicate();
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
        thread2.start();*/
    }
    /**
     * 打印奇数
     */
    public void obb(){
        //打印奇数
        while (i<10){
            System.out.println("进入奇数线程打印");
            synchronized (obj){

                if(i%2==1){
                    System.out.println("奇数线程打印了:"+i);
                    i++;
                    try {
                        obj.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }
    /**
     * 打印偶数
     */
    public void even(){
        //打印偶数
        while (i < 10) {
            synchronized (obj) {
                if (i % 2 == 0) {
                    System.out.println("偶数线程打印了:" + i);
                    i++;
                    try {
                        obj.notify();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        obj.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

}


