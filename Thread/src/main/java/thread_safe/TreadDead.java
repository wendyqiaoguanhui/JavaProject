package thread_safe;

/**
 * @author QiaoGuanHui
 * @date 2019/12/17-19:17
 */
public class TreadDead  implements Runnable{
    //创建共享资源，锁对象，注意要是Static的
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();
    //创建boolean flag 控制线程走向
    private int  flag ;

    public TreadDead(int flag){
        this.flag = flag;
    }

    public void run() {
        if(flag == 0){
            //让其保持一个线程
                synchronized (obj1){
                    try {
                        System.out.println(Thread.currentThread().getName()+"获得了锁对象obj1");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //让线程请求obj2对象锁
                    synchronized (obj2){
                        System.out.println(Thread.currentThread().getName()+"请求锁对象obj2");

                    }

            }
        }else{

            //让其保持一个线程
            synchronized (obj2){
                try {
                    System.out.println(Thread.currentThread().getName()+"获得了锁对象obj2");
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //让线程请求obj2对象锁
                synchronized (obj1){
                    System.out.println(Thread.currentThread().getName()+"请求锁对象obj1");

                }

            }
        }

    }
}
